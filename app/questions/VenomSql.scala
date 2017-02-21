package questions

import java.sql.Timestamp
import java.text.SimpleDateFormat

import com.anubis.practise.models.Tables._
import com.anubis.practise.models.Tables.profile.api._
import com.google.inject.{Inject, Singleton}
import providers.DBProvider

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by huangzhibo on 15/02/2017.
  */
case class OrgInfoGridData(current: Int, rowCount: Int, clientName: Option[String], applyStart: Option[String], applyFinish: Option[String],
                           phoneNumber: Option[String], statusBegin: Option[String], statusEnd: Option[String], orderStatus: Option[String])

case class OrgInfoTemplate (applyId: String, clientName: Option[String], phoneNumber: String, applyDate: Timestamp,
                            statusChangeTime: Timestamp, applyMoney: Int, eduCheck: Option[Int], operateStatus: Option[String], applyScenario: String,
                            loanDate: Timestamp, loanMoney: Int
                           )

case class OrgInfoTemplate1 (applyId: String, clientName: Option[String], phoneNumber: String, applyDate: Timestamp,
                            statusChangeTime: Timestamp, applyMoney: Int, eduCheck: Option[Int], operateStatus: Option[String], applyScenario: String,
                            loanDate: Option[Timestamp], loanMoney: Int
                           )

@Singleton
class VenomSql @Inject()(dBProvider: DBProvider)(implicit ec: ExecutionContext){

    private val LOG = org.slf4j.LoggerFactory.getLogger(this.getClass)
    lazy val ORDER_STATUS = Seq(1022,1031,1032,1033,1034,1037,1038,1040,1041,1042,1043,1046,1130)
    lazy val NON_DELETE = 0
    lazy val EDU_CHECK = Seq(2, 8)
    lazy val CONFIG_TYPE = "teacherStatus"
    lazy val APP_STATUS_CACHE = Seq("9", "10", "11", "12", "13", "14", "15", "19", "20", "22", "23")

    def convertTimestamp(dateStr: String) = {
        val dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val parsedDate = dateFormat.parse(dateStr + " 00:00:00")
        val timestamp = new java.sql.Timestamp(parsedDate.getTime())
        timestamp
    }

    private def OrgInfoQuery(cusId: String, statusBeginTime: Option[String], statusEndTime: Option[String], applyStartDate: Option[String],
                             applyFinishDate: Option[String], phone: Option[String], userName: Option[String], orderStatus: Option[String]) = {

        val orderAction = TOrdersYxd.filter(o => o.status.inSetBind(ORDER_STATUS)).groupBy(_.applyId) map {
            case (applyId, list) => list.map(_.id).max
        } join TOrdersYxd.filter(o =>
            statusBeginTime.map(o.createTime >= convertTimestamp(_)).getOrElse(true: Rep[Boolean]) &&
                statusEndTime.map(o.createTime < convertTimestamp(_)).getOrElse(true: Rep[Boolean])
        ) on ((id, od) => id === od.id)

        val applyAction = orderAction join TApplyYxd.filter(a =>
            a.deleted === NON_DELETE &&
                applyStartDate.map(a.createTime >= convertTimestamp(_)).getOrElse(true: Rep[Boolean]) &&
                applyFinishDate.map(a.createTime < convertTimestamp(_)).getOrElse(true: Rep[Boolean])
        ) on ((o, a) =>
            o._2.uuid === a.orderUuid && a.cusid === cusId
            )

        val contractAction = applyAction join (TContractYxd.groupBy(_.orderUuid) map {
            case (orderUuid, list) => list.map(c => c.id).max
        } join TContractYxd on (_ === _.id) map (_._2)) on ((f, c) => f._1._2.uuid === c.orderUuid)

        val userAction = contractAction join TUsers.filter(e =>
            e.validate === NON_DELETE &&
                phone.map(e.phoneNumber === _).getOrElse(true: Rep[Boolean]) &&
                userName.map(e.realName === _).getOrElse(e.realName.nonEmpty: Rep[Option[Boolean]])
        ) on ((f, u) => f._1._1._2.userUuid === u.uuid)

        val checkInfoAction = userAction join
            TCheckInfo.filter(c => c.deleted === NON_DELETE && c.checkedType.inSetBind(EDU_CHECK)) on ((f, c) => f._1._1._1._2.userUuid === c.userId)

        val statusAction = checkInfoAction join TAppStatusCache on ((f, s) => f._1._1._1._1._2.applyId === s.applyId)

        val configAction = statusAction join TConfig.filter(c =>
            orderStatus.map(c.value === _).getOrElse(Option(true): Rep[Option[Boolean]])
        ) on ((s, c) => s._2.appStatus === c.key && c.`type` === CONFIG_TYPE)

        configAction
    }

