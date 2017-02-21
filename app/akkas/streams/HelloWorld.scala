package akkas.streams

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

/**
  * Created by huangzhibo on 08/02/2017.
  */
object HelloWorld extends App {

    implicit val system = ActorSystem() // TODO: why need ActorSystem ?  and implicit ?

    implicit val materializer: ActorMaterializer = ActorMaterializer() // TODO: why need ActorMaterializer ? implicit ?

    /**
      * The Materializer is a factory for stream execution engines, it is the thing that makes streams run.
      */
    val source: Source[Int, NotUsed] = Source(1 to 100) // TODO: what is Source really role ?
    /**
      * the Source is just a description of what you want to run.
      */

    source.runForeach(println)

    system.terminate()

    /**
      * The purpose is to offer an intuitive and safe way to formulate stream processing setups such that
      * we can then execute them efficiently and with bounded resource usage—no more OutOfMemoryErrors.
      * In order to achieve this our streams need to be able to limit the buffering that they employ,
      * they need to be able to slow down producers if the consumers cannot keep up. This feature is called back-pressure
      */
}
