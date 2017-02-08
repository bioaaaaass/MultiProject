package akkas

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

/**
  * Created by huangzhibo on 08/02/2017.
  */
object HelloWorld extends App {

    implicit val system = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    val source: Source[Int, NotUsed] = Source(1 to 100)

    source.runForeach(println)

    system.terminate()
}
