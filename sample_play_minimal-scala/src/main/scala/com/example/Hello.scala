package com.example

import com.ning.http.client._
import play.api.Play.current
import play.api.libs.ws.ning._
import scala.concurrent.ExecutionContext.Implicits.global

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    //println(s"args(0)===${args(0)}")
    //println(s"args(1)===${args(1)}")

    val builder = new AsyncHttpClientConfig.Builder()
    val client = new NingWSClient(builder.build())
    val wsResponse = client.url("http://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060").get()

    wsResponse.map { response =>
      println(response.body)
    }

  }
}
