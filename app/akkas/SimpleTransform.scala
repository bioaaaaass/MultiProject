package akkas

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source, RunnableGraph}

import scala.concurrent.Future

/**
  * Created by huangzhibo on 08/02/2017.
  */
object SimpleTransform extends App {
    // Source -> Flow -> Sink
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()

    val source: Source[Int, NotUsed] = Source(1 to 100)
    val sink: Sink[Any, Future[Done]] = Sink.foreach(println)
    val helloTimesTen: Flow[Int, String, NotUsed] = Flow[Int].map(i => s"Hello ${i * 10}")
    val graph: RunnableGraph[NotUsed] = source via helloTimesTen to sink
    // RunnableGraph: Flow with attached input and output, can be executed.
    graph.run()
    system.terminate()
}
