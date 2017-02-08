package daos

import com.google.inject.{Inject, Singleton}
import providers.DBProvider

import scala.concurrent.{ExecutionContext, Future}
import com.anubis.practise.models.Tables._
import com.anubis.practise.models.Tables.profile.api._

/**
  * Created by huangzhibo on 23/01/2017.
  */
@Singleton
class CoffeesDao @Inject()(dBProvider: DBProvider)(implicit executionContext: ExecutionContext) {

    private val LOG = org.slf4j.LoggerFactory.getLogger(this.getClass)

    // Slick’s API is fully asynchronous and runs database call in a separate thread pool.

    def demosAction = {
        Coffees.filter(_.price < 10.0).sortBy(_.cofName).map(_.cofName)
        // equivalent to:
        // select name from COFFEES where PRICE < 10.0 order by NAME

        // plain sql support
        val limit = 10.0

        val plainSql1 = sql"SELECT COF_NAME FROM COFFEES WHERE PRICE < $limit".as[String]


    }

    def demoRun: Future[String] = {

        dBProvider.dbRun(
            TOrdersYxd.filter(_.applyId === "2134702").map(_.userUuid).result.head
        )
    }

    def readAllCoffees = {
        dBProvider.dbRun(
            Coffees.result
        ).map(_.foreach{
            case (name, supID, price, sales, total) =>
                println("  " + name + "\t" + supID + "\t" + price + "\t" + sales + "\t" + total)
        })
        // Equivalent SQL code:
        // select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES
    }

    def coffeesDemo = {
//        val q1 = for(c <- Coffees) yield LiteralColumn(" ") ++ c.cofName ++ "\t" ++ c.supId.asColumnOfType[String] ++
//        "\t" ++ c.price.asColumnOfType[String] ++ "\t" ++ c.sales.asColumnOfType[String] ++ "\t" ++ c.total.asColumnOfType[String]
        // The first string constant needs to be lifted manually to a LiteralColumn
        // so that the proper ++ operator is found

//        dBProvider.defaultDB.db.stream(q1.result).foreach(println)
    }

    def retrieveJoin = {

//        val coffees = TableQuery[Coffees]
//
//        val q2 = for {
//            c <- coffees if c.price < 9.0
//
//        }
    }
}
