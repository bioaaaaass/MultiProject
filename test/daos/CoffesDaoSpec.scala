package daos

import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by huangzhibo on 17/02/2017.
  */
class CoffesDaoSpec extends PlaySpec with OneServerPerSuite {

    private val LOG = org.slf4j.LoggerFactory.getLogger(this.getClass)

    val cofDao = app.injector.instanceOf[CoffeesDao]

    "test slick" should {
        "coffes" in {
            val result = Await.result(cofDao.f, Duration.Inf)
        }
    }
}
