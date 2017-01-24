package daos

import com.google.inject.{Inject, Singleton}

/**
  * Created by huangzhibo on 24/01/2017.
  */
@Singleton
class TestDao @Inject()() {

    def test = {
        println(s"kkk")
    }
}
