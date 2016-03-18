package controllers

import forms.User
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import javax.inject.Inject
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi

/**
 * @author Gøran Schumacher (GS) / Schumacher Consulting Aps
 * @version $Revision$ 17/03/2016
 */
class ChatController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  val userForm = Form(
    mapping(
      "name" -> text
    )(User.apply)(User.unapply)
  )

  def index = Action {
    Ok(views.html.index(userForm))
  }

  val userPost = Action(parse.form(userForm)) { implicit request =>
    val userData = request.body
    val newUser = User(userData.name)
    Redirect(routes.ChatController.openChat(newUser.name))
  }

  def openChat(name : String) = Action { implicit request =>
    Ok(views.html.chat(name))
  }

}
