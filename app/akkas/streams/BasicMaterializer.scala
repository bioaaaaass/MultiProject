package akkas.streams

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by huangzhibo on 09/02/2017.
  */
object BasicMaterializer extends App {

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()

    val intSource: Source[Int, NotUsed] = Source(1 to 100)
    val headSink: Sink[Int, Future[Int]] = Sink.head[Int]

    val graph1: RunnableGraph[Future[Int]] = intSource.toMat(headSink)(Keep.right)
    val graph2: RunnableGraph[NotUsed] = intSource.toMat(headSink)(Keep.left)

    // The types on these methods are very obvious;
    // given two types select the one on the left, or the right.
    // def left [L, R]: (L, R) => L
    // def right[L, R]: (L, R) => R

    val result = Await.result(graph1.run(), Duration(3, "seconds"))

    println(result)

    system.terminate()

    /**
      * Recap:
      * 1. Sources generate values.
      * 2. Sinks consume values.
      * 3. Materialization is the process of running the Stream, and getting your Sink to do something.
      * 4. Flows are linear transformations.
      * 5. Graphs can be modelled with Broadcast (and Merge, but we didn’t try them out).
      */
}
