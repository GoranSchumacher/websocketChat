package controllers

import play.api.mvc.{Action, Controller}

/**
 * @author Gøran Schumacher (GS) / Schumacher Consulting Aps
 * @version $Revision$ 17/03/2016
 */
class ChatController extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def openChat(name : String) = Action { implicit request =>
    Ok(views.html.chat(name))
  }

}
