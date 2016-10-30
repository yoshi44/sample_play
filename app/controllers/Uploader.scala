package controllers

import play.api._
import play.api.mvc._

class Uploader extends Controller {

  def index = Action {
    Ok(views.html.up("アップロード成功"))
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("file").map { file =>
      import java.io.File
      val filename = file.filename
      val contentType = file.contentType
      file.ref.moveTo(new File("/tmp", filename))
    Ok(views.html.up("アップロード成功"))
    }.getOrElse {
      Redirect(routes.Uploader.index).flashing(
        "error" -> "Missing file"
      )
    }
  }

}
