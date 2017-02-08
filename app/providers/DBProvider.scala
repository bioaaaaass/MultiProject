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

    // In the body of the application we create a Database object which specifies how to connect to a database.
    // In most cases you will want to configure database connections with Typesafe Config in your application.conf

    lazy val defaultDB = databaseConfigProvider.get[JdbcProfile]

    def generateUUID = java.util.UUID.randomUUID().toString.replace("-", "")

    // TODO: 生产uuid方法有哪些？各自优劣有哪些？

    def currentTimestamp = new Timestamp(System.currentTimeMillis())

    def dbRun[R](a: DBIOAction[R, NoStream, Nothing]): Future[R] = defaultDB.db.run(a)


    /**
      * A Database object usually manages a thread pool and a connection pool.
      * You should always shut it down properly when it is no longer needed
      * (unless the JVM process terminates anyway).
      */
    /**
      * Action.seq, which can concatenate any number of Actions, discarding the return values
      * (i.e. the resulting Action produces a result of type Unit).
      */
}
