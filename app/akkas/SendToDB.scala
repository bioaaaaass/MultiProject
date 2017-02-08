package akkas

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ClosedShape}
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Keep, RunnableGraph, Sink, Source}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by huangzhibo on 08/02/2017.
  */
object SendToDB extends App {
    /**
      * Source --> Broadcast --> Flow --> Sink
      *                |
      *                --> Save to DB
      */
    implicit val system = ActorSystem()
    implicit val ec = system.dispatcher
    implicit val materializer = ActorMaterializer()

    val intSource: Source[Int, NotUsed] = Source(1 to 100)

    val helloTimesTen: Flow[Int, String, NotUsed] = Flow[Int].map(i => s"Hello ${i * 10}")
    val intToEvent: Flow[Int, DB.Event, NotUsed] = Flow[Int].map(i => DB.Event(s"Event $i"))

    val printlnSink: Sink[Any, Future[Done]] = Sink.foreach(println)
    val dbSink = Flow[DB.Event].map(DB.persistEvent).toMat(Sink.ignore)(Keep.right).named("dbSink")
    val graph = RunnableGraph.fromGraph(GraphDSL.create(){ implicit builder: GraphDSL.Builder[NotUsed] =>
        import GraphDSL.Implicits._
        val broadcast = builder.add(Broadcast[Int](2))

        intSource ~> broadcast ~> helloTimesTen ~> printlnSink
                     broadcast ~> intToEvent ~> dbSink
        ClosedShape
    })
    // ~> means “Add Edge to Graph”
    // The Broadcast class also checks at compile time that we’ve linked all the specified ‘ports’.
    // we create the Broadcast and say it will have two things listening to it.
    // If we only connect, one, we get a runtime error.
    graph.run()

    system.terminate()
}

object DB {
    case class Event(msg: String)
    def persistEvent(e: Event)(implicit ec: ExecutionContext): Future[Unit] = {
        // pretend that some DB IO happens here
        println(s"persisting $e")
        Future{}
    }
}
// dig into http://cjwebb.github.io/blog/2016/06/28/learning-akka-streams/?utm_source=tuicool&utm_medium=referral
