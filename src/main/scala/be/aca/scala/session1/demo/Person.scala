package be.aca.scala.session1.demo


import scala.util.Random


class Person(val name: String) {
  var happiness: Int = 0

  lazy val neededHappines: Int = {
    Random.nextInt(10)
  }

  def giveCompliment(compliment: String): Unit = {
    println(s"Thanks for telling $compliment")
    happiness += 1
  }

  def saySomethingUgly(): Unit = happiness -= 1

  def howAreYou(): String = {
    happiness match {
      case happy if happy > neededHappines => "I am happy"
      case ok if ok == neededHappines => "I am ok"
      case bad if bad < neededHappines => "I am not very well"
    }
  }

}