    /**
      * 机构查询，列表数据
      * @param cusId
      * @param data
      * @return
      */
    def listData(cusId: String, data: OrgInfoGridData): Future[(Int, Seq[OrgInfoTemplate])] = {
        LOG.info(s"查看参数：current: $data")
        val current = data.current
        val rowCount = data.rowCount
        val applyStartDate = data.applyStart
        val applyFinishDate = data.applyFinish
        val phone = data.phoneNumber
        val userName = data.clientName
        val statusBeginTime = data.statusBegin
        val statusEndTime = data.statusEnd
        val orderStatus = data.orderStatus

        val lastAction = OrgInfoQuery(cusId, statusBeginTime, statusEndTime,
            applyStartDate, applyFinishDate, phone, userName, orderStatus)

        val actionSize = lastAction.size
        val startIndex = (current - 1) * rowCount

        val dataAction = lastAction drop startIndex take rowCount map {
            case (((((((id,order), apply), contract), user), checkInfo), statusCache), config) =>
                (order.applyId, user.realName, user.phoneNumber, apply.createTime, order.createTime,
                    apply.money, checkInfo.checked, config.value, apply.productName, contract.loanRequestDate, apply.money) <> ((OrgInfoTemplate.apply _).tupled, OrgInfoTemplate.unapply)
        }

        dBProvider.dbRun(
            for {
                total <- actionSize.result
                data <- dataAction.result
            } yield {
                (total, data)
            }
        )
    }


    //----------------------------------------------修改后------------------------------------------------//

    private def orderAction(statusBeginTime: Option[String], statusEndTime: Option[String]): Query[(Rep[Option[Int]], TOrdersYxd), (Option[Int], TOrdersYxdRow), Seq] = {
        TOrdersYxd.groupBy(_.applyId) map {
            case (applyId, list) => list.map(_.id).max
        } join TOrdersYxd.filter(o =>
            statusBeginTime.map(o.createTime >= convertTimestamp(_)).getOrElse(true: Rep[Boolean]) &&
                statusEndTime.map(o.createTime < convertTimestamp(_)).getOrElse(true: Rep[Boolean])
        ) on ((id, od) => id === od.id)
    }

    private def OrgInfoQuery1(cusId: String, statusBeginTime: Option[String], statusEndTime: Option[String], applyStartDate: Option[String],
                             applyFinishDate: Option[String], phone: Option[String], userName: Option[String], orderStatus: Option[String]) = {

        val applyAction = orderAction(statusBeginTime, statusEndTime) join TApplyYxd.filter(a =>
            a.deleted === NON_DELETE &&
                applyStartDate.map(a.createTime >= convertTimestamp(_)).getOrElse(true: Rep[Boolean]) &&
                applyFinishDate.map(a.createTime < convertTimestamp(_)).getOrElse(true: Rep[Boolean])
        ) on ((o, a) =>
            o._2.uuid === a.orderUuid && a.cusid === cusId
            )

        val contractAction = applyAction joinLeft (TContractYxd.groupBy(_.orderUuid) map {
            case (orderUuid, list) => list.map(c => c.id).max
        } join TContractYxd on (_ === _.id) map (_._2)) on ((f, c) => f._1._2.uuid === c.orderUuid)

        val userAction = contractAction join TUsers.filter(e =>
            e.validate === NON_DELETE &&
                phone.map(e.phoneNumber === _).getOrElse(true: Rep[Boolean]) &&
                userName.map(e.realName === _).getOrElse(e.realName.nonEmpty.?)
        ) on ((f, u) => f._1._1._2.userUuid === u.uuid)

        val checkInfoAction = userAction joinLeft
            TCheckInfo.filter(c => c.deleted === NON_DELETE && c.checkedType.inSetBind(EDU_CHECK)) on ((f, c) => f._1._1._1._2.userUuid === c.userId)

        val statusAction = checkInfoAction join TAppStatusCache on ((f, s) => f._1._1._1._1._2.applyId === s.applyId && s.appStatus.inSet(APP_STATUS_CACHE))

        val configAction = statusAction join TConfig.filter(c =>
            orderStatus.map(c.value === _).getOrElse(Option(true): Rep[Option[Boolean]])
        ) on ((s, c) => s._2.appStatus === c.key && c.`type` === CONFIG_TYPE)

        configAction
    }

    def listData1(cusId: String, data: OrgInfoGridData): Future[(Int, Seq[OrgInfoTemplate1])] = {
        LOG.info(s"查看参数：current: $data")
        val current = data.current
        val rowCount = data.rowCount
        val applyStartDate = data.applyStart
        val applyFinishDate = data.applyFinish
        val phone = data.phoneNumber
        val userName = data.clientName
        val statusBeginTime = data.statusBegin
        val statusEndTime = data.statusEnd
        val orderStatus = data.orderStatus

        val lastAction = OrgInfoQuery1(cusId, statusBeginTime, statusEndTime,
            applyStartDate, applyFinishDate, phone, userName, orderStatus)

        val actionSize = lastAction.size
        val startIndex = (current - 1) * rowCount

        val dataAction = lastAction.sortBy(_._1._1._1._1._1._2.createTime.desc) drop startIndex take rowCount map {
            case (((((((id, order), apply), contract), user), checkInfo), statusCache), config) =>
                (order.applyId, user.realName, user.phoneNumber, apply.createTime, order.createTime,
                    apply.money, checkInfo.flatMap(_.checked), config.value, apply.productName, contract.map(_.loanRequestDate), apply.money) <> ((OrgInfoTemplate1.apply _).tupled, OrgInfoTemplate1.unapply)
        }

        dBProvider.dbRun(
            for {
                total <- actionSize.result
                data <- dataAction.result
            } yield {
                (total, data)
            }
        )
    }
    val explicitLeftOuterJoin = for {
        (c, s) <- Coffees joinLeft Suppliers on (_.supId === _.supId)
    } yield (c.cofName, s)

}
