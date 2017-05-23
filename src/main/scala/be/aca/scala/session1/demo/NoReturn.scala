package be.aca.scala.session1.demo

/**
  * Copyright (C) 23/04/2017 - REstore NV
  */
object NoReturn {

  case class Person(name: String, country: String)

  def getMailUrl(person: Person): String = {
    //We can assign the result of an if to a variable
    val fromBelgium = if(person.country == "BE") { //BAD example
      true
    } else {
      false
    }

    //There is no ternairy if in scala use the below instead
    val url = if (fromBelgium) "www.gmail.be" else "www.gmail.com"

    //The result of this function is the result of the last statement
    url
  }

}
