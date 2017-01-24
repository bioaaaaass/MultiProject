import daos.{CoffeesDao, TestDao}
import org.scalatestplus.play.{OneAppPerSuite, OneServerPerSuite, PlaySpec}
import play.api.Logger

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by huangzhibo on 23/01/2017.
  */
class CoffeesDaoSpec extends PlaySpec with OneServerPerSuite {

    val LOG = Logger(this.getClass)

    val coffeesDao = app.injector.instanceOf[CoffeesDao]


    "test coffees dao" should {
        "run demo" in {

            //coffeesDao.test
            //val result = Await.result(coffeesDao.demoRun, Duration.Inf)
            //LOG.info(s"run demo result: $result")
        }
    }
}
