package controllers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.ahc.AhcWSClient
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

object WSClientSample extends App {
  implicit val actorSystem = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val client = AhcWSClient()
  val wsResponse = client.url("http://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060").get()

  wsResponse.map { response =>
    println(response.body)
  }
  actorSystem.terminate()
  materializer.shutdown()
}
