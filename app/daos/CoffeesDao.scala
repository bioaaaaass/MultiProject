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
}
