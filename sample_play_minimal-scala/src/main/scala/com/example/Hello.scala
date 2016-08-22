package com.example

// 2.4
//import com.ning.http.client._
//import play.api.Play.current
//import play.api.libs.ws.ning._
//import scala.concurrent.ExecutionContext.Implicits.global

// 2.5
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.ahc.AhcWSClient
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    //println(s"args(0)===${args(0)}")
    //println(s"args(1)===${args(1)}")

    // 2.4
    //val builder = new AsyncHttpClientConfig.Builder()
    //val client = new NingWSClient(builder.build())

    // 2.5
    implicit val actorSystem = ActorSystem()
    implicit val materializer = ActorMaterializer()

    val client = AhcWSClient()
    val wsResponse = client.url("http://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060").get()

    wsResponse.map { response =>
      println(response.body)
      client.close()
    }

  }
}
