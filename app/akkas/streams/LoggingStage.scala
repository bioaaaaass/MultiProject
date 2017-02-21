package akkas.streams

import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.stage._

/**
  * Created by huangzhibo on 09/02/2017.
  */
class LoggingStage[T] extends PushStage[T, T]{

    implicit val system = ActorSystem()

    private val log = Logging(system, "loggingName")

    override def onPush(elem: T, ctx: Context[T]): SyncDirective = {
        log.debug("Element flowing through: {}", elem)
        ctx.push(elem)
    }

    override def onUpstreamFailure(cause: Throwable, ctx: Context[T]): TerminationDirective = {
        log.error(cause, "Upstream failed.")
        super.onUpstreamFailure(cause, ctx)
    }

    override def onUpstreamFinish(ctx: Context[T]): TerminationDirective = {
        log.debug("Upstream finished")
        super.onUpstreamFinish(ctx)
    }
}
