package providers

import java.sql.Timestamp

import com.google.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.dbio.{DBIOAction, NoStream}
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Created by huangzhibo on 23/01/2017.
  */
@Singleton
class DBProvider @Inject()(databaseConfigProvider: DatabaseConfigProvider) {

    lazy val defaultDB = databaseConfigProvider.get[JdbcProfile]

    def generateUUID = java.util.UUID.randomUUID().toString.replace("-", "")

    // TODO: 生产uuid方法有哪些？各自优劣有哪些？

    def currentTimestamp = new Timestamp(System.currentTimeMillis())

    def dbRun[R](a: DBIOAction[R, NoStream, Nothing]): Future[R] = defaultDB.db.run(a)

}
