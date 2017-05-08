package be.aca.scala.session2.demo

/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
object ImplicitArguments extends App {
  case class Session(sessionId: String, oathenticated: Boolean = false)

  //This function takes an implicit parameter wich is looked up
  //In the implicit scope of the CALLER by type.
  def isAuthenticated(implicit session: Session): Boolean = {
    session.oathenticated
  }

  //put session into implicit scope
  implicit val session: Session = Session("some session Id")

  //session doesn't need to be passed because it is in implicit scope.
  isAuthenticated


}
