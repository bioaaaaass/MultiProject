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
class OrderYxdDao @Inject()(dBProvider: DBProvider)(implicit executionContext: ExecutionContext){

    private val LOG = org.slf4j.LoggerFactory.getLogger(this.getClass)

    def fetchApplyId = {
        val limit = 1023
//        val action = ( for (o <- TOrdersYxd; if o))

        val query1 = TOrdersYxd.map(_.applyId)   // Equivalent SQL: select `applyId` from t_orders_yxd

        val query2 = TOrdersYxd.filter(_.status > limit)     // Equivalent SQL: select * from t_orders_yxd where status > 1023

        val applyIds: Future[Seq[String]] = dBProvider.dbRun(
            query1.result
        )
    }

}
