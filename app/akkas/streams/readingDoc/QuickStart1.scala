package akkas.streams.readingDoc

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}

/**
  * Created by huangzhibo on 10/02/2017.
  */
final case class Author(handle: String)

final case class Hashtag(name: String)

final case class Tweet(author: Author, timestamp: Long, body: String) {
    def hashtags: Set[Hashtag] =
        body.split(" ").collect { case t if t.startsWith("#") => Hashtag(t) }.toSet
}

object QuickStart1 extends App {

    val akkaTag = Hashtag("#akka")

    implicit val system = ActorSystem("reactive-tweets")
    implicit val materializer = ActorMaterializer()

    val tweets: Source[Tweet, NotUsed] = Source.single(Tweet(Author("lala"), 1000L, "#akka"))
    val authors: Source[Author, NotUsed] =
        tweets
        .filter(_.hashtags.contains(akkaTag))
        .map(_.author)

    authors.runWith(Sink.foreach(println))
    // equals authors.runForeach(println)
    system.terminate()
}
