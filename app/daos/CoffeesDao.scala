package daos

import com.google.inject.{Inject, Singleton}
import providers.DBProvider

import scala.concurrent.{ExecutionContext, Future}
import com.anubis.practise.models.Tables._
import com.anubis.practise.models.Tables.profile.api._
import com.mysql.jdbc.Blob
import slick.backend.DatabasePublisher

/**
  * Created by huangzhibo on 23/01/2017.
  */
@Singleton
class CoffeesDao @Inject()(dBProvider: DBProvider)(implicit executionContext: ExecutionContext) {

    /**
      * DBIOAction
      */

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
        // error
//        dBProvider.dbRun(
//            Coffees.result
//        ).map(_.foreach{
//            case (name, supID, price, sales, total) =>
//                println("  " + name + "\t" + supID + "\t" + price + "\t" + sales + "\t" + total)
//        })
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

    val q = for (c <- Coffees) yield c.cofName
    val a = q.result
    val p: DatabasePublisher[Int] = dBProvider.defaultDB.db.stream(a)
    // Execution of the DBIOAction does not start until a Subscriber is attached to the stream.
    p.foreach { s => println(s"Element: $s")}


    // Blob类型
//    val q = for (c <- coffees) yield c.image
//    val a = q.result
//    val p1: DatabasePublisher[Blob] = db.stream(a)
//    val p2: DatabasePublisher[Array[Byte]] = p1.mapResult { b =>
//        b.getBytes(0, b.length().toInt)
//    }

    // Sequencial execution
    // The simplest combinator is DBIO.seq which takes a varargs list of actions to run in sequence,
    // discarding their return value. If you need the return value,
    // you can use andThen to combine two actions and keep the result of the second one.
    // If you need both return values of two actions, there is the zip combinator.
    // For getting all result values from a sequence of actions (of compatible types), use DBIO.sequence.

    // If an action depends on a previous action in the sequence, you have to compute it on the fly with flatMap or map.
    // These two methods plus filter enable the use of for comprehensions for action sequencing.

    // Similar to DBIO.sequence for upfront composition,
    // there is DBIO.fold for working with sequences of actions and composing them based on the previous result.

    // You can convert a Future into an action with DBIO.from.

    // Transactions and Pinned Sessions


    // 删除所有total以"Es"开头的。
    val at = (for {
        ns <- Coffees.filter(_.total.startsWith("Es")).map(_.total).result
        _ <- DBIO.seq(ns.map(n => Coffees.filter(_.total === n).delete): _*)
    } yield ()).transactionally
    val f: Future[Unit] = dBProvider.dbRun(at)


}
