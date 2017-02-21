package questions

import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by huangzhibo on 15/02/2017.
  */
class VenomSqlSpec extends PlaySpec with OneServerPerSuite{

    private val LOG = org.slf4j.LoggerFactory.getLogger(this.getClass)

    val orgDao = app.injector.instanceOf[VenomSql]

    "test sql" should {

        "apply sql test" in {
            val cusId = "12962"
            val queryData = OrgInfoGridData(1, 10, None, None, None, None, None, None, None)
            val result = Await.result(orgDao.listData(cusId, queryData), Duration.Inf)
            LOG.info(s"总共有：${result._1}条记录")
            result._2.foreach{
                data =>
                    println(data)
            }
        }

        "apply sql test1" in {
            val cusId = "12962"
            val queryData = OrgInfoGridData(1, 10, None, None, None, None, None, None, None)
            val result = Await.result(orgDao.listData1(cusId, queryData), Duration.Inf)
            LOG.info(s"总共有：${result._1}条记录")
            result._2.foreach{
                data =>
                    println(data)
            }
        }

    }
}
