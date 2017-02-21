package akkas.streams.readingDoc

import java.nio.file.Paths

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, IOResult, ThrottleMode}
import akka.stream.scaladsl.{FileIO, Flow, Keep, Sink, Source}
import akka.util.ByteString

import scala.concurrent.Future
import scala.concurrent.duration._
/**
  * Created by huangzhibo on 10/02/2017.
  */
object QuickStart extends App{

    val source: Source[Int, NotUsed] = Source(1 to 100)

    implicit val system = ActorSystem("QuickStart")
    implicit val materializer = ActorMaterializer()

    // another way to create a materializer, e.g. from an ActorContext when using streams from within Actors.

    val factorials = source.scan(BigInt(1))((acc, next) => acc * next)  // starting with the number 1

    val result: Future[IOResult] =
        factorials
        .map(num => ByteString(s"$num\n"))
        .runWith(FileIO.toPath(Paths.get("factorials.txt")))

    def lineSink(fileName: String): Sink[String, Future[IOResult]] =
        Flow[String]
        .map(s => ByteString(s + "\n"))
        .toMat(FileIO.toPath(Paths.get(fileName)))(Keep.right)

    factorials.map(_.toString).runWith(lineSink("factorials2.txt"))

    val done: Future[Done] =
        factorials
        .zipWith(Source(0 to 100))((num, idx) => s"$idx! = $num")
        .throttle(1, 1.second, 1, ThrottleMode.shaping)
        .runForeach(println)

    /**
      * why use throttle combinator ?
      * The next line demonstrates that we are in fact dealing with streams that can flow at a certain speed:
      * we use the throttle combinator to slow down the stream to 1 element per second (
      * the second 1 in the argument list is the maximum size of a burst that we want to allow—passing 1 means that
      * the first element gets through immediately and the second then has to wait for one second and so on).
      */

    import scala.concurrent.ExecutionContext.Implicits.global
    done.map{
        _ =>
            system.terminate()
    }

    // "What if the subscriber is too slow to consume the live stream of data?".
    // see QuickStart1.scala
    //system.terminate()
}
