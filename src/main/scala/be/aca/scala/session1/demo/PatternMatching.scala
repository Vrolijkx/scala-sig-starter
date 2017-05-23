package be.aca.scala.session1.demo

object PatternMatching {

  sealed trait Animal
  case class Dog(name: String, species: String) extends Animal
  case class Cat(name: String) extends Animal

  def isBobtail(animal: Animal): Boolean = {
    animal match {
      case Dog(name, "bobtail") => println(s"$name is a bobtail"); true
      case _ => println(s"$animal is not a bobtail"); false
    }
  }

  def rateLanguage(language: String): String = {
    language match {
      case "java" => "nice language"
      case "scala" => "awesome language"
      case "javascript" => "don't really like scripting languages"
      case "typescript" => "Better as javascript"
    }
  }


  def printContentOfNone(option: Option[String]): Unit = {
    option match {
      case Some(value) => println(value)
      case None => println("no value present")
    }
  }

}
