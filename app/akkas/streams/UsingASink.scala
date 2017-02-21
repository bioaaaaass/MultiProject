package akkas.streams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import akka.{Done, NotUsed}

import scala.concurrent.Future

/**
  * Created by huangzhibo on 08/02/2017.
  */
object UsingASink extends App {
    // Source -> Sink
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()

    val source: Source[Int, NotUsed] = Source(1 to 100)
    val sink: Sink[Any, Future[Done]] = Sink.foreach(println)
    // The sink is materialized into a [[scala.concurrent.Future]]
    source.runWith(sink)
    system.terminate()

}
