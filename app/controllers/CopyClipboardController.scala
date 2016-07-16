package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class CopyClipboardController @Inject() extends Controller {

  def index = Action {
    Ok(views.html.copyclipboard("Copy Clipboard Controller!!"))
  }

}
