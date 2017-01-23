package com.anubis.practise.models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Coffees.schema, Dba$sensitiveUserTab.schema, Dba$sensitiveUserTabCol.schema, DmMobile.schema, NewOrderId.schema, Suppliers.schema, TAdmin.schema, TAppDescriptionMapping.schema, TApplyYxd.schema, TAppStatusCache.schema, TAppStatusMapping.schema, TAuthority.schema, TBankCards.schema, TBankcardSupport.schema, TCheckInfo.schema, TCities.schema, TComplaints.schema, TConfig.schema, TConfigGroup.schema, TContactBooks.schema, TContacts.schema, TContentVersion.schema, TContractYxd.schema, TCourses.schema, TCreditResult.schema, TDailyInfo.schema, TDevices.schema, TEducations.schema, TEventLog.schema, TFamilyInfo.schema, TIdentityCards.schema, TLoanLog.schema, TLoanLog2.schema, TOperateLog.schema, TOrdersYxd.schema, TPushLog.schema, TRepayStatus.schema, TRole.schema, TRuleResults.schema, TSchools.schema, TSignway.schema, TSupplements.schema, TUserLiving.schema, TUsers.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Coffees
   *  @param cofName Database column COF_NAME SqlType(INT), PrimaryKey
   *  @param supId Database column SUP_ID SqlType(INT), Default(None)
   *  @param price Database column PRICE SqlType(DOUBLE), Default(None)
   *  @param sales Database column SALES SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param total Database column TOTAL SqlType(VARCHAR), Length(45,true), Default(None) */
  case class CoffeesRow(cofName: Int, supId: Option[Int] = None, price: Option[Double] = None, sales: Option[String] = None, total: Option[String] = None)
  /** GetResult implicit for fetching CoffeesRow objects using plain SQL queries */
  implicit def GetResultCoffeesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Double]], e3: GR[Option[String]]): GR[CoffeesRow] = GR{
    prs => import prs._
    CoffeesRow.tupled((<<[Int], <<?[Int], <<?[Double], <<?[String], <<?[String]))
  }
  /** Table description of table coffees. Objects of this class serve as prototypes for rows in queries. */
  class Coffees(_tableTag: Tag) extends Table[CoffeesRow](_tableTag, "coffees") {
    def * = (cofName, supId, price, sales, total) <> (CoffeesRow.tupled, CoffeesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(cofName), supId, price, sales, total).shaped.<>({r=>import r._; _1.map(_=> CoffeesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column COF_NAME SqlType(INT), PrimaryKey */
    val cofName: Rep[Int] = column[Int]("COF_NAME", O.PrimaryKey)
    /** Database column SUP_ID SqlType(INT), Default(None) */
    val supId: Rep[Option[Int]] = column[Option[Int]]("SUP_ID", O.Default(None))
    /** Database column PRICE SqlType(DOUBLE), Default(None) */
    val price: Rep[Option[Double]] = column[Option[Double]]("PRICE", O.Default(None))
    /** Database column SALES SqlType(VARCHAR), Length(45,true), Default(None) */
    val sales: Rep[Option[String]] = column[Option[String]]("SALES", O.Length(45,varying=true), O.Default(None))
    /** Database column TOTAL SqlType(VARCHAR), Length(45,true), Default(None) */
    val total: Rep[Option[String]] = column[Option[String]]("TOTAL", O.Length(45,varying=true), O.Default(None))

    /** Foreign key referencing Suppliers (database name SUP_FK) */
    lazy val suppliersFk = foreignKey("SUP_FK", supId, Suppliers)(r => Rep.Some(r.supId), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Coffees */
  lazy val Coffees = new TableQuery(tag => new Coffees(tag))

  /** Entity class storing rows of table Dba$sensitiveUserTab
   *  @param username Database column username SqlType(VARCHAR), Length(40,true), Default()
   *  @param tablename Database column tablename SqlType(VARCHAR), Length(40,true), Default()
   *  @param lastCheckTime Database column last_check_time SqlType(TIMESTAMP) */
  case class Dba$sensitiveUserTabRow(username: String = "", tablename: String = "", lastCheckTime: java.sql.Timestamp)
  /** GetResult implicit for fetching Dba$sensitiveUserTabRow objects using plain SQL queries */
  implicit def GetResultDba$sensitiveUserTabRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[Dba$sensitiveUserTabRow] = GR{
    prs => import prs._
    Dba$sensitiveUserTabRow.tupled((<<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table dba$sensitive_user_tab. Objects of this class serve as prototypes for rows in queries. */
  class Dba$sensitiveUserTab(_tableTag: Tag) extends Table[Dba$sensitiveUserTabRow](_tableTag, "dba$sensitive_user_tab") {
    def * = (username, tablename, lastCheckTime) <> (Dba$sensitiveUserTabRow.tupled, Dba$sensitiveUserTabRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(username), Rep.Some(tablename), Rep.Some(lastCheckTime)).shaped.<>({r=>import r._; _1.map(_=> Dba$sensitiveUserTabRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column username SqlType(VARCHAR), Length(40,true), Default() */
    val username: Rep[String] = column[String]("username", O.Length(40,varying=true), O.Default(""))
    /** Database column tablename SqlType(VARCHAR), Length(40,true), Default() */
    val tablename: Rep[String] = column[String]("tablename", O.Length(40,varying=true), O.Default(""))
    /** Database column last_check_time SqlType(TIMESTAMP) */
    val lastCheckTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_check_time")

    /** Primary key of Dba$sensitiveUserTab (database name dba$sensitive_user_tab_PK) */
    val pk = primaryKey("dba$sensitive_user_tab_PK", (username, tablename))
  }
  /** Collection-like TableQuery object for table Dba$sensitiveUserTab */
  lazy val Dba$sensitiveUserTab = new TableQuery(tag => new Dba$sensitiveUserTab(tag))

  /** Entity class storing rows of table Dba$sensitiveUserTabCol
   *  @param tablename Database column tablename SqlType(VARCHAR), Length(40,true), Default(None)
   *  @param colname Database column colname SqlType(VARCHAR), Length(40,true), Default(None) */
  case class Dba$sensitiveUserTabColRow(tablename: Option[String] = None, colname: Option[String] = None)
  /** GetResult implicit for fetching Dba$sensitiveUserTabColRow objects using plain SQL queries */
  implicit def GetResultDba$sensitiveUserTabColRow(implicit e0: GR[Option[String]]): GR[Dba$sensitiveUserTabColRow] = GR{
    prs => import prs._
    Dba$sensitiveUserTabColRow.tupled((<<?[String], <<?[String]))
  }
  /** Table description of table dba$sensitive_user_tab_col. Objects of this class serve as prototypes for rows in queries. */
  class Dba$sensitiveUserTabCol(_tableTag: Tag) extends Table[Dba$sensitiveUserTabColRow](_tableTag, "dba$sensitive_user_tab_col") {
    def * = (tablename, colname) <> (Dba$sensitiveUserTabColRow.tupled, Dba$sensitiveUserTabColRow.unapply)

    /** Database column tablename SqlType(VARCHAR), Length(40,true), Default(None) */
    val tablename: Rep[Option[String]] = column[Option[String]]("tablename", O.Length(40,varying=true), O.Default(None))
    /** Database column colname SqlType(VARCHAR), Length(40,true), Default(None) */
    val colname: Rep[Option[String]] = column[Option[String]]("colname", O.Length(40,varying=true), O.Default(None))

    /** Index over (tablename,colname) (database name i_user_tab_col) */
    val index1 = index("i_user_tab_col", (tablename, colname))
  }
  /** Collection-like TableQuery object for table Dba$sensitiveUserTabCol */
  lazy val Dba$sensitiveUserTabCol = new TableQuery(tag => new Dba$sensitiveUserTabCol(tag))

  /** Entity class storing rows of table DmMobile
   *  @param mobilearea Database column MobileArea SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param mobilenumber Database column MobileNumber SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param areacode Database column AreaCode SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param mobiletype Database column MobileType SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param id Database column ID SqlType(INT), PrimaryKey
   *  @param postcode Database column PostCode SqlType(VARCHAR), Length(255,true), Default(None) */
  case class DmMobileRow(mobilearea: Option[String] = None, mobilenumber: Option[String] = None, areacode: Option[String] = None, mobiletype: Option[String] = None, id: Int, postcode: Option[String] = None)
  /** GetResult implicit for fetching DmMobileRow objects using plain SQL queries */
  implicit def GetResultDmMobileRow(implicit e0: GR[Option[String]], e1: GR[Int]): GR[DmMobileRow] = GR{
    prs => import prs._
    DmMobileRow.tupled((<<?[String], <<?[String], <<?[String], <<?[String], <<[Int], <<?[String]))
  }
  /** Table description of table dm_mobile. Objects of this class serve as prototypes for rows in queries. */
  class DmMobile(_tableTag: Tag) extends Table[DmMobileRow](_tableTag, "dm_mobile") {
    def * = (mobilearea, mobilenumber, areacode, mobiletype, id, postcode) <> (DmMobileRow.tupled, DmMobileRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (mobilearea, mobilenumber, areacode, mobiletype, Rep.Some(id), postcode).shaped.<>({r=>import r._; _5.map(_=> DmMobileRow.tupled((_1, _2, _3, _4, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column MobileArea SqlType(VARCHAR), Length(255,true), Default(None) */
    val mobilearea: Rep[Option[String]] = column[Option[String]]("MobileArea", O.Length(255,varying=true), O.Default(None))
    /** Database column MobileNumber SqlType(VARCHAR), Length(255,true), Default(None) */
    val mobilenumber: Rep[Option[String]] = column[Option[String]]("MobileNumber", O.Length(255,varying=true), O.Default(None))
    /** Database column AreaCode SqlType(VARCHAR), Length(255,true), Default(None) */
    val areacode: Rep[Option[String]] = column[Option[String]]("AreaCode", O.Length(255,varying=true), O.Default(None))
    /** Database column MobileType SqlType(VARCHAR), Length(255,true), Default(None) */
    val mobiletype: Rep[Option[String]] = column[Option[String]]("MobileType", O.Length(255,varying=true), O.Default(None))
    /** Database column ID SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
    /** Database column PostCode SqlType(VARCHAR), Length(255,true), Default(None) */
    val postcode: Rep[Option[String]] = column[Option[String]]("PostCode", O.Length(255,varying=true), O.Default(None))

    /** Index over (mobilenumber) (database name mobile_number_idx) */
    val index1 = index("mobile_number_idx", mobilenumber)
  }
  /** Collection-like TableQuery object for table DmMobile */
  lazy val DmMobile = new TableQuery(tag => new DmMobile(tag))

  /** Entity class storing rows of table NewOrderId
   *  @param odId Database column od_id SqlType(INT), Default(None)
   *  @param odUuid Database column od_uuid SqlType(VARCHAR), Length(32,true) */
  case class NewOrderIdRow(odId: Option[Int] = None, odUuid: String)
  /** GetResult implicit for fetching NewOrderIdRow objects using plain SQL queries */
  implicit def GetResultNewOrderIdRow(implicit e0: GR[Option[Int]], e1: GR[String]): GR[NewOrderIdRow] = GR{
    prs => import prs._
    NewOrderIdRow.tupled((<<?[Int], <<[String]))
  }
  /** Table description of table new_order_id. Objects of this class serve as prototypes for rows in queries. */
  class NewOrderId(_tableTag: Tag) extends Table[NewOrderIdRow](_tableTag, "new_order_id") {
    def * = (odId, odUuid) <> (NewOrderIdRow.tupled, NewOrderIdRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (odId, Rep.Some(odUuid)).shaped.<>({r=>import r._; _2.map(_=> NewOrderIdRow.tupled((_1, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column od_id SqlType(INT), Default(None) */
    val odId: Rep[Option[Int]] = column[Option[Int]]("od_id", O.Default(None))
    /** Database column od_uuid SqlType(VARCHAR), Length(32,true) */
    val odUuid: Rep[String] = column[String]("od_uuid", O.Length(32,varying=true))
  }
  /** Collection-like TableQuery object for table NewOrderId */
  lazy val NewOrderId = new TableQuery(tag => new NewOrderId(tag))

  /** Entity class storing rows of table Suppliers
   *  @param supId Database column SUP_ID SqlType(INT), AutoInc, PrimaryKey
   *  @param supName Database column SUP_NAME SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param street Database column STREET SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param city Database column CITY SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param state Database column STATE SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param zip Database column ZIP SqlType(VARCHAR), Length(45,true), Default(None) */
  case class SuppliersRow(supId: Int, supName: Option[String] = None, street: Option[String] = None, city: Option[String] = None, state: Option[String] = None, zip: Option[String] = None)
  /** GetResult implicit for fetching SuppliersRow objects using plain SQL queries */
  implicit def GetResultSuppliersRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[SuppliersRow] = GR{
    prs => import prs._
    SuppliersRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table suppliers. Objects of this class serve as prototypes for rows in queries. */
  class Suppliers(_tableTag: Tag) extends Table[SuppliersRow](_tableTag, "suppliers") {
    def * = (supId, supName, street, city, state, zip) <> (SuppliersRow.tupled, SuppliersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(supId), supName, street, city, state, zip).shaped.<>({r=>import r._; _1.map(_=> SuppliersRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SUP_ID SqlType(INT), AutoInc, PrimaryKey */
    val supId: Rep[Int] = column[Int]("SUP_ID", O.AutoInc, O.PrimaryKey)
    /** Database column SUP_NAME SqlType(VARCHAR), Length(45,true), Default(None) */
    val supName: Rep[Option[String]] = column[Option[String]]("SUP_NAME", O.Length(45,varying=true), O.Default(None))
    /** Database column STREET SqlType(VARCHAR), Length(45,true), Default(None) */
    val street: Rep[Option[String]] = column[Option[String]]("STREET", O.Length(45,varying=true), O.Default(None))
    /** Database column CITY SqlType(VARCHAR), Length(45,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("CITY", O.Length(45,varying=true), O.Default(None))
    /** Database column STATE SqlType(VARCHAR), Length(45,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("STATE", O.Length(45,varying=true), O.Default(None))
    /** Database column ZIP SqlType(VARCHAR), Length(45,true), Default(None) */
    val zip: Rep[Option[String]] = column[Option[String]]("ZIP", O.Length(45,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Suppliers */
  lazy val Suppliers = new TableQuery(tag => new Suppliers(tag))

  /** Entity class storing rows of table TAdmin
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(None)
   *  @param modifyTime Database column modify_time SqlType(BIGINT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param password Database column password SqlType(VARCHAR), Length(32,true)
   *  @param orgId Database column org_id SqlType(VARCHAR), Length(32,true)
   *  @param roles Database column roles SqlType(VARCHAR), Length(32,true)
   *  @param remark Database column remark SqlType(VARCHAR), Length(32,true) */
  case class TAdminRow(id: Int, uuid: Option[String] = None, createTime: Option[Long] = None, modifyTime: Option[Long] = None, name: String, password: String, orgId: String, roles: String, remark: String)
  /** GetResult implicit for fetching TAdminRow objects using plain SQL queries */
  implicit def GetResultTAdminRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[String]): GR[TAdminRow] = GR{
    prs => import prs._
    TAdminRow.tupled((<<[Int], <<?[String], <<?[Long], <<?[Long], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table t_admin. Objects of this class serve as prototypes for rows in queries. */
  class TAdmin(_tableTag: Tag) extends Table[TAdminRow](_tableTag, "t_admin") {
    def * = (id, uuid, createTime, modifyTime, name, password, orgId, roles, remark) <> (TAdminRow.tupled, TAdminRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), uuid, createTime, modifyTime, Rep.Some(name), Rep.Some(password), Rep.Some(orgId), Rep.Some(roles), Rep.Some(remark)).shaped.<>({r=>import r._; _1.map(_=> TAdminRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true), Default(None) */
    val uuid: Rep[Option[String]] = column[Option[String]]("uuid", O.Length(32,varying=true), O.Default(None))
    /** Database column create_time SqlType(BIGINT), Default(None) */
    val createTime: Rep[Option[Long]] = column[Option[Long]]("create_time", O.Default(None))
    /** Database column modify_time SqlType(BIGINT), Default(None) */
    val modifyTime: Rep[Option[Long]] = column[Option[Long]]("modify_time", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column password SqlType(VARCHAR), Length(32,true) */
    val password: Rep[String] = column[String]("password", O.Length(32,varying=true))
    /** Database column org_id SqlType(VARCHAR), Length(32,true) */
    val orgId: Rep[String] = column[String]("org_id", O.Length(32,varying=true))
    /** Database column roles SqlType(VARCHAR), Length(32,true) */
    val roles: Rep[String] = column[String]("roles", O.Length(32,varying=true))
    /** Database column remark SqlType(VARCHAR), Length(32,true) */
    val remark: Rep[String] = column[String]("remark", O.Length(32,varying=true))

    /** Uniqueness Index over (uuid) (database name idx_t_admin_uuid) */
    val index1 = index("idx_t_admin_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TAdmin */
  lazy val TAdmin = new TableQuery(tag => new TAdmin(tag))

  /** Entity class storing rows of table TAppDescriptionMapping
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param appValue Database column app_value SqlType(VARCHAR), Length(10,true)
   *  @param auxCode Database column aux_code SqlType(VARCHAR), Length(10,true)
   *  @param isNeedEdu Database column is_need_edu SqlType(VARCHAR), Length(10,true)
   *  @param statusDesc Database column status_desc SqlType(VARCHAR), Length(128,true)
   *  @param auxDesc Database column aux_desc SqlType(VARCHAR), Length(128,true) */
  case class TAppDescriptionMappingRow(id: Int, appValue: String, auxCode: String, isNeedEdu: String, statusDesc: String, auxDesc: String)
  /** GetResult implicit for fetching TAppDescriptionMappingRow objects using plain SQL queries */
  implicit def GetResultTAppDescriptionMappingRow(implicit e0: GR[Int], e1: GR[String]): GR[TAppDescriptionMappingRow] = GR{
    prs => import prs._
    TAppDescriptionMappingRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table t_app_description_mapping. Objects of this class serve as prototypes for rows in queries. */
  class TAppDescriptionMapping(_tableTag: Tag) extends Table[TAppDescriptionMappingRow](_tableTag, "t_app_description_mapping") {
    def * = (id, appValue, auxCode, isNeedEdu, statusDesc, auxDesc) <> (TAppDescriptionMappingRow.tupled, TAppDescriptionMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(appValue), Rep.Some(auxCode), Rep.Some(isNeedEdu), Rep.Some(statusDesc), Rep.Some(auxDesc)).shaped.<>({r=>import r._; _1.map(_=> TAppDescriptionMappingRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column app_value SqlType(VARCHAR), Length(10,true) */
    val appValue: Rep[String] = column[String]("app_value", O.Length(10,varying=true))
    /** Database column aux_code SqlType(VARCHAR), Length(10,true) */
    val auxCode: Rep[String] = column[String]("aux_code", O.Length(10,varying=true))
    /** Database column is_need_edu SqlType(VARCHAR), Length(10,true) */
    val isNeedEdu: Rep[String] = column[String]("is_need_edu", O.Length(10,varying=true))
    /** Database column status_desc SqlType(VARCHAR), Length(128,true) */
    val statusDesc: Rep[String] = column[String]("status_desc", O.Length(128,varying=true))
    /** Database column aux_desc SqlType(VARCHAR), Length(128,true) */
    val auxDesc: Rep[String] = column[String]("aux_desc", O.Length(128,varying=true))

    /** Uniqueness Index over (appValue,auxCode) (database name mapKey) */
    val index1 = index("mapKey", (appValue, auxCode), unique=true)
  }
  /** Collection-like TableQuery object for table TAppDescriptionMapping */
  lazy val TAppDescriptionMapping = new TableQuery(tag => new TAppDescriptionMapping(tag))

  /** Row type of table TApplyYxd */
  type TApplyYxdRow = HCons[Int,HCons[String,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Int,HCons[String,HCons[String,HCons[Option[String],HCons[String,HCons[Int,HCons[Int,HCons[Int,HCons[Option[Double],HCons[Int,HCons[java.sql.Timestamp,HCons[java.sql.Timestamp,HCons[Option[String],HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[String,HCons[Option[Double],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for TApplyYxdRow providing default values if available in the database schema. */
  def TApplyYxdRow(id: Int, uuid: String, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, deleted: Int = 0, orgCode: String, orgName: String, courseName: Option[String] = None, productName: String, installmentNumber: Int = 6, money: Int = 0, productAmount: Int, repayMoney: Option[Double] = None, trainDuration: Int, startTime: java.sql.Timestamp, orgConfirmDate: java.sql.Timestamp, city: Option[String] = None, cityCode: String, orderUuid: String, gps: String, cusid: String, productId: String, schoolName: String, level: String, productinfoid: String, gpsDistance: Option[Double] = None, gpsOrg: Option[String] = None): TApplyYxdRow = {
    id :: uuid :: createTime :: modifyTime :: deleted :: orgCode :: orgName :: courseName :: productName :: installmentNumber :: money :: productAmount :: repayMoney :: trainDuration :: startTime :: orgConfirmDate :: city :: cityCode :: orderUuid :: gps :: cusid :: productId :: schoolName :: level :: productinfoid :: gpsDistance :: gpsOrg :: HNil
  }
  /** GetResult implicit for fetching TApplyYxdRow objects using plain SQL queries */
  implicit def GetResultTApplyYxdRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Option[Double]]): GR[TApplyYxdRow] = GR{
    prs => import prs._
    <<[Int] :: <<[String] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<[Int] :: <<[String] :: <<[String] :: <<?[String] :: <<[String] :: <<[Int] :: <<[Int] :: <<[Int] :: <<?[Double] :: <<[Int] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<?[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<?[Double] :: <<?[String] :: HNil
  }
  /** Table description of table t_apply_yxd. Objects of this class serve as prototypes for rows in queries. */
  class TApplyYxd(_tableTag: Tag) extends Table[TApplyYxdRow](_tableTag, "t_apply_yxd") {
    def * = id :: uuid :: createTime :: modifyTime :: deleted :: orgCode :: orgName :: courseName :: productName :: installmentNumber :: money :: productAmount :: repayMoney :: trainDuration :: startTime :: orgConfirmDate :: city :: cityCode :: orderUuid :: gps :: cusid :: productId :: schoolName :: level :: productinfoid :: gpsDistance :: gpsOrg :: HNil

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column org_code SqlType(VARCHAR), Length(32,true) */
    val orgCode: Rep[String] = column[String]("org_code", O.Length(32,varying=true))
    /** Database column org_name SqlType(VARCHAR), Length(60,true) */
    val orgName: Rep[String] = column[String]("org_name", O.Length(60,varying=true))
    /** Database column course_name SqlType(VARCHAR), Length(45,true), Default(None) */
    val courseName: Rep[Option[String]] = column[Option[String]]("course_name", O.Length(45,varying=true), O.Default(None))
    /** Database column product_name SqlType(VARCHAR), Length(45,true) */
    val productName: Rep[String] = column[String]("product_name", O.Length(45,varying=true))
    /** Database column installment_number SqlType(INT), Default(6) */
    val installmentNumber: Rep[Int] = column[Int]("installment_number", O.Default(6))
    /** Database column money SqlType(INT), Default(0) */
    val money: Rep[Int] = column[Int]("money", O.Default(0))
    /** Database column product_amount SqlType(INT) */
    val productAmount: Rep[Int] = column[Int]("product_amount")
    /** Database column repay_money SqlType(DOUBLE), Default(None) */
    val repayMoney: Rep[Option[Double]] = column[Option[Double]]("repay_money", O.Default(None))
    /** Database column train_duration SqlType(INT) */
    val trainDuration: Rep[Int] = column[Int]("train_duration")
    /** Database column start_time SqlType(DATETIME) */
    val startTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("start_time")
    /** Database column org_confirm_date SqlType(DATETIME) */
    val orgConfirmDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("org_confirm_date")
    /** Database column city SqlType(VARCHAR), Length(45,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Length(45,varying=true), O.Default(None))
    /** Database column city_code SqlType(VARCHAR), Length(45,true) */
    val cityCode: Rep[String] = column[String]("city_code", O.Length(45,varying=true))
    /** Database column order_uuid SqlType(VARCHAR), Length(45,true) */
    val orderUuid: Rep[String] = column[String]("order_uuid", O.Length(45,varying=true))
    /** Database column gps SqlType(VARCHAR), Length(100,true) */
    val gps: Rep[String] = column[String]("gps", O.Length(100,varying=true))
    /** Database column cusId SqlType(VARCHAR), Length(45,true) */
    val cusid: Rep[String] = column[String]("cusId", O.Length(45,varying=true))
    /** Database column product_id SqlType(VARCHAR), Length(45,true) */
    val productId: Rep[String] = column[String]("product_id", O.Length(45,varying=true))
    /** Database column school_name SqlType(VARCHAR), Length(45,true) */
    val schoolName: Rep[String] = column[String]("school_name", O.Length(45,varying=true))
    /** Database column level SqlType(VARCHAR), Length(45,true) */
    val level: Rep[String] = column[String]("level", O.Length(45,varying=true))
    /** Database column productInfoId SqlType(VARCHAR), Length(45,true) */
    val productinfoid: Rep[String] = column[String]("productInfoId", O.Length(45,varying=true))
    /** Database column gps_distance SqlType(DOUBLE), Default(None) */
    val gpsDistance: Rep[Option[Double]] = column[Option[Double]]("gps_distance", O.Default(None))
    /** Database column gps_org SqlType(VARCHAR), Length(100,true), Default(None) */
    val gpsOrg: Rep[Option[String]] = column[Option[String]]("gps_org", O.Length(100,varying=true), O.Default(None))

    /** Index over (uuid) (database name idx_t_loan_apply_uuid) */
    val index1 = index("idx_t_loan_apply_uuid", uuid :: HNil)
    /** Index over (orderUuid) (database name idx_t_loan_order_uuid) */
    val index2 = index("idx_t_loan_order_uuid", orderUuid :: HNil)
  }
  /** Collection-like TableQuery object for table TApplyYxd */
  lazy val TApplyYxd = new TableQuery(tag => new TApplyYxd(tag))

  /** Entity class storing rows of table TAppStatusCache
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param applyId Database column apply_id SqlType(VARCHAR), Length(45,true)
   *  @param appStatus Database column app_status SqlType(VARCHAR), Length(10,true)
   *  @param statusDescribe Database column status_describe SqlType(VARCHAR), Length(60,true) */
  case class TAppStatusCacheRow(id: Int, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, applyId: String, appStatus: String, statusDescribe: String)
  /** GetResult implicit for fetching TAppStatusCacheRow objects using plain SQL queries */
  implicit def GetResultTAppStatusCacheRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String]): GR[TAppStatusCacheRow] = GR{
    prs => import prs._
    TAppStatusCacheRow.tupled((<<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[String]))
  }
  /** Table description of table t_app_status_cache. Objects of this class serve as prototypes for rows in queries. */
  class TAppStatusCache(_tableTag: Tag) extends Table[TAppStatusCacheRow](_tableTag, "t_app_status_cache") {
    def * = (id, createTime, modifyTime, applyId, appStatus, statusDescribe) <> (TAppStatusCacheRow.tupled, TAppStatusCacheRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(applyId), Rep.Some(appStatus), Rep.Some(statusDescribe)).shaped.<>({r=>import r._; _1.map(_=> TAppStatusCacheRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column apply_id SqlType(VARCHAR), Length(45,true) */
    val applyId: Rep[String] = column[String]("apply_id", O.Length(45,varying=true))
    /** Database column app_status SqlType(VARCHAR), Length(10,true) */
    val appStatus: Rep[String] = column[String]("app_status", O.Length(10,varying=true))
    /** Database column status_describe SqlType(VARCHAR), Length(60,true) */
    val statusDescribe: Rep[String] = column[String]("status_describe", O.Length(60,varying=true))

    /** Uniqueness Index over (applyId) (database name apply_id_UNIQUE) */
    val index1 = index("apply_id_UNIQUE", applyId, unique=true)
  }
  /** Collection-like TableQuery object for table TAppStatusCache */
  lazy val TAppStatusCache = new TableQuery(tag => new TAppStatusCache(tag))

  /** Entity class storing rows of table TAppStatusMapping
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param ruleResult Database column rule_result SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param repaymentStatus Database column repayment_status SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param creditCheckResult Database column credit_check_result SqlType(VARCHAR), Length(16,true), Default(None)
   *  @param checkInfo Database column check_info SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param signWay Database column sign_way SqlType(VARCHAR), Length(16,true), Default(None)
   *  @param appStatus Database column app_status SqlType(VARCHAR), Length(10,true)
   *  @param statusDescribe Database column status_describe SqlType(VARCHAR), Length(60,true)
   *  @param hasBankcard Database column has_bankcard SqlType(VARCHAR), Length(32,true), Default(0)
   *  @param isNeedEdu Database column is_need_edu SqlType(VARCHAR), Length(32,true), Default(1)
   *  @param auxCode Database column aux_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param auxCodeDesc Database column aux_code_desc SqlType(VARCHAR), Length(60,true), Default(None)
   *  @param priority Database column priority SqlType(INT)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME) */
  case class TAppStatusMappingRow(id: Int, uuid: String, ruleResult: Option[String] = None, repaymentStatus: Option[String] = None, creditCheckResult: Option[String] = None, checkInfo: Option[String] = None, signWay: Option[String] = None, appStatus: String, statusDescribe: String, hasBankcard: String = "0", isNeedEdu: String = "1", auxCode: Option[String] = None, auxCodeDesc: Option[String] = None, priority: Int, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp)
  /** GetResult implicit for fetching TAppStatusMappingRow objects using plain SQL queries */
  implicit def GetResultTAppStatusMappingRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[TAppStatusMappingRow] = GR{
    prs => import prs._
    TAppStatusMappingRow.tupled((<<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table t_app_status_mapping. Objects of this class serve as prototypes for rows in queries. */
  class TAppStatusMapping(_tableTag: Tag) extends Table[TAppStatusMappingRow](_tableTag, "t_app_status_mapping") {
    def * = (id, uuid, ruleResult, repaymentStatus, creditCheckResult, checkInfo, signWay, appStatus, statusDescribe, hasBankcard, isNeedEdu, auxCode, auxCodeDesc, priority, createTime, modifyTime) <> (TAppStatusMappingRow.tupled, TAppStatusMappingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), ruleResult, repaymentStatus, creditCheckResult, checkInfo, signWay, Rep.Some(appStatus), Rep.Some(statusDescribe), Rep.Some(hasBankcard), Rep.Some(isNeedEdu), auxCode, auxCodeDesc, Rep.Some(priority), Rep.Some(createTime), Rep.Some(modifyTime)).shaped.<>({r=>import r._; _1.map(_=> TAppStatusMappingRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8.get, _9.get, _10.get, _11.get, _12, _13, _14.get, _15.get, _16.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column rule_result SqlType(VARCHAR), Length(50,true), Default(None) */
    val ruleResult: Rep[Option[String]] = column[Option[String]]("rule_result", O.Length(50,varying=true), O.Default(None))
    /** Database column repayment_status SqlType(VARCHAR), Length(32,true), Default(None) */
    val repaymentStatus: Rep[Option[String]] = column[Option[String]]("repayment_status", O.Length(32,varying=true), O.Default(None))
    /** Database column credit_check_result SqlType(VARCHAR), Length(16,true), Default(None) */
    val creditCheckResult: Rep[Option[String]] = column[Option[String]]("credit_check_result", O.Length(16,varying=true), O.Default(None))
    /** Database column check_info SqlType(VARCHAR), Length(100,true), Default(None) */
    val checkInfo: Rep[Option[String]] = column[Option[String]]("check_info", O.Length(100,varying=true), O.Default(None))
    /** Database column sign_way SqlType(VARCHAR), Length(16,true), Default(None) */
    val signWay: Rep[Option[String]] = column[Option[String]]("sign_way", O.Length(16,varying=true), O.Default(None))
    /** Database column app_status SqlType(VARCHAR), Length(10,true) */
    val appStatus: Rep[String] = column[String]("app_status", O.Length(10,varying=true))
    /** Database column status_describe SqlType(VARCHAR), Length(60,true) */
    val statusDescribe: Rep[String] = column[String]("status_describe", O.Length(60,varying=true))
    /** Database column has_bankcard SqlType(VARCHAR), Length(32,true), Default(0) */
    val hasBankcard: Rep[String] = column[String]("has_bankcard", O.Length(32,varying=true), O.Default("0"))
    /** Database column is_need_edu SqlType(VARCHAR), Length(32,true), Default(1) */
    val isNeedEdu: Rep[String] = column[String]("is_need_edu", O.Length(32,varying=true), O.Default("1"))
    /** Database column aux_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val auxCode: Rep[Option[String]] = column[Option[String]]("aux_code", O.Length(32,varying=true), O.Default(None))
    /** Database column aux_code_desc SqlType(VARCHAR), Length(60,true), Default(None) */
    val auxCodeDesc: Rep[Option[String]] = column[Option[String]]("aux_code_desc", O.Length(60,varying=true), O.Default(None))
    /** Database column priority SqlType(INT) */
    val priority: Rep[Int] = column[Int]("priority")
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
  }
  /** Collection-like TableQuery object for table TAppStatusMapping */
  lazy val TAppStatusMapping = new TableQuery(tag => new TAppStatusMapping(tag))

  /** Entity class storing rows of table TAuthority
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(None)
   *  @param modifyTime Database column modify_time SqlType(BIGINT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(32,true)
   *  @param content Database column content SqlType(VARCHAR), Length(32,true) */
  case class TAuthorityRow(id: Int, uuid: Option[String] = None, createTime: Option[Long] = None, modifyTime: Option[Long] = None, name: String, `type`: String, content: String)
  /** GetResult implicit for fetching TAuthorityRow objects using plain SQL queries */
  implicit def GetResultTAuthorityRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[String]): GR[TAuthorityRow] = GR{
    prs => import prs._
    TAuthorityRow.tupled((<<[Int], <<?[String], <<?[Long], <<?[Long], <<[String], <<[String], <<[String]))
  }
  /** Table description of table t_authority. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TAuthority(_tableTag: Tag) extends Table[TAuthorityRow](_tableTag, "t_authority") {
    def * = (id, uuid, createTime, modifyTime, name, `type`, content) <> (TAuthorityRow.tupled, TAuthorityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), uuid, createTime, modifyTime, Rep.Some(name), Rep.Some(`type`), Rep.Some(content)).shaped.<>({r=>import r._; _1.map(_=> TAuthorityRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true), Default(None) */
    val uuid: Rep[Option[String]] = column[Option[String]]("uuid", O.Length(32,varying=true), O.Default(None))
    /** Database column create_time SqlType(BIGINT), Default(None) */
    val createTime: Rep[Option[Long]] = column[Option[Long]]("create_time", O.Default(None))
    /** Database column modify_time SqlType(BIGINT), Default(None) */
    val modifyTime: Rep[Option[Long]] = column[Option[Long]]("modify_time", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column type SqlType(VARCHAR), Length(32,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(32,varying=true))
    /** Database column content SqlType(VARCHAR), Length(32,true) */
    val content: Rep[String] = column[String]("content", O.Length(32,varying=true))

    /** Uniqueness Index over (uuid) (database name idx_t_authority_uuid) */
    val index1 = index("idx_t_authority_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TAuthority */
  lazy val TAuthority = new TableQuery(tag => new TAuthority(tag))

  /** Entity class storing rows of table TBankCards
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param bankCardNumber Database column bank_card_number SqlType(VARCHAR), Length(30,true), Default()
   *  @param bankName Database column bank_name SqlType(VARCHAR), Length(32,true), Default()
   *  @param cardType Database column card_type SqlType(VARCHAR), Length(2,true), Default(Some(0))
   *  @param bankCode Database column bank_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param bankFullName Database column bank_full_name SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param cityCode Database column city_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param cityName Database column city_name SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param validDate Database column valid_date SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param frontImage Database column front_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param phoneNumber Database column phone_number SqlType(VARCHAR), Length(30,true), Default(None) */
  case class TBankCardsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, bankCardNumber: String = "", bankName: String = "", cardType: Option[String] = Some("0"), bankCode: Option[String] = None, bankFullName: Option[String] = None, cityCode: Option[String] = None, cityName: Option[String] = None, address: Option[String] = None, validDate: Option[String] = None, frontImage: Option[String] = None, phoneNumber: Option[String] = None)
  /** GetResult implicit for fetching TBankCardsRow objects using plain SQL queries */
  implicit def GetResultTBankCardsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TBankCardsRow] = GR{
    prs => import prs._
    TBankCardsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table t_bank_cards. Objects of this class serve as prototypes for rows in queries. */
  class TBankCards(_tableTag: Tag) extends Table[TBankCardsRow](_tableTag, "t_bank_cards") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, bankCardNumber, bankName, cardType, bankCode, bankFullName, cityCode, cityName, address, validDate, frontImage, phoneNumber) <> (TBankCardsRow.tupled, TBankCardsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), Rep.Some(bankCardNumber), Rep.Some(bankName), cardType, bankCode, bankFullName, cityCode, cityName, address, validDate, frontImage, phoneNumber).shaped.<>({r=>import r._; _1.map(_=> TBankCardsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column bank_card_number SqlType(VARCHAR), Length(30,true), Default() */
    val bankCardNumber: Rep[String] = column[String]("bank_card_number", O.Length(30,varying=true), O.Default(""))
    /** Database column bank_name SqlType(VARCHAR), Length(32,true), Default() */
    val bankName: Rep[String] = column[String]("bank_name", O.Length(32,varying=true), O.Default(""))
    /** Database column card_type SqlType(VARCHAR), Length(2,true), Default(Some(0)) */
    val cardType: Rep[Option[String]] = column[Option[String]]("card_type", O.Length(2,varying=true), O.Default(Some("0")))
    /** Database column bank_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val bankCode: Rep[Option[String]] = column[Option[String]]("bank_code", O.Length(32,varying=true), O.Default(None))
    /** Database column bank_full_name SqlType(VARCHAR), Length(200,true), Default(None) */
    val bankFullName: Rep[Option[String]] = column[Option[String]]("bank_full_name", O.Length(200,varying=true), O.Default(None))
    /** Database column city_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val cityCode: Rep[Option[String]] = column[Option[String]]("city_code", O.Length(32,varying=true), O.Default(None))
    /** Database column city_name SqlType(VARCHAR), Length(200,true), Default(None) */
    val cityName: Rep[Option[String]] = column[Option[String]]("city_name", O.Length(200,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(300,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(300,varying=true), O.Default(None))
    /** Database column valid_date SqlType(VARCHAR), Length(30,true), Default(None) */
    val validDate: Rep[Option[String]] = column[Option[String]]("valid_date", O.Length(30,varying=true), O.Default(None))
    /** Database column front_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val frontImage: Rep[Option[String]] = column[Option[String]]("front_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column phone_number SqlType(VARCHAR), Length(30,true), Default(None) */
    val phoneNumber: Rep[Option[String]] = column[Option[String]]("phone_number", O.Length(30,varying=true), O.Default(None))

    /** Uniqueness Index over (uuid) (database name idx_t_bank_cards_uuid) */
    val index1 = index("idx_t_bank_cards_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TBankCards */
  lazy val TBankCards = new TableQuery(tag => new TBankCards(tag))

  /** Entity class storing rows of table TBankcardSupport
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(64,true)
   *  @param code Database column code SqlType(INT)
   *  @param logourl Database column logourl SqlType(VARCHAR), Length(128,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0) */
  case class TBankcardSupportRow(id: Int, name: String, code: Int, logourl: String, deleted: Int = 0)
  /** GetResult implicit for fetching TBankcardSupportRow objects using plain SQL queries */
  implicit def GetResultTBankcardSupportRow(implicit e0: GR[Int], e1: GR[String]): GR[TBankcardSupportRow] = GR{
    prs => import prs._
    TBankcardSupportRow.tupled((<<[Int], <<[String], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table t_bankcard_support. Objects of this class serve as prototypes for rows in queries. */
  class TBankcardSupport(_tableTag: Tag) extends Table[TBankcardSupportRow](_tableTag, "t_bankcard_support") {
    def * = (id, name, code, logourl, deleted) <> (TBankcardSupportRow.tupled, TBankcardSupportRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(code), Rep.Some(logourl), Rep.Some(deleted)).shaped.<>({r=>import r._; _1.map(_=> TBankcardSupportRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(64,true) */
    val name: Rep[String] = column[String]("name", O.Length(64,varying=true))
    /** Database column code SqlType(INT) */
    val code: Rep[Int] = column[Int]("code")
    /** Database column logourl SqlType(VARCHAR), Length(128,true) */
    val logourl: Rep[String] = column[String]("logourl", O.Length(128,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
  }
  /** Collection-like TableQuery object for table TBankcardSupport */
  lazy val TBankcardSupport = new TableQuery(tag => new TBankcardSupport(tag))

  /** Entity class storing rows of table TCheckInfo
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param checkedType Database column checked_type SqlType(INT), Default(None)
   *  @param checkedTimes Database column checked_times SqlType(INT), Default(Some(0))
   *  @param checked Database column checked SqlType(INT), Default(None)
   *  @param loanApplyId Database column loan_apply_id SqlType(VARCHAR), Length(45,true), Default(None) */
  case class TCheckInfoRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, checkedType: Option[Int] = None, checkedTimes: Option[Int] = Some(0), checked: Option[Int] = None, loanApplyId: Option[String] = None)
  /** GetResult implicit for fetching TCheckInfoRow objects using plain SQL queries */
  implicit def GetResultTCheckInfoRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]], e4: GR[Option[String]]): GR[TCheckInfoRow] = GR{
    prs => import prs._
    TCheckInfoRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<?[Int], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table t_check_info. Objects of this class serve as prototypes for rows in queries. */
  class TCheckInfo(_tableTag: Tag) extends Table[TCheckInfoRow](_tableTag, "t_check_info") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, checkedType, checkedTimes, checked, loanApplyId) <> (TCheckInfoRow.tupled, TCheckInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), checkedType, checkedTimes, checked, loanApplyId).shaped.<>({r=>import r._; _1.map(_=> TCheckInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column checked_type SqlType(INT), Default(None) */
    val checkedType: Rep[Option[Int]] = column[Option[Int]]("checked_type", O.Default(None))
    /** Database column checked_times SqlType(INT), Default(Some(0)) */
    val checkedTimes: Rep[Option[Int]] = column[Option[Int]]("checked_times", O.Default(Some(0)))
    /** Database column checked SqlType(INT), Default(None) */
    val checked: Rep[Option[Int]] = column[Option[Int]]("checked", O.Default(None))
    /** Database column loan_apply_id SqlType(VARCHAR), Length(45,true), Default(None) */
    val loanApplyId: Rep[Option[String]] = column[Option[String]]("loan_apply_id", O.Length(45,varying=true), O.Default(None))

    /** Uniqueness Index over (uuid) (database name idx_t_check_info_uuid) */
    val index1 = index("idx_t_check_info_uuid", uuid, unique=true)
    /** Index over (uuid) (database name index_name) */
    val index2 = index("index_name", uuid)
  }
  /** Collection-like TableQuery object for table TCheckInfo */
  lazy val TCheckInfo = new TableQuery(tag => new TCheckInfo(tag))

  /** Entity class storing rows of table TCities
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param parentId Database column parent_id SqlType(INT), Default(None)
   *  @param cityName Database column city_name SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param cityCode Database column city_code SqlType(VARCHAR), Length(6,true), Default(None)
   *  @param level Database column level SqlType(BIT)
   *  @param fullName Database column full_name SqlType(VARCHAR), Length(50,true), Default(None) */
  case class TCitiesRow(id: Int, parentId: Option[Int] = None, cityName: Option[String] = None, cityCode: Option[String] = None, level: Boolean, fullName: Option[String] = None)
  /** GetResult implicit for fetching TCitiesRow objects using plain SQL queries */
  implicit def GetResultTCitiesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Boolean]): GR[TCitiesRow] = GR{
    prs => import prs._
    TCitiesRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<[Boolean], <<?[String]))
  }
  /** Table description of table t_cities. Objects of this class serve as prototypes for rows in queries. */
  class TCities(_tableTag: Tag) extends Table[TCitiesRow](_tableTag, "t_cities") {
    def * = (id, parentId, cityName, cityCode, level, fullName) <> (TCitiesRow.tupled, TCitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), parentId, cityName, cityCode, Rep.Some(level), fullName).shaped.<>({r=>import r._; _1.map(_=> TCitiesRow.tupled((_1.get, _2, _3, _4, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column parent_id SqlType(INT), Default(None) */
    val parentId: Rep[Option[Int]] = column[Option[Int]]("parent_id", O.Default(None))
    /** Database column city_name SqlType(VARCHAR), Length(64,true), Default(None) */
    val cityName: Rep[Option[String]] = column[Option[String]]("city_name", O.Length(64,varying=true), O.Default(None))
    /** Database column city_code SqlType(VARCHAR), Length(6,true), Default(None) */
    val cityCode: Rep[Option[String]] = column[Option[String]]("city_code", O.Length(6,varying=true), O.Default(None))
    /** Database column level SqlType(BIT) */
    val level: Rep[Boolean] = column[Boolean]("level")
    /** Database column full_name SqlType(VARCHAR), Length(50,true), Default(None) */
    val fullName: Rep[Option[String]] = column[Option[String]]("full_name", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TCities */
  lazy val TCities = new TableQuery(tag => new TCities(tag))

  /** Entity class storing rows of table TComplaints
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userUuid Database column user_uuid SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param content Database column content SqlType(VARCHAR), Length(500,true)
   *  @param reply Database column reply SqlType(VARCHAR), Length(500,true), Default(None) */
  case class TComplaintsRow(id: Int, uuid: String, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userUuid: Option[String] = None, content: String, reply: Option[String] = None)
  /** GetResult implicit for fetching TComplaintsRow objects using plain SQL queries */
  implicit def GetResultTComplaintsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TComplaintsRow] = GR{
    prs => import prs._
    TComplaintsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[String], <<?[String]))
  }
  /** Table description of table t_complaints. Objects of this class serve as prototypes for rows in queries. */
  class TComplaints(_tableTag: Tag) extends Table[TComplaintsRow](_tableTag, "t_complaints") {
    def * = (id, uuid, createTime, modifyTime, userUuid, content, reply) <> (TComplaintsRow.tupled, TComplaintsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(modifyTime), userUuid, Rep.Some(content), reply).shaped.<>({r=>import r._; _1.map(_=> TComplaintsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_uuid SqlType(VARCHAR), Length(32,true), Default(None) */
    val userUuid: Rep[Option[String]] = column[Option[String]]("user_uuid", O.Length(32,varying=true), O.Default(None))
    /** Database column content SqlType(VARCHAR), Length(500,true) */
    val content: Rep[String] = column[String]("content", O.Length(500,varying=true))
    /** Database column reply SqlType(VARCHAR), Length(500,true), Default(None) */
    val reply: Rep[Option[String]] = column[Option[String]]("reply", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TComplaints */
  lazy val TComplaints = new TableQuery(tag => new TComplaints(tag))

  /** Entity class storing rows of table TConfig
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param key Database column key SqlType(VARCHAR), Length(32,true)
   *  @param value Database column value SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param `type` Database column type SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param operator Database column operator SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param remark Database column remark SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param deleted Database column deleted SqlType(INT), Default(0) */
  case class TConfigRow(id: Int, key: String, value: Option[String] = None, name: Option[String] = None, `type`: Option[String] = None, operator: Option[String] = None, remark: Option[String] = None, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, deleted: Int = 0)
  /** GetResult implicit for fetching TConfigRow objects using plain SQL queries */
  implicit def GetResultTConfigRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[TConfigRow] = GR{
    prs => import prs._
    TConfigRow.tupled((<<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table t_config. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TConfig(_tableTag: Tag) extends Table[TConfigRow](_tableTag, "t_config") {
    def * = (id, key, value, name, `type`, operator, remark, createTime, modifyTime, deleted) <> (TConfigRow.tupled, TConfigRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(key), value, name, `type`, operator, remark, Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(deleted)).shaped.<>({r=>import r._; _1.map(_=> TConfigRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column key SqlType(VARCHAR), Length(32,true) */
    val key: Rep[String] = column[String]("key", O.Length(32,varying=true))
    /** Database column value SqlType(VARCHAR), Length(500,true), Default(None) */
    val value: Rep[Option[String]] = column[Option[String]]("value", O.Length(500,varying=true), O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(45,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(45,varying=true), O.Default(None))
    /** Database column type SqlType(VARCHAR), Length(32,true), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Length(32,varying=true), O.Default(None))
    /** Database column operator SqlType(VARCHAR), Length(32,true), Default(None) */
    val operator: Rep[Option[String]] = column[Option[String]]("operator", O.Length(32,varying=true), O.Default(None))
    /** Database column remark SqlType(VARCHAR), Length(500,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("remark", O.Length(500,varying=true), O.Default(None))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))

    /** Uniqueness Index over (key,`type`) (database name key_type_UNIQUE) */
    val index1 = index("key_type_UNIQUE", (key, `type`), unique=true)
  }
  /** Collection-like TableQuery object for table TConfig */
  lazy val TConfig = new TableQuery(tag => new TConfig(tag))

  /** Entity class storing rows of table TConfigGroup
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(100,true)
   *  @param scope Database column scope SqlType(VARCHAR), Length(45,true)
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param content Database column content SqlType(VARCHAR), Length(2000,true)
   *  @param deleted Database column deleted SqlType(INT), Default(Some(0))
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param createTime Database column create_time SqlType(DATETIME) */
  case class TConfigGroupRow(id: Int, name: String, scope: String, uuid: String, content: String, deleted: Option[Int] = Some(0), modifyTime: Option[java.sql.Timestamp], createTime: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching TConfigGroupRow objects using plain SQL queries */
  implicit def GetResultTConfigGroupRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[TConfigGroupRow] = GR{
    prs => import prs._
    TConfigGroupRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table t_config_group. Objects of this class serve as prototypes for rows in queries. */
  class TConfigGroup(_tableTag: Tag) extends Table[TConfigGroupRow](_tableTag, "t_config_group") {
    def * = (id, name, scope, uuid, content, deleted, modifyTime, createTime) <> (TConfigGroupRow.tupled, TConfigGroupRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(scope), Rep.Some(uuid), Rep.Some(content), deleted, modifyTime, createTime).shaped.<>({r=>import r._; _1.map(_=> TConfigGroupRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column scope SqlType(VARCHAR), Length(45,true) */
    val scope: Rep[String] = column[String]("scope", O.Length(45,varying=true))
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column content SqlType(VARCHAR), Length(2000,true) */
    val content: Rep[String] = column[String]("content", O.Length(2000,varying=true))
    /** Database column deleted SqlType(INT), Default(Some(0)) */
    val deleted: Rep[Option[Int]] = column[Option[Int]]("deleted", O.Default(Some(0)))
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("modify_time")
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("create_time")
  }
  /** Collection-like TableQuery object for table TConfigGroup */
  lazy val TConfigGroup = new TableQuery(tag => new TConfigGroup(tag))

  /** Entity class storing rows of table TContactBooks
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param content Database column content SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
  case class TContactBooksRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, userId: String, content: Option[String] = None)
  /** GetResult implicit for fetching TContactBooksRow objects using plain SQL queries */
  implicit def GetResultTContactBooksRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TContactBooksRow] = GR{
    prs => import prs._
    TContactBooksRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[String], <<?[String]))
  }
  /** Table description of table t_contact_books. Objects of this class serve as prototypes for rows in queries. */
  class TContactBooks(_tableTag: Tag) extends Table[TContactBooksRow](_tableTag, "t_contact_books") {
    def * = (id, uuid, deleted, createTime, userId, content) <> (TContactBooksRow.tupled, TContactBooksRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(userId), content).shaped.<>({r=>import r._; _1.map(_=> TContactBooksRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column content SqlType(MEDIUMTEXT), Length(16777215,true), Default(None) */
    val content: Rep[Option[String]] = column[Option[String]]("content", O.Length(16777215,varying=true), O.Default(None))

    /** Uniqueness Index over (uuid) (database name idx_t_contact_books_uuid) */
    val index1 = index("idx_t_contact_books_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TContactBooks */
  lazy val TContactBooks = new TableQuery(tag => new TContactBooks(tag))

  /** Entity class storing rows of table TContacts
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param phoneNumber Database column phone_number SqlType(VARCHAR), Length(20,true)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param realtion Database column realtion SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param linkType Database column link_type SqlType(VARCHAR), Length(32,true)
   *  @param isSupplement Database column is_supplement SqlType(INT), Default(0) */
  case class TContactsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, name: Option[String] = None, phoneNumber: String, userId: String, realtion: Option[String] = None, linkType: String, isSupplement: Int = 0)
  /** GetResult implicit for fetching TContactsRow objects using plain SQL queries */
  implicit def GetResultTContactsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TContactsRow] = GR{
    prs => import prs._
    TContactsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[String], <<[String], <<?[String], <<[String], <<[Int]))
  }
  /** Table description of table t_contacts. Objects of this class serve as prototypes for rows in queries. */
  class TContacts(_tableTag: Tag) extends Table[TContactsRow](_tableTag, "t_contacts") {
    def * = (id, uuid, deleted, createTime, modifyTime, name, phoneNumber, userId, realtion, linkType, isSupplement) <> (TContactsRow.tupled, TContactsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), name, Rep.Some(phoneNumber), Rep.Some(userId), realtion, Rep.Some(linkType), Rep.Some(isSupplement)).shaped.<>({r=>import r._; _1.map(_=> TContactsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get, _8.get, _9, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column name SqlType(VARCHAR), Length(32,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(32,varying=true), O.Default(None))
    /** Database column phone_number SqlType(VARCHAR), Length(20,true) */
    val phoneNumber: Rep[String] = column[String]("phone_number", O.Length(20,varying=true))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column realtion SqlType(VARCHAR), Length(45,true), Default(None) */
    val realtion: Rep[Option[String]] = column[Option[String]]("realtion", O.Length(45,varying=true), O.Default(None))
    /** Database column link_type SqlType(VARCHAR), Length(32,true) */
    val linkType: Rep[String] = column[String]("link_type", O.Length(32,varying=true))
    /** Database column is_supplement SqlType(INT), Default(0) */
    val isSupplement: Rep[Int] = column[Int]("is_supplement", O.Default(0))

    /** Uniqueness Index over (uuid) (database name idx_t_contact_books_uuid) */
    val index1 = index("idx_t_contact_books_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TContacts */
  lazy val TContacts = new TableQuery(tag => new TContacts(tag))

  /** Entity class storing rows of table TContentVersion
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param table Database column table SqlType(VARCHAR), Length(64,true)
   *  @param version Database column version SqlType(INT) */
  case class TContentVersionRow(id: Int, name: String, table: String, version: Int)
  /** GetResult implicit for fetching TContentVersionRow objects using plain SQL queries */
  implicit def GetResultTContentVersionRow(implicit e0: GR[Int], e1: GR[String]): GR[TContentVersionRow] = GR{
    prs => import prs._
    TContentVersionRow.tupled((<<[Int], <<[String], <<[String], <<[Int]))
  }
  /** Table description of table t_content_version. Objects of this class serve as prototypes for rows in queries. */
  class TContentVersion(_tableTag: Tag) extends Table[TContentVersionRow](_tableTag, "t_content_version") {
    def * = (id, name, table, version) <> (TContentVersionRow.tupled, TContentVersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(table), Rep.Some(version)).shaped.<>({r=>import r._; _1.map(_=> TContentVersionRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column table SqlType(VARCHAR), Length(64,true) */
    val table: Rep[String] = column[String]("table", O.Length(64,varying=true))
    /** Database column version SqlType(INT) */
    val version: Rep[Int] = column[Int]("version")

    /** Uniqueness Index over (name) (database name unique_name) */
    val index1 = index("unique_name", name, unique=true)
    /** Uniqueness Index over (table) (database name unique_table) */
    val index2 = index("unique_table", table, unique=true)
  }
  /** Collection-like TableQuery object for table TContentVersion */
  lazy val TContentVersion = new TableQuery(tag => new TContentVersion(tag))

  /** Entity class storing rows of table TContractYxd
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param orderUuid Database column order_uuid SqlType(VARCHAR), Length(32,true)
   *  @param loanRequestDate Database column loan_request_date SqlType(DATETIME)
   *  @param contractUrl Database column contract_url SqlType(VARCHAR), Length(4096,true), Default(None)
   *  @param gps Database column gps SqlType(VARCHAR), Length(100,true)
   *  @param remark Database column remark SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param mailFlag Database column mail_flag SqlType(BIT), Default(false)
   *  @param userConfirm Database column user_confirm SqlType(BIT), Default(false)
   *  @param ecFlag Database column ec_flag SqlType(BIT), Default(false)
   *  @param loanType Database column loan_type SqlType(INT), Default(None)
   *  @param intoPiecesId Database column into_pieces_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param digitalSigned Database column digital_signed SqlType(BIT), Default(false) */
  case class TContractYxdRow(id: Int, uuid: String, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, orderUuid: String, loanRequestDate: java.sql.Timestamp, contractUrl: Option[String] = None, gps: String, remark: Option[String] = None, mailFlag: Boolean = false, userConfirm: Boolean = false, ecFlag: Boolean = false, loanType: Option[Int] = None, intoPiecesId: Option[String] = None, digitalSigned: Boolean = false)
  /** GetResult implicit for fetching TContractYxdRow objects using plain SQL queries */
  implicit def GetResultTContractYxdRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Boolean], e5: GR[Option[Int]]): GR[TContractYxdRow] = GR{
    prs => import prs._
    TContractYxdRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[java.sql.Timestamp], <<?[String], <<[String], <<?[String], <<[Boolean], <<[Boolean], <<[Boolean], <<?[Int], <<?[String], <<[Boolean]))
  }
  /** Table description of table t_contract_yxd. Objects of this class serve as prototypes for rows in queries. */
  class TContractYxd(_tableTag: Tag) extends Table[TContractYxdRow](_tableTag, "t_contract_yxd") {
    def * = (id, uuid, createTime, modifyTime, orderUuid, loanRequestDate, contractUrl, gps, remark, mailFlag, userConfirm, ecFlag, loanType, intoPiecesId, digitalSigned) <> (TContractYxdRow.tupled, TContractYxdRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(orderUuid), Rep.Some(loanRequestDate), contractUrl, Rep.Some(gps), remark, Rep.Some(mailFlag), Rep.Some(userConfirm), Rep.Some(ecFlag), loanType, intoPiecesId, Rep.Some(digitalSigned)).shaped.<>({r=>import r._; _1.map(_=> TContractYxdRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9, _10.get, _11.get, _12.get, _13, _14, _15.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column order_uuid SqlType(VARCHAR), Length(32,true) */
    val orderUuid: Rep[String] = column[String]("order_uuid", O.Length(32,varying=true))
    /** Database column loan_request_date SqlType(DATETIME) */
    val loanRequestDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("loan_request_date")
    /** Database column contract_url SqlType(VARCHAR), Length(4096,true), Default(None) */
    val contractUrl: Rep[Option[String]] = column[Option[String]]("contract_url", O.Length(4096,varying=true), O.Default(None))
    /** Database column gps SqlType(VARCHAR), Length(100,true) */
    val gps: Rep[String] = column[String]("gps", O.Length(100,varying=true))
    /** Database column remark SqlType(VARCHAR), Length(500,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("remark", O.Length(500,varying=true), O.Default(None))
    /** Database column mail_flag SqlType(BIT), Default(false) */
    val mailFlag: Rep[Boolean] = column[Boolean]("mail_flag", O.Default(false))
    /** Database column user_confirm SqlType(BIT), Default(false) */
    val userConfirm: Rep[Boolean] = column[Boolean]("user_confirm", O.Default(false))
    /** Database column ec_flag SqlType(BIT), Default(false) */
    val ecFlag: Rep[Boolean] = column[Boolean]("ec_flag", O.Default(false))
    /** Database column loan_type SqlType(INT), Default(None) */
    val loanType: Rep[Option[Int]] = column[Option[Int]]("loan_type", O.Default(None))
    /** Database column into_pieces_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val intoPiecesId: Rep[Option[String]] = column[Option[String]]("into_pieces_id", O.Length(32,varying=true), O.Default(None))
    /** Database column digital_signed SqlType(BIT), Default(false) */
    val digitalSigned: Rep[Boolean] = column[Boolean]("digital_signed", O.Default(false))

    /** Index over (uuid) (database name idx_t_lendings_uuid) */
    val index1 = index("idx_t_lendings_uuid", uuid)
    /** Index over (orderUuid) (database name idx_t_orderss_uuid) */
    val index2 = index("idx_t_orderss_uuid", orderUuid)
  }
  /** Collection-like TableQuery object for table TContractYxd */
  lazy val TContractYxd = new TableQuery(tag => new TContractYxd(tag))

  /** Entity class storing rows of table TCourses
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param code Database column code SqlType(INT)
   *  @param courceName Database column cource_name SqlType(VARCHAR), Length(45,true)
   *  @param parentName Database column parent_name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param `type` Database column type SqlType(INT)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param parentCode Database column parent_code SqlType(INT), Default(None)
   *  @param orderby Database column orderby SqlType(INT) */
  case class TCoursesRow(id: Int, code: Int, courceName: String, parentName: Option[String] = None, `type`: Int, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, deleted: Int = 0, parentCode: Option[Int] = None, orderby: Int)
  /** GetResult implicit for fetching TCoursesRow objects using plain SQL queries */
  implicit def GetResultTCoursesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp], e4: GR[Option[Int]]): GR[TCoursesRow] = GR{
    prs => import prs._
    TCoursesRow.tupled((<<[Int], <<[Int], <<[String], <<?[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int], <<?[Int], <<[Int]))
  }
  /** Table description of table t_courses. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TCourses(_tableTag: Tag) extends Table[TCoursesRow](_tableTag, "t_courses") {
    def * = (id, code, courceName, parentName, `type`, createTime, modifyTime, deleted, parentCode, orderby) <> (TCoursesRow.tupled, TCoursesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(code), Rep.Some(courceName), parentName, Rep.Some(`type`), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(deleted), parentCode, Rep.Some(orderby)).shaped.<>({r=>import r._; _1.map(_=> TCoursesRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column code SqlType(INT) */
    val code: Rep[Int] = column[Int]("code")
    /** Database column cource_name SqlType(VARCHAR), Length(45,true) */
    val courceName: Rep[String] = column[String]("cource_name", O.Length(45,varying=true))
    /** Database column parent_name SqlType(VARCHAR), Length(45,true), Default(None) */
    val parentName: Rep[Option[String]] = column[Option[String]]("parent_name", O.Length(45,varying=true), O.Default(None))
    /** Database column type SqlType(INT)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Int] = column[Int]("type")
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column parent_code SqlType(INT), Default(None) */
    val parentCode: Rep[Option[Int]] = column[Option[Int]]("parent_code", O.Default(None))
    /** Database column orderby SqlType(INT) */
    val orderby: Rep[Int] = column[Int]("orderby")
  }
  /** Collection-like TableQuery object for table TCourses */
  lazy val TCourses = new TableQuery(tag => new TCourses(tag))

  /** Entity class storing rows of table TCreditResult
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param result Database column result SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param orderId Database column order_id SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param source Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
  case class TCreditResultRow(id: Int, uuid: String, result: Option[String] = None, userId: String, orderId: String, createTime: java.sql.Timestamp, source: Option[String] = None)
  /** GetResult implicit for fetching TCreditResultRow objects using plain SQL queries */
  implicit def GetResultTCreditResultRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[TCreditResultRow] = GR{
    prs => import prs._
    TCreditResultRow.tupled((<<[Int], <<[String], <<?[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table t_credit_result. Objects of this class serve as prototypes for rows in queries. */
  class TCreditResult(_tableTag: Tag) extends Table[TCreditResultRow](_tableTag, "t_credit_result") {
    def * = (id, uuid, result, userId, orderId, createTime, source) <> (TCreditResultRow.tupled, TCreditResultRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), result, Rep.Some(userId), Rep.Some(orderId), Rep.Some(createTime), source).shaped.<>({r=>import r._; _1.map(_=> TCreditResultRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column result SqlType(VARCHAR), Length(200,true), Default(None) */
    val result: Rep[Option[String]] = column[Option[String]]("result", O.Length(200,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column order_id SqlType(VARCHAR), Length(32,true) */
    val orderId: Rep[String] = column[String]("order_id", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
    val source: Rep[Option[String]] = column[Option[String]]("source", O.Length(60,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TCreditResult */
  lazy val TCreditResult = new TableQuery(tag => new TCreditResult(tag))

  /** Entity class storing rows of table TDailyInfo
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param info Database column info SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param createDate Database column create_date SqlType(VARCHAR), Length(8,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(255,true) */
  case class TDailyInfoRow(id: Int, info: Option[String] = None, createDate: String, `type`: String)
  /** GetResult implicit for fetching TDailyInfoRow objects using plain SQL queries */
  implicit def GetResultTDailyInfoRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String]): GR[TDailyInfoRow] = GR{
    prs => import prs._
    TDailyInfoRow.tupled((<<[Int], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table t_daily_info. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TDailyInfo(_tableTag: Tag) extends Table[TDailyInfoRow](_tableTag, "t_daily_info") {
    def * = (id, info, createDate, `type`) <> (TDailyInfoRow.tupled, TDailyInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), info, Rep.Some(createDate), Rep.Some(`type`)).shaped.<>({r=>import r._; _1.map(_=> TDailyInfoRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column info SqlType(VARCHAR), Length(1000,true), Default(None) */
    val info: Rep[Option[String]] = column[Option[String]]("info", O.Length(1000,varying=true), O.Default(None))
    /** Database column create_date SqlType(VARCHAR), Length(8,true) */
    val createDate: Rep[String] = column[String]("create_date", O.Length(8,varying=true))
    /** Database column type SqlType(VARCHAR), Length(255,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(255,varying=true))

    /** Uniqueness Index over (createDate,`type`) (database name unique_type) */
    val index1 = index("unique_type", (createDate, `type`), unique=true)
  }
  /** Collection-like TableQuery object for table TDailyInfo */
  lazy val TDailyInfo = new TableQuery(tag => new TDailyInfo(tag))

  /** Entity class storing rows of table TDevices
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param operator Database column operator SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param systemName Database column system_name SqlType(VARCHAR), Length(32,true)
   *  @param systemVersion Database column system_version SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param phoneSerialNumber Database column phone_serial_number SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param phoneModel Database column phone_model SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param phoneMac Database column phone_mac SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param imei Database column imei SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param pushId Database column push_id SqlType(VARCHAR), Length(64,true), Default(None)
   *  @param extend Database column extend SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param device Database column device SqlType(VARCHAR), Length(45,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param bounded Database column bounded SqlType(INT), Default(0) */
  case class TDevicesRow(id: Int, uuid: String, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, operator: Option[String] = None, systemName: String, systemVersion: Option[String] = None, phoneSerialNumber: Option[String] = None, phoneModel: Option[String] = None, phoneMac: Option[String] = None, imei: Option[String] = None, userId: String, pushId: Option[String] = None, extend: Option[String] = None, device: String, deleted: Int = 0, bounded: Int = 0)
  /** GetResult implicit for fetching TDevicesRow objects using plain SQL queries */
  implicit def GetResultTDevicesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TDevicesRow] = GR{
    prs => import prs._
    TDevicesRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[String], <<?[String], <<?[String], <<[String], <<[Int], <<[Int]))
  }
  /** Table description of table t_devices. Objects of this class serve as prototypes for rows in queries. */
  class TDevices(_tableTag: Tag) extends Table[TDevicesRow](_tableTag, "t_devices") {
    def * = (id, uuid, createTime, modifyTime, operator, systemName, systemVersion, phoneSerialNumber, phoneModel, phoneMac, imei, userId, pushId, extend, device, deleted, bounded) <> (TDevicesRow.tupled, TDevicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(modifyTime), operator, Rep.Some(systemName), systemVersion, phoneSerialNumber, phoneModel, phoneMac, imei, Rep.Some(userId), pushId, extend, Rep.Some(device), Rep.Some(deleted), Rep.Some(bounded)).shaped.<>({r=>import r._; _1.map(_=> TDevicesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7, _8, _9, _10, _11, _12.get, _13, _14, _15.get, _16.get, _17.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column operator SqlType(VARCHAR), Length(32,true), Default(None) */
    val operator: Rep[Option[String]] = column[Option[String]]("operator", O.Length(32,varying=true), O.Default(None))
    /** Database column system_name SqlType(VARCHAR), Length(32,true) */
    val systemName: Rep[String] = column[String]("system_name", O.Length(32,varying=true))
    /** Database column system_version SqlType(VARCHAR), Length(500,true), Default(None) */
    val systemVersion: Rep[Option[String]] = column[Option[String]]("system_version", O.Length(500,varying=true), O.Default(None))
    /** Database column phone_serial_number SqlType(VARCHAR), Length(64,true), Default(None) */
    val phoneSerialNumber: Rep[Option[String]] = column[Option[String]]("phone_serial_number", O.Length(64,varying=true), O.Default(None))
    /** Database column phone_model SqlType(VARCHAR), Length(64,true), Default(None) */
    val phoneModel: Rep[Option[String]] = column[Option[String]]("phone_model", O.Length(64,varying=true), O.Default(None))
    /** Database column phone_mac SqlType(VARCHAR), Length(64,true), Default(None) */
    val phoneMac: Rep[Option[String]] = column[Option[String]]("phone_mac", O.Length(64,varying=true), O.Default(None))
    /** Database column imei SqlType(VARCHAR), Length(64,true), Default(None) */
    val imei: Rep[Option[String]] = column[Option[String]]("imei", O.Length(64,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column push_id SqlType(VARCHAR), Length(64,true), Default(None) */
    val pushId: Rep[Option[String]] = column[Option[String]]("push_id", O.Length(64,varying=true), O.Default(None))
    /** Database column extend SqlType(VARCHAR), Length(45,true), Default(None) */
    val extend: Rep[Option[String]] = column[Option[String]]("extend", O.Length(45,varying=true), O.Default(None))
    /** Database column device SqlType(VARCHAR), Length(45,true) */
    val device: Rep[String] = column[String]("device", O.Length(45,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column bounded SqlType(INT), Default(0) */
    val bounded: Rep[Int] = column[Int]("bounded", O.Default(0))

    /** Index over (uuid) (database name index_t_devices_uuid) */
    val index1 = index("index_t_devices_uuid", uuid)
  }
  /** Collection-like TableQuery object for table TDevices */
  lazy val TDevices = new TableQuery(tag => new TDevices(tag))

  /** Entity class storing rows of table TEducations
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param schoolName Database column school_name SqlType(VARCHAR), Length(32,true)
   *  @param address Database column address SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param educationDegree Database column education_degree SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param enrolDate Database column enrol_date SqlType(VARCHAR), Length(30,true)
   *  @param graduateTime Database column graduate_time SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param studyResult Database column study_result SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param studyStyle Database column study_style SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param specialty Database column specialty SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param extInfo Database column ext_info SqlType(VARCHAR), Length(5000,true), Default(None)
   *  @param needSupply Database column need_supply SqlType(BIT), Default(false)
   *  @param isChecked Database column is_checked SqlType(BIT), Default(true) */
  case class TEducationsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, schoolName: String, address: Option[String] = None, educationDegree: Option[String] = None, enrolDate: String, graduateTime: Option[String] = None, studyResult: Option[String] = None, studyStyle: Option[String] = None, specialty: Option[String] = None, extInfo: Option[String] = None, needSupply: Boolean = false, isChecked: Boolean = true)
  /** GetResult implicit for fetching TEducationsRow objects using plain SQL queries */
  implicit def GetResultTEducationsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Boolean]): GR[TEducationsRow] = GR{
    prs => import prs._
    TEducationsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<?[String], <<?[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[Boolean]))
  }
  /** Table description of table t_educations. Objects of this class serve as prototypes for rows in queries. */
  class TEducations(_tableTag: Tag) extends Table[TEducationsRow](_tableTag, "t_educations") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, schoolName, address, educationDegree, enrolDate, graduateTime, studyResult, studyStyle, specialty, extInfo, needSupply, isChecked) <> (TEducationsRow.tupled, TEducationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), Rep.Some(schoolName), address, educationDegree, Rep.Some(enrolDate), graduateTime, studyResult, studyStyle, specialty, extInfo, Rep.Some(needSupply), Rep.Some(isChecked)).shaped.<>({r=>import r._; _1.map(_=> TEducationsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9, _10.get, _11, _12, _13, _14, _15, _16.get, _17.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column school_name SqlType(VARCHAR), Length(32,true) */
    val schoolName: Rep[String] = column[String]("school_name", O.Length(32,varying=true))
    /** Database column address SqlType(VARCHAR), Length(300,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(300,varying=true), O.Default(None))
    /** Database column education_degree SqlType(VARCHAR), Length(30,true), Default(None) */
    val educationDegree: Rep[Option[String]] = column[Option[String]]("education_degree", O.Length(30,varying=true), O.Default(None))
    /** Database column enrol_date SqlType(VARCHAR), Length(30,true) */
    val enrolDate: Rep[String] = column[String]("enrol_date", O.Length(30,varying=true))
    /** Database column graduate_time SqlType(VARCHAR), Length(30,true), Default(None) */
    val graduateTime: Rep[Option[String]] = column[Option[String]]("graduate_time", O.Length(30,varying=true), O.Default(None))
    /** Database column study_result SqlType(VARCHAR), Length(30,true), Default(None) */
    val studyResult: Rep[Option[String]] = column[Option[String]]("study_result", O.Length(30,varying=true), O.Default(None))
    /** Database column study_style SqlType(VARCHAR), Length(30,true), Default(None) */
    val studyStyle: Rep[Option[String]] = column[Option[String]]("study_style", O.Length(30,varying=true), O.Default(None))
    /** Database column specialty SqlType(VARCHAR), Length(45,true), Default(None) */
    val specialty: Rep[Option[String]] = column[Option[String]]("specialty", O.Length(45,varying=true), O.Default(None))
    /** Database column ext_info SqlType(VARCHAR), Length(5000,true), Default(None) */
    val extInfo: Rep[Option[String]] = column[Option[String]]("ext_info", O.Length(5000,varying=true), O.Default(None))
    /** Database column need_supply SqlType(BIT), Default(false) */
    val needSupply: Rep[Boolean] = column[Boolean]("need_supply", O.Default(false))
    /** Database column is_checked SqlType(BIT), Default(true) */
    val isChecked: Rep[Boolean] = column[Boolean]("is_checked", O.Default(true))

    /** Uniqueness Index over (uuid) (database name idx_t_educations_uuid) */
    val index1 = index("idx_t_educations_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TEducations */
  lazy val TEducations = new TableQuery(tag => new TEducations(tag))

  /** Entity class storing rows of table TEventLog
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(BIGINT)
   *  @param modifyTime Database column modify_time SqlType(BIGINT)
   *  @param eventType Database column event_type SqlType(VARCHAR), Length(32,true)
   *  @param content Database column content SqlType(VARCHAR), Length(1000,true)
   *  @param result Database column result SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param source Database column source SqlType(VARCHAR), Length(32,true), Default(None) */
  case class TEventLogRow(id: Int, uuid: String, createTime: Long, modifyTime: Long, eventType: String, content: String, result: Option[String] = None, userId: String, source: Option[String] = None)
  /** GetResult implicit for fetching TEventLogRow objects using plain SQL queries */
  implicit def GetResultTEventLogRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Long], e3: GR[Option[String]]): GR[TEventLogRow] = GR{
    prs => import prs._
    TEventLogRow.tupled((<<[Int], <<[String], <<[Long], <<[Long], <<[String], <<[String], <<?[String], <<[String], <<?[String]))
  }
  /** Table description of table t_event_log. Objects of this class serve as prototypes for rows in queries. */
  class TEventLog(_tableTag: Tag) extends Table[TEventLogRow](_tableTag, "t_event_log") {
    def * = (id, uuid, createTime, modifyTime, eventType, content, result, userId, source) <> (TEventLogRow.tupled, TEventLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(eventType), Rep.Some(content), result, Rep.Some(userId), source).shaped.<>({r=>import r._; _1.map(_=> TEventLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(BIGINT) */
    val createTime: Rep[Long] = column[Long]("create_time")
    /** Database column modify_time SqlType(BIGINT) */
    val modifyTime: Rep[Long] = column[Long]("modify_time")
    /** Database column event_type SqlType(VARCHAR), Length(32,true) */
    val eventType: Rep[String] = column[String]("event_type", O.Length(32,varying=true))
    /** Database column content SqlType(VARCHAR), Length(1000,true) */
    val content: Rep[String] = column[String]("content", O.Length(1000,varying=true))
    /** Database column result SqlType(VARCHAR), Length(500,true), Default(None) */
    val result: Rep[Option[String]] = column[Option[String]]("result", O.Length(500,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column source SqlType(VARCHAR), Length(32,true), Default(None) */
    val source: Rep[Option[String]] = column[Option[String]]("source", O.Length(32,varying=true), O.Default(None))

    /** Index over (userId) (database name idx_t_event_log_userdi) */
    val index1 = index("idx_t_event_log_userdi", userId)
    /** Uniqueness Index over (uuid) (database name idx_t_event_log_uuid) */
    val index2 = index("idx_t_event_log_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TEventLog */
  lazy val TEventLog = new TableQuery(tag => new TEventLog(tag))

  /** Entity class storing rows of table TFamilyInfo
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param telephoneNumber Database column telephone_number SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param provinceCode Database column province_code SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param cityCode Database column city_code SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param areaCode Database column area_code SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param cityName Database column city_name SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param hasMate Database column has_mate SqlType(INT), Default(Some(0))
   *  @param inGoodHealth Database column in_good_health SqlType(INT), Default(Some(0))
   *  @param hasChildren Database column has_children SqlType(INT), Default(Some(0)) */
  case class TFamilyInfoRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, telephoneNumber: Option[String] = None, provinceCode: Option[String] = None, cityCode: Option[String] = None, areaCode: Option[String] = None, cityName: Option[String] = None, address: Option[String] = None, hasMate: Option[Int] = Some(0), inGoodHealth: Option[Int] = Some(0), hasChildren: Option[Int] = Some(0))
  /** GetResult implicit for fetching TFamilyInfoRow objects using plain SQL queries */
  implicit def GetResultTFamilyInfoRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Option[Int]]): GR[TFamilyInfoRow] = GR{
    prs => import prs._
    TFamilyInfoRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table t_family_info. Objects of this class serve as prototypes for rows in queries. */
  class TFamilyInfo(_tableTag: Tag) extends Table[TFamilyInfoRow](_tableTag, "t_family_info") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, telephoneNumber, provinceCode, cityCode, areaCode, cityName, address, hasMate, inGoodHealth, hasChildren) <> (TFamilyInfoRow.tupled, TFamilyInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), telephoneNumber, provinceCode, cityCode, areaCode, cityName, address, hasMate, inGoodHealth, hasChildren).shaped.<>({r=>import r._; _1.map(_=> TFamilyInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column telephone_number SqlType(VARCHAR), Length(20,true), Default(None) */
    val telephoneNumber: Rep[Option[String]] = column[Option[String]]("telephone_number", O.Length(20,varying=true), O.Default(None))
    /** Database column province_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val provinceCode: Rep[Option[String]] = column[Option[String]]("province_code", O.Length(20,varying=true), O.Default(None))
    /** Database column city_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val cityCode: Rep[Option[String]] = column[Option[String]]("city_code", O.Length(20,varying=true), O.Default(None))
    /** Database column area_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val areaCode: Rep[Option[String]] = column[Option[String]]("area_code", O.Length(20,varying=true), O.Default(None))
    /** Database column city_name SqlType(VARCHAR), Length(20,true), Default(None) */
    val cityName: Rep[Option[String]] = column[Option[String]]("city_name", O.Length(20,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(100,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(100,varying=true), O.Default(None))
    /** Database column has_mate SqlType(INT), Default(Some(0)) */
    val hasMate: Rep[Option[Int]] = column[Option[Int]]("has_mate", O.Default(Some(0)))
    /** Database column in_good_health SqlType(INT), Default(Some(0)) */
    val inGoodHealth: Rep[Option[Int]] = column[Option[Int]]("in_good_health", O.Default(Some(0)))
    /** Database column has_children SqlType(INT), Default(Some(0)) */
    val hasChildren: Rep[Option[Int]] = column[Option[Int]]("has_children", O.Default(Some(0)))

    /** Index over (uuid) (database name index_t_family_info_uuid) */
    val index1 = index("index_t_family_info_uuid", uuid)
  }
  /** Collection-like TableQuery object for table TFamilyInfo */
  lazy val TFamilyInfo = new TableQuery(tag => new TFamilyInfo(tag))

  /** Entity class storing rows of table TIdentityCards
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param idCardNumber Database column id_card_number SqlType(VARCHAR), Length(30,true)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param gender Database column gender SqlType(INT), Default(Some(0))
   *  @param birthDate Database column birth_date SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param cityCode Database column city_code SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param cityName Database column city_name SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param issuingUnit Database column issuing_unit SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param validDate Database column valid_date SqlType(VARCHAR), Length(30,true), Default(None)
   *  @param frontImage Database column front_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param backImage Database column back_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param personImage Database column person_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param smallImage Database column small_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param idSmallImage Database column id_small_image SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param extendFld Database column extend_fld SqlType(VARCHAR), Length(500,true), Default(None) */
  case class TIdentityCardsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, idCardNumber: String, name: String, gender: Option[Int] = Some(0), birthDate: Option[String] = None, cityCode: Option[String] = None, cityName: Option[String] = None, address: Option[String] = None, issuingUnit: Option[String] = None, validDate: Option[String] = None, frontImage: Option[String] = None, backImage: Option[String] = None, personImage: Option[String] = None, smallImage: Option[String] = None, idSmallImage: Option[String] = None, extendFld: Option[String] = None)
  /** GetResult implicit for fetching TIdentityCardsRow objects using plain SQL queries */
  implicit def GetResultTIdentityCardsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]], e4: GR[Option[String]]): GR[TIdentityCardsRow] = GR{
    prs => import prs._
    TIdentityCardsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table t_identity_cards. Objects of this class serve as prototypes for rows in queries. */
  class TIdentityCards(_tableTag: Tag) extends Table[TIdentityCardsRow](_tableTag, "t_identity_cards") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, idCardNumber, name, gender, birthDate, cityCode, cityName, address, issuingUnit, validDate, frontImage, backImage, personImage, smallImage, idSmallImage, extendFld) <> (TIdentityCardsRow.tupled, TIdentityCardsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), Rep.Some(idCardNumber), Rep.Some(name), gender, birthDate, cityCode, cityName, address, issuingUnit, validDate, frontImage, backImage, personImage, smallImage, idSmallImage, extendFld).shaped.<>({r=>import r._; _1.map(_=> TIdentityCardsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column id_card_number SqlType(VARCHAR), Length(30,true) */
    val idCardNumber: Rep[String] = column[String]("id_card_number", O.Length(30,varying=true))
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column gender SqlType(INT), Default(Some(0)) */
    val gender: Rep[Option[Int]] = column[Option[Int]]("gender", O.Default(Some(0)))
    /** Database column birth_date SqlType(VARCHAR), Length(20,true), Default(None) */
    val birthDate: Rep[Option[String]] = column[Option[String]]("birth_date", O.Length(20,varying=true), O.Default(None))
    /** Database column city_code SqlType(VARCHAR), Length(32,true), Default(None) */
    val cityCode: Rep[Option[String]] = column[Option[String]]("city_code", O.Length(32,varying=true), O.Default(None))
    /** Database column city_name SqlType(VARCHAR), Length(50,true), Default(None) */
    val cityName: Rep[Option[String]] = column[Option[String]]("city_name", O.Length(50,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(300,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("address", O.Length(300,varying=true), O.Default(None))
    /** Database column issuing_unit SqlType(VARCHAR), Length(30,true), Default(None) */
    val issuingUnit: Rep[Option[String]] = column[Option[String]]("issuing_unit", O.Length(30,varying=true), O.Default(None))
    /** Database column valid_date SqlType(VARCHAR), Length(30,true), Default(None) */
    val validDate: Rep[Option[String]] = column[Option[String]]("valid_date", O.Length(30,varying=true), O.Default(None))
    /** Database column front_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val frontImage: Rep[Option[String]] = column[Option[String]]("front_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column back_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val backImage: Rep[Option[String]] = column[Option[String]]("back_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column person_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val personImage: Rep[Option[String]] = column[Option[String]]("person_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column small_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val smallImage: Rep[Option[String]] = column[Option[String]]("small_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column id_small_image SqlType(VARCHAR), Length(1000,true), Default(None) */
    val idSmallImage: Rep[Option[String]] = column[Option[String]]("id_small_image", O.Length(1000,varying=true), O.Default(None))
    /** Database column extend_fld SqlType(VARCHAR), Length(500,true), Default(None) */
    val extendFld: Rep[Option[String]] = column[Option[String]]("extend_fld", O.Length(500,varying=true), O.Default(None))

    /** Index over (userId) (database name idx_t_identity_cards_user_uuid) */
    val index1 = index("idx_t_identity_cards_user_uuid", userId)
    /** Uniqueness Index over (uuid) (database name idx_t_identity_cards_uuid) */
    val index2 = index("idx_t_identity_cards_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TIdentityCards */
  lazy val TIdentityCards = new TableQuery(tag => new TIdentityCards(tag))

  /** Entity class storing rows of table TLoanLog
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param userUuid Database column user_uuid SqlType(VARCHAR), Length(32,true)
   *  @param userClientid Database column user_clientId SqlType(VARCHAR), Length(45,true)
   *  @param orderUuid Database column order_uuid SqlType(VARCHAR), Length(32,true)
   *  @param orderApplyid Database column order_applyId SqlType(VARCHAR), Length(45,true)
   *  @param contractUuid Database column contract_uuid SqlType(VARCHAR), Length(32,true)
   *  @param loanResult Database column loan_result SqlType(BIT)
   *  @param msg Database column msg SqlType(VARCHAR), Length(200,true)
   *  @param loanRequestDate Database column loan_request_date SqlType(DATETIME)
   *  @param executeDate Database column execute_date SqlType(DATETIME) */
  case class TLoanLogRow(id: Int, uuid: String, createTime: java.sql.Timestamp, userUuid: String, userClientid: String, orderUuid: String, orderApplyid: String, contractUuid: String, loanResult: Boolean, msg: String, loanRequestDate: java.sql.Timestamp, executeDate: java.sql.Timestamp)
  /** GetResult implicit for fetching TLoanLogRow objects using plain SQL queries */
  implicit def GetResultTLoanLogRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean]): GR[TLoanLogRow] = GR{
    prs => import prs._
    TLoanLogRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table t_loan_log. Objects of this class serve as prototypes for rows in queries. */
  class TLoanLog(_tableTag: Tag) extends Table[TLoanLogRow](_tableTag, "t_loan_log") {
    def * = (id, uuid, createTime, userUuid, userClientid, orderUuid, orderApplyid, contractUuid, loanResult, msg, loanRequestDate, executeDate) <> (TLoanLogRow.tupled, TLoanLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(userUuid), Rep.Some(userClientid), Rep.Some(orderUuid), Rep.Some(orderApplyid), Rep.Some(contractUuid), Rep.Some(loanResult), Rep.Some(msg), Rep.Some(loanRequestDate), Rep.Some(executeDate)).shaped.<>({r=>import r._; _1.map(_=> TLoanLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column user_uuid SqlType(VARCHAR), Length(32,true) */
    val userUuid: Rep[String] = column[String]("user_uuid", O.Length(32,varying=true))
    /** Database column user_clientId SqlType(VARCHAR), Length(45,true) */
    val userClientid: Rep[String] = column[String]("user_clientId", O.Length(45,varying=true))
    /** Database column order_uuid SqlType(VARCHAR), Length(32,true) */
    val orderUuid: Rep[String] = column[String]("order_uuid", O.Length(32,varying=true))
    /** Database column order_applyId SqlType(VARCHAR), Length(45,true) */
    val orderApplyid: Rep[String] = column[String]("order_applyId", O.Length(45,varying=true))
    /** Database column contract_uuid SqlType(VARCHAR), Length(32,true) */
    val contractUuid: Rep[String] = column[String]("contract_uuid", O.Length(32,varying=true))
    /** Database column loan_result SqlType(BIT) */
    val loanResult: Rep[Boolean] = column[Boolean]("loan_result")
    /** Database column msg SqlType(VARCHAR), Length(200,true) */
    val msg: Rep[String] = column[String]("msg", O.Length(200,varying=true))
    /** Database column loan_request_date SqlType(DATETIME) */
    val loanRequestDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("loan_request_date")
    /** Database column execute_date SqlType(DATETIME) */
    val executeDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("execute_date")

    /** Uniqueness Index over (uuid) (database name uuid_UNIQUE) */
    val index1 = index("uuid_UNIQUE", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TLoanLog */
  lazy val TLoanLog = new TableQuery(tag => new TLoanLog(tag))

  /** Entity class storing rows of table TLoanLog2
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param userUuid Database column user_uuid SqlType(VARCHAR), Length(32,true)
   *  @param userClientid Database column user_clientId SqlType(VARCHAR), Length(45,true)
   *  @param orderUuid Database column order_uuid SqlType(VARCHAR), Length(32,true)
   *  @param orderApplyid Database column order_applyId SqlType(VARCHAR), Length(45,true)
   *  @param contractUuid Database column contract_uuid SqlType(VARCHAR), Length(32,true)
   *  @param loanResult Database column loan_result SqlType(BIT)
   *  @param msg Database column msg SqlType(VARCHAR), Length(200,true)
   *  @param loanRequestDate Database column loan_request_date SqlType(DATETIME)
   *  @param executeDate Database column execute_date SqlType(DATETIME) */
  case class TLoanLog2Row(id: Int, uuid: String, createTime: java.sql.Timestamp, userUuid: String, userClientid: String, orderUuid: String, orderApplyid: String, contractUuid: String, loanResult: Boolean, msg: String, loanRequestDate: java.sql.Timestamp, executeDate: java.sql.Timestamp)
  /** GetResult implicit for fetching TLoanLog2Row objects using plain SQL queries */
  implicit def GetResultTLoanLog2Row(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean]): GR[TLoanLog2Row] = GR{
    prs => import prs._
    TLoanLog2Row.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table t_loan_log2. Objects of this class serve as prototypes for rows in queries. */
  class TLoanLog2(_tableTag: Tag) extends Table[TLoanLog2Row](_tableTag, "t_loan_log2") {
    def * = (id, uuid, createTime, userUuid, userClientid, orderUuid, orderApplyid, contractUuid, loanResult, msg, loanRequestDate, executeDate) <> (TLoanLog2Row.tupled, TLoanLog2Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(userUuid), Rep.Some(userClientid), Rep.Some(orderUuid), Rep.Some(orderApplyid), Rep.Some(contractUuid), Rep.Some(loanResult), Rep.Some(msg), Rep.Some(loanRequestDate), Rep.Some(executeDate)).shaped.<>({r=>import r._; _1.map(_=> TLoanLog2Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column user_uuid SqlType(VARCHAR), Length(32,true) */
    val userUuid: Rep[String] = column[String]("user_uuid", O.Length(32,varying=true))
    /** Database column user_clientId SqlType(VARCHAR), Length(45,true) */
    val userClientid: Rep[String] = column[String]("user_clientId", O.Length(45,varying=true))
    /** Database column order_uuid SqlType(VARCHAR), Length(32,true) */
    val orderUuid: Rep[String] = column[String]("order_uuid", O.Length(32,varying=true))
    /** Database column order_applyId SqlType(VARCHAR), Length(45,true) */
    val orderApplyid: Rep[String] = column[String]("order_applyId", O.Length(45,varying=true))
    /** Database column contract_uuid SqlType(VARCHAR), Length(32,true) */
    val contractUuid: Rep[String] = column[String]("contract_uuid", O.Length(32,varying=true))
    /** Database column loan_result SqlType(BIT) */
    val loanResult: Rep[Boolean] = column[Boolean]("loan_result")
    /** Database column msg SqlType(VARCHAR), Length(200,true) */
    val msg: Rep[String] = column[String]("msg", O.Length(200,varying=true))
    /** Database column loan_request_date SqlType(DATETIME) */
    val loanRequestDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("loan_request_date")
    /** Database column execute_date SqlType(DATETIME) */
    val executeDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("execute_date")

    /** Uniqueness Index over (uuid) (database name uuid_UNIQUE) */
    val index1 = index("uuid_UNIQUE", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TLoanLog2 */
  lazy val TLoanLog2 = new TableQuery(tag => new TLoanLog2(tag))

  /** Entity class storing rows of table TOperateLog
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(BIGINT)
   *  @param adminId Database column admin_id SqlType(VARCHAR), Length(32,true)
   *  @param operateType Database column operate_type SqlType(VARCHAR), Length(32,true)
   *  @param remark Database column remark SqlType(VARCHAR), Length(4000,true), Default(None) */
  case class TOperateLogRow(id: Int, uuid: String, createTime: Long, adminId: String, operateType: String, remark: Option[String] = None)
  /** GetResult implicit for fetching TOperateLogRow objects using plain SQL queries */
  implicit def GetResultTOperateLogRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Long], e3: GR[Option[String]]): GR[TOperateLogRow] = GR{
    prs => import prs._
    TOperateLogRow.tupled((<<[Int], <<[String], <<[Long], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table t_operate_log. Objects of this class serve as prototypes for rows in queries. */
  class TOperateLog(_tableTag: Tag) extends Table[TOperateLogRow](_tableTag, "t_operate_log") {
    def * = (id, uuid, createTime, adminId, operateType, remark) <> (TOperateLogRow.tupled, TOperateLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(adminId), Rep.Some(operateType), remark).shaped.<>({r=>import r._; _1.map(_=> TOperateLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(BIGINT) */
    val createTime: Rep[Long] = column[Long]("create_time")
    /** Database column admin_id SqlType(VARCHAR), Length(32,true) */
    val adminId: Rep[String] = column[String]("admin_id", O.Length(32,varying=true))
    /** Database column operate_type SqlType(VARCHAR), Length(32,true) */
    val operateType: Rep[String] = column[String]("operate_type", O.Length(32,varying=true))
    /** Database column remark SqlType(VARCHAR), Length(4000,true), Default(None) */
    val remark: Rep[Option[String]] = column[Option[String]]("remark", O.Length(4000,varying=true), O.Default(None))

    /** Index over (createTime) (database name idx_t_operate_log_create_time) */
    val index1 = index("idx_t_operate_log_create_time", createTime)
  }
  /** Collection-like TableQuery object for table TOperateLog */
  lazy val TOperateLog = new TableQuery(tag => new TOperateLog(tag))

  /** Entity class storing rows of table TOrdersYxd
   *  @param id Database column id SqlType(INT), AutoInc
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param userUuid Database column user_uuid SqlType(VARCHAR), Length(32,true)
   *  @param status Database column status SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param description Database column description SqlType(VARCHAR), Length(300,true), Default(None)
   *  @param applyId Database column apply_id SqlType(VARCHAR), Length(45,true) */
  case class TOrdersYxdRow(id: Int, uuid: String, userUuid: String, status: Int = 0, createTime: java.sql.Timestamp, description: Option[String] = None, applyId: String)
  /** GetResult implicit for fetching TOrdersYxdRow objects using plain SQL queries */
  implicit def GetResultTOrdersYxdRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TOrdersYxdRow] = GR{
    prs => import prs._
    TOrdersYxdRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[java.sql.Timestamp], <<?[String], <<[String]))
  }
  /** Table description of table t_orders_yxd. Objects of this class serve as prototypes for rows in queries. */
  class TOrdersYxd(_tableTag: Tag) extends Table[TOrdersYxdRow](_tableTag, "t_orders_yxd") {
    def * = (id, uuid, userUuid, status, createTime, description, applyId) <> (TOrdersYxdRow.tupled, TOrdersYxdRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(userUuid), Rep.Some(status), Rep.Some(createTime), description, Rep.Some(applyId)).shaped.<>({r=>import r._; _1.map(_=> TOrdersYxdRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc */
    val id: Rep[Int] = column[Int]("id", O.AutoInc)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column user_uuid SqlType(VARCHAR), Length(32,true) */
    val userUuid: Rep[String] = column[String]("user_uuid", O.Length(32,varying=true))
    /** Database column status SqlType(INT), Default(0) */
    val status: Rep[Int] = column[Int]("status", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column description SqlType(VARCHAR), Length(300,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(300,varying=true), O.Default(None))
    /** Database column apply_id SqlType(VARCHAR), Length(45,true) */
    val applyId: Rep[String] = column[String]("apply_id", O.Length(45,varying=true))

    /** Primary key of TOrdersYxd (database name t_orders_yxd_PK) */
    val pk = primaryKey("t_orders_yxd_PK", (id, uuid))

    /** Index over (applyId) (database name index_applyid) */
    val index1 = index("index_applyid", applyId)
  }
  /** Collection-like TableQuery object for table TOrdersYxd */
  lazy val TOrdersYxd = new TableQuery(tag => new TOrdersYxd(tag))

  /** Entity class storing rows of table TPushLog
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param pushId Database column push_id SqlType(VARCHAR), Length(64,true)
   *  @param content Database column content SqlType(VARCHAR), Length(200,true)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param result Database column result SqlType(BIT) */
  case class TPushLogRow(id: Int, uuid: String, createTime: java.sql.Timestamp, pushId: String, content: String, userId: String, result: Boolean)
  /** GetResult implicit for fetching TPushLogRow objects using plain SQL queries */
  implicit def GetResultTPushLogRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean]): GR[TPushLogRow] = GR{
    prs => import prs._
    TPushLogRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table t_push_log. Objects of this class serve as prototypes for rows in queries. */
  class TPushLog(_tableTag: Tag) extends Table[TPushLogRow](_tableTag, "t_push_log") {
    def * = (id, uuid, createTime, pushId, content, userId, result) <> (TPushLogRow.tupled, TPushLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(createTime), Rep.Some(pushId), Rep.Some(content), Rep.Some(userId), Rep.Some(result)).shaped.<>({r=>import r._; _1.map(_=> TPushLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column push_id SqlType(VARCHAR), Length(64,true) */
    val pushId: Rep[String] = column[String]("push_id", O.Length(64,varying=true))
    /** Database column content SqlType(VARCHAR), Length(200,true) */
    val content: Rep[String] = column[String]("content", O.Length(200,varying=true))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column result SqlType(BIT) */
    val result: Rep[Boolean] = column[Boolean]("result")

    /** Index over (pushId) (database name idx_t_push_log_push_id) */
    val index1 = index("idx_t_push_log_push_id", pushId)
    /** Index over (userId) (database name idx_t_push_log_user_id) */
    val index2 = index("idx_t_push_log_user_id", userId)
  }
  /** Collection-like TableQuery object for table TPushLog */
  lazy val TPushLog = new TableQuery(tag => new TPushLog(tag))

  /** Entity class storing rows of table TRepayStatus
   *  @param id Database column id SqlType(INT), AutoInc
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param orderUuid Database column order_uuid SqlType(VARCHAR), Length(32,true)
   *  @param userUuid Database column user_uuid SqlType(VARCHAR), Length(32,true)
   *  @param status Database column status SqlType(INT)
   *  @param term Database column term SqlType(INT)
   *  @param applyId Database column apply_id SqlType(VARCHAR), Length(45,true)
   *  @param createTime Database column create_time SqlType(DATETIME) */
  case class TRepayStatusRow(id: Int, uuid: String, orderUuid: String, userUuid: String, status: Int, term: Int, applyId: String, createTime: java.sql.Timestamp)
  /** GetResult implicit for fetching TRepayStatusRow objects using plain SQL queries */
  implicit def GetResultTRepayStatusRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TRepayStatusRow] = GR{
    prs => import prs._
    TRepayStatusRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table t_repay_status. Objects of this class serve as prototypes for rows in queries. */
  class TRepayStatus(_tableTag: Tag) extends Table[TRepayStatusRow](_tableTag, "t_repay_status") {
    def * = (id, uuid, orderUuid, userUuid, status, term, applyId, createTime) <> (TRepayStatusRow.tupled, TRepayStatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(orderUuid), Rep.Some(userUuid), Rep.Some(status), Rep.Some(term), Rep.Some(applyId), Rep.Some(createTime)).shaped.<>({r=>import r._; _1.map(_=> TRepayStatusRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc */
    val id: Rep[Int] = column[Int]("id", O.AutoInc)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column order_uuid SqlType(VARCHAR), Length(32,true) */
    val orderUuid: Rep[String] = column[String]("order_uuid", O.Length(32,varying=true))
    /** Database column user_uuid SqlType(VARCHAR), Length(32,true) */
    val userUuid: Rep[String] = column[String]("user_uuid", O.Length(32,varying=true))
    /** Database column status SqlType(INT) */
    val status: Rep[Int] = column[Int]("status")
    /** Database column term SqlType(INT) */
    val term: Rep[Int] = column[Int]("term")
    /** Database column apply_id SqlType(VARCHAR), Length(45,true) */
    val applyId: Rep[String] = column[String]("apply_id", O.Length(45,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")

    /** Primary key of TRepayStatus (database name t_repay_status_PK) */
    val pk = primaryKey("t_repay_status_PK", (id, uuid))

    /** Index over (applyId) (database name index_applyid) */
    val index1 = index("index_applyid", applyId)
  }
  /** Collection-like TableQuery object for table TRepayStatus */
  lazy val TRepayStatus = new TableQuery(tag => new TRepayStatus(tag))

  /** Entity class storing rows of table TRole
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param createTime Database column create_time SqlType(BIGINT), Default(None)
   *  @param modifyTime Database column modify_time SqlType(BIGINT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param auth Database column auth SqlType(VARCHAR), Length(32,true)
   *  @param remark Database column remark SqlType(VARCHAR), Length(32,true) */
  case class TRoleRow(id: Int, uuid: Option[String] = None, createTime: Option[Long] = None, modifyTime: Option[Long] = None, name: String, auth: String, remark: String)
  /** GetResult implicit for fetching TRoleRow objects using plain SQL queries */
  implicit def GetResultTRoleRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[String]): GR[TRoleRow] = GR{
    prs => import prs._
    TRoleRow.tupled((<<[Int], <<?[String], <<?[Long], <<?[Long], <<[String], <<[String], <<[String]))
  }
  /** Table description of table t_role. Objects of this class serve as prototypes for rows in queries. */
  class TRole(_tableTag: Tag) extends Table[TRoleRow](_tableTag, "t_role") {
    def * = (id, uuid, createTime, modifyTime, name, auth, remark) <> (TRoleRow.tupled, TRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), uuid, createTime, modifyTime, Rep.Some(name), Rep.Some(auth), Rep.Some(remark)).shaped.<>({r=>import r._; _1.map(_=> TRoleRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true), Default(None) */
    val uuid: Rep[Option[String]] = column[Option[String]]("uuid", O.Length(32,varying=true), O.Default(None))
    /** Database column create_time SqlType(BIGINT), Default(None) */
    val createTime: Rep[Option[Long]] = column[Option[Long]]("create_time", O.Default(None))
    /** Database column modify_time SqlType(BIGINT), Default(None) */
    val modifyTime: Rep[Option[Long]] = column[Option[Long]]("modify_time", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column auth SqlType(VARCHAR), Length(32,true) */
    val auth: Rep[String] = column[String]("auth", O.Length(32,varying=true))
    /** Database column remark SqlType(VARCHAR), Length(32,true) */
    val remark: Rep[String] = column[String]("remark", O.Length(32,varying=true))

    /** Uniqueness Index over (uuid) (database name idx_t_role_uuid) */
    val index1 = index("idx_t_role_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TRole */
  lazy val TRole = new TableQuery(tag => new TRole(tag))

  /** Entity class storing rows of table TRuleResults
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param content Database column content SqlType(TEXT), Default(None)
   *  @param decision Database column decision SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param orderId Database column order_id SqlType(VARCHAR), Length(32,true)
   *  @param source Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
  case class TRuleResultsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, content: Option[String] = None, decision: Option[String] = None, userId: String, orderId: String, source: Option[String] = None)
  /** GetResult implicit for fetching TRuleResultsRow objects using plain SQL queries */
  implicit def GetResultTRuleResultsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TRuleResultsRow] = GR{
    prs => import prs._
    TRuleResultsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<?[String], <<?[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table t_rule_results. Objects of this class serve as prototypes for rows in queries. */
  class TRuleResults(_tableTag: Tag) extends Table[TRuleResultsRow](_tableTag, "t_rule_results") {
    def * = (id, uuid, deleted, createTime, content, decision, userId, orderId, source) <> (TRuleResultsRow.tupled, TRuleResultsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), content, decision, Rep.Some(userId), Rep.Some(orderId), source).shaped.<>({r=>import r._; _1.map(_=> TRuleResultsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get, _8.get, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column content SqlType(TEXT), Default(None) */
    val content: Rep[Option[String]] = column[Option[String]]("content", O.Default(None))
    /** Database column decision SqlType(VARCHAR), Length(50,true), Default(None) */
    val decision: Rep[Option[String]] = column[Option[String]]("decision", O.Length(50,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column order_id SqlType(VARCHAR), Length(32,true) */
    val orderId: Rep[String] = column[String]("order_id", O.Length(32,varying=true))
    /** Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
    val source: Rep[Option[String]] = column[Option[String]]("source", O.Length(60,varying=true), O.Default(None))

    /** Index over (uuid) (database name index_t_rule_results_0_uuid) */
    val index1 = index("index_t_rule_results_0_uuid", uuid)
  }
  /** Collection-like TableQuery object for table TRuleResults */
  lazy val TRuleResults = new TableQuery(tag => new TRuleResults(tag))

  /** Entity class storing rows of table TSchools
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param shcoolCode Database column shcool_code SqlType(VARCHAR), Length(45,true)
   *  @param schoolName Database column school_name SqlType(VARCHAR), Length(45,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME) */
  case class TSchoolsRow(id: Int, uuid: String, shcoolCode: String, schoolName: String, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp)
  /** GetResult implicit for fetching TSchoolsRow objects using plain SQL queries */
  implicit def GetResultTSchoolsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TSchoolsRow] = GR{
    prs => import prs._
    TSchoolsRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table t_schools. Objects of this class serve as prototypes for rows in queries. */
  class TSchools(_tableTag: Tag) extends Table[TSchoolsRow](_tableTag, "t_schools") {
    def * = (id, uuid, shcoolCode, schoolName, createTime, modifyTime) <> (TSchoolsRow.tupled, TSchoolsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(shcoolCode), Rep.Some(schoolName), Rep.Some(createTime), Rep.Some(modifyTime)).shaped.<>({r=>import r._; _1.map(_=> TSchoolsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column shcool_code SqlType(VARCHAR), Length(45,true) */
    val shcoolCode: Rep[String] = column[String]("shcool_code", O.Length(45,varying=true))
    /** Database column school_name SqlType(VARCHAR), Length(45,true) */
    val schoolName: Rep[String] = column[String]("school_name", O.Length(45,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
  }
  /** Collection-like TableQuery object for table TSchools */
  lazy val TSchools = new TableQuery(tag => new TSchools(tag))

  /** Entity class storing rows of table TSignway
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param way Database column way SqlType(VARCHAR), Length(16,true)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param orderId Database column order_id SqlType(VARCHAR), Length(32,true)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param source Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
  case class TSignwayRow(id: Int, uuid: String, way: String, userId: String, orderId: String, createTime: java.sql.Timestamp, source: Option[String] = None)
  /** GetResult implicit for fetching TSignwayRow objects using plain SQL queries */
  implicit def GetResultTSignwayRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TSignwayRow] = GR{
    prs => import prs._
    TSignwayRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table t_signway. Objects of this class serve as prototypes for rows in queries. */
  class TSignway(_tableTag: Tag) extends Table[TSignwayRow](_tableTag, "t_signway") {
    def * = (id, uuid, way, userId, orderId, createTime, source) <> (TSignwayRow.tupled, TSignwayRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(way), Rep.Some(userId), Rep.Some(orderId), Rep.Some(createTime), source).shaped.<>({r=>import r._; _1.map(_=> TSignwayRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column way SqlType(VARCHAR), Length(16,true) */
    val way: Rep[String] = column[String]("way", O.Length(16,varying=true))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column order_id SqlType(VARCHAR), Length(32,true) */
    val orderId: Rep[String] = column[String]("order_id", O.Length(32,varying=true))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column source SqlType(VARCHAR), Length(60,true), Default(None) */
    val source: Rep[Option[String]] = column[Option[String]]("source", O.Length(60,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table TSignway */
  lazy val TSignway = new TableQuery(tag => new TSignway(tag))

  /** Entity class storing rows of table TSupplements
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param name Database column name SqlType(VARCHAR), Length(32,true)
   *  @param supplementType Database column supplement_type SqlType(VARCHAR), Length(32,true)
   *  @param content Database column content SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param loanApplyId Database column loan_apply_id SqlType(VARCHAR), Length(45,true), Default(None) */
  case class TSupplementsRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, name: String, supplementType: String, content: Option[String] = None, userId: String, loanApplyId: Option[String] = None)
  /** GetResult implicit for fetching TSupplementsRow objects using plain SQL queries */
  implicit def GetResultTSupplementsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TSupplementsRow] = GR{
    prs => import prs._
    TSupplementsRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<?[String], <<[String], <<?[String]))
  }
  /** Table description of table t_supplements. Objects of this class serve as prototypes for rows in queries. */
  class TSupplements(_tableTag: Tag) extends Table[TSupplementsRow](_tableTag, "t_supplements") {
    def * = (id, uuid, deleted, createTime, modifyTime, name, supplementType, content, userId, loanApplyId) <> (TSupplementsRow.tupled, TSupplementsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(name), Rep.Some(supplementType), content, Rep.Some(userId), loanApplyId).shaped.<>({r=>import r._; _1.map(_=> TSupplementsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9.get, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column name SqlType(VARCHAR), Length(32,true) */
    val name: Rep[String] = column[String]("name", O.Length(32,varying=true))
    /** Database column supplement_type SqlType(VARCHAR), Length(32,true) */
    val supplementType: Rep[String] = column[String]("supplement_type", O.Length(32,varying=true))
    /** Database column content SqlType(VARCHAR), Length(500,true), Default(None) */
    val content: Rep[Option[String]] = column[Option[String]]("content", O.Length(500,varying=true), O.Default(None))
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column loan_apply_id SqlType(VARCHAR), Length(45,true), Default(None) */
    val loanApplyId: Rep[Option[String]] = column[Option[String]]("loan_apply_id", O.Length(45,varying=true), O.Default(None))

    /** Index over (userId) (database name idx_t_supplements_user_id) */
    val index1 = index("idx_t_supplements_user_id", userId)
    /** Uniqueness Index over (uuid) (database name idx_t_supplements_uuid) */
    val index2 = index("idx_t_supplements_uuid", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table TSupplements */
  lazy val TSupplements = new TableQuery(tag => new TSupplements(tag))

  /** Entity class storing rows of table TUserLiving
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param deleted Database column deleted SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(32,true)
   *  @param livingImage Database column living_image SqlType(VARCHAR), Length(2000,true)
   *  @param faceScore Database column face_score SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param idCardScore Database column id_card_score SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param faceidScore Database column faceid_score SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param delta Database column delta SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param livingImageLocal Database column living_image_local SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param `type` Database column type SqlType(VARCHAR), Length(45,true), Default(Some(Face++)) */
  case class TUserLivingRow(id: Int, uuid: String, deleted: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, userId: String, livingImage: String, faceScore: Option[String] = None, idCardScore: Option[String] = None, faceidScore: Option[String] = None, delta: Option[String] = None, livingImageLocal: Option[String] = None, `type`: Option[String] = Some("Face++"))
  /** GetResult implicit for fetching TUserLivingRow objects using plain SQL queries */
  implicit def GetResultTUserLivingRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[TUserLivingRow] = GR{
    prs => import prs._
    TUserLivingRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table t_user_living. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class TUserLiving(_tableTag: Tag) extends Table[TUserLivingRow](_tableTag, "t_user_living") {
    def * = (id, uuid, deleted, createTime, modifyTime, userId, livingImage, faceScore, idCardScore, faceidScore, delta, livingImageLocal, `type`) <> (TUserLivingRow.tupled, TUserLivingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(deleted), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(userId), Rep.Some(livingImage), faceScore, idCardScore, faceidScore, delta, livingImageLocal, `type`).shaped.<>({r=>import r._; _1.map(_=> TUserLivingRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column deleted SqlType(INT), Default(0) */
    val deleted: Rep[Int] = column[Int]("deleted", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column user_id SqlType(VARCHAR), Length(32,true) */
    val userId: Rep[String] = column[String]("user_id", O.Length(32,varying=true))
    /** Database column living_image SqlType(VARCHAR), Length(2000,true) */
    val livingImage: Rep[String] = column[String]("living_image", O.Length(2000,varying=true))
    /** Database column face_score SqlType(VARCHAR), Length(45,true), Default(None) */
    val faceScore: Rep[Option[String]] = column[Option[String]]("face_score", O.Length(45,varying=true), O.Default(None))
    /** Database column id_card_score SqlType(VARCHAR), Length(45,true), Default(None) */
    val idCardScore: Rep[Option[String]] = column[Option[String]]("id_card_score", O.Length(45,varying=true), O.Default(None))
    /** Database column faceid_score SqlType(VARCHAR), Length(45,true), Default(None) */
    val faceidScore: Rep[Option[String]] = column[Option[String]]("faceid_score", O.Length(45,varying=true), O.Default(None))
    /** Database column delta SqlType(VARCHAR), Length(45,true), Default(None) */
    val delta: Rep[Option[String]] = column[Option[String]]("delta", O.Length(45,varying=true), O.Default(None))
    /** Database column living_image_local SqlType(VARCHAR), Length(1000,true), Default(None) */
    val livingImageLocal: Rep[Option[String]] = column[Option[String]]("living_image_local", O.Length(1000,varying=true), O.Default(None))
    /** Database column type SqlType(VARCHAR), Length(45,true), Default(Some(Face++))
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Length(45,varying=true), O.Default(Some("Face++")))

    /** Index over (userId) (database name idx_t_user_living_user_id) */
    val index1 = index("idx_t_user_living_user_id", userId)
  }
  /** Collection-like TableQuery object for table TUserLiving */
  lazy val TUserLiving = new TableQuery(tag => new TUserLiving(tag))

  /** Entity class storing rows of table TUsers
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(32,true)
   *  @param validate Database column validate SqlType(INT), Default(0)
   *  @param createTime Database column create_time SqlType(DATETIME)
   *  @param modifyTime Database column modify_time SqlType(DATETIME)
   *  @param phoneNumber Database column phone_number SqlType(VARCHAR), Length(20,true)
   *  @param realName Database column real_name SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param lastLoginTime Database column last_login_time SqlType(DATETIME)
   *  @param headImageUrl Database column head_image_url SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param loginDevId Database column login_dev_id SqlType(VARCHAR), Length(64,true), Default(0)
   *  @param ecifId Database column ecif_id SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param valiadeDate Database column valiade_date SqlType(DATETIME), Default(None)
   *  @param password Database column password SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param salt Database column salt SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param workStatus Database column work_status SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param qqNo Database column qq_no SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(32,true), Default(None)
   *  @param alternatePhone Database column alternate_phone SqlType(VARCHAR), Length(20,true), Default(None)
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(45,true), Default(None) */
  case class TUsersRow(id: Int, uuid: String, validate: Int = 0, createTime: java.sql.Timestamp, modifyTime: java.sql.Timestamp, phoneNumber: String, realName: Option[String] = None, lastLoginTime: java.sql.Timestamp, headImageUrl: Option[String] = None, loginDevId: String = "0", ecifId: Option[String] = None, valiadeDate: Option[java.sql.Timestamp] = None, password: Option[String] = None, salt: Option[String] = None, workStatus: Option[String] = None, qqNo: Option[String] = None, email: Option[String] = None, alternatePhone: Option[String] = None, clientId: Option[String] = None)
  /** GetResult implicit for fetching TUsersRow objects using plain SQL queries */
  implicit def GetResultTUsersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Option[java.sql.Timestamp]]): GR[TUsersRow] = GR{
    prs => import prs._
    TUsersRow.tupled((<<[Int], <<[String], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<?[String], <<[java.sql.Timestamp], <<?[String], <<[String], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table t_users. Objects of this class serve as prototypes for rows in queries. */
  class TUsers(_tableTag: Tag) extends Table[TUsersRow](_tableTag, "t_users") {
    def * = (id, uuid, validate, createTime, modifyTime, phoneNumber, realName, lastLoginTime, headImageUrl, loginDevId, ecifId, valiadeDate, password, salt, workStatus, qqNo, email, alternatePhone, clientId) <> (TUsersRow.tupled, TUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(validate), Rep.Some(createTime), Rep.Some(modifyTime), Rep.Some(phoneNumber), realName, Rep.Some(lastLoginTime), headImageUrl, Rep.Some(loginDevId), ecifId, valiadeDate, password, salt, workStatus, qqNo, email, alternatePhone, clientId).shaped.<>({r=>import r._; _1.map(_=> TUsersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9, _10.get, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(32,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(32,varying=true))
    /** Database column validate SqlType(INT), Default(0) */
    val validate: Rep[Int] = column[Int]("validate", O.Default(0))
    /** Database column create_time SqlType(DATETIME) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_time")
    /** Database column modify_time SqlType(DATETIME) */
    val modifyTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("modify_time")
    /** Database column phone_number SqlType(VARCHAR), Length(20,true) */
    val phoneNumber: Rep[String] = column[String]("phone_number", O.Length(20,varying=true))
    /** Database column real_name SqlType(VARCHAR), Length(50,true), Default(None) */
    val realName: Rep[Option[String]] = column[Option[String]]("real_name", O.Length(50,varying=true), O.Default(None))
    /** Database column last_login_time SqlType(DATETIME) */
    val lastLoginTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_login_time")
    /** Database column head_image_url SqlType(VARCHAR), Length(100,true), Default(None) */
    val headImageUrl: Rep[Option[String]] = column[Option[String]]("head_image_url", O.Length(100,varying=true), O.Default(None))
    /** Database column login_dev_id SqlType(VARCHAR), Length(64,true), Default(0) */
    val loginDevId: Rep[String] = column[String]("login_dev_id", O.Length(64,varying=true), O.Default("0"))
    /** Database column ecif_id SqlType(VARCHAR), Length(32,true), Default(None) */
    val ecifId: Rep[Option[String]] = column[Option[String]]("ecif_id", O.Length(32,varying=true), O.Default(None))
    /** Database column valiade_date SqlType(DATETIME), Default(None) */
    val valiadeDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("valiade_date", O.Default(None))
    /** Database column password SqlType(VARCHAR), Length(45,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(45,varying=true), O.Default(None))
    /** Database column salt SqlType(VARCHAR), Length(45,true), Default(None) */
    val salt: Rep[Option[String]] = column[Option[String]]("salt", O.Length(45,varying=true), O.Default(None))
    /** Database column work_status SqlType(VARCHAR), Length(32,true), Default(None) */
    val workStatus: Rep[Option[String]] = column[Option[String]]("work_status", O.Length(32,varying=true), O.Default(None))
    /** Database column qq_no SqlType(VARCHAR), Length(32,true), Default(None) */
    val qqNo: Rep[Option[String]] = column[Option[String]]("qq_no", O.Length(32,varying=true), O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(32,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(32,varying=true), O.Default(None))
    /** Database column alternate_phone SqlType(VARCHAR), Length(20,true), Default(None) */
    val alternatePhone: Rep[Option[String]] = column[Option[String]]("alternate_phone", O.Length(20,varying=true), O.Default(None))
    /** Database column client_id SqlType(VARCHAR), Length(45,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("client_id", O.Length(45,varying=true), O.Default(None))

    /** Uniqueness Index over (uuid) (database name idx_t_users_uuid) */
    val index1 = index("idx_t_users_uuid", uuid, unique=true)
    /** Uniqueness Index over (phoneNumber) (database name phone_number) */
    val index2 = index("phone_number", phoneNumber, unique=true)
  }
  /** Collection-like TableQuery object for table TUsers */
  lazy val TUsers = new TableQuery(tag => new TUsers(tag))
}
