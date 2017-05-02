package be.aca.scala.session1.demo

import org.scalatest.{FlatSpec, Matchers}


class PersonSpec extends FlatSpec with Matchers {
  import PersonSpec._

  "howAreYou" should """result in "I am happy" after 3 compliments""" in {
    val niels = new PredictablePerson("Niels")

    //Next tree ways of calling are the same
    niels.giveCompliment("Good job")
    niels giveCompliment("Well coded")
    niels giveCompliment "Well played"

    niels.howAreYou() shouldEqual "I am happy"
  }

  //Small exersise write some extra tests for the person class

}

object PersonSpec {

  private class PredictablePerson(name: String) extends Person(name) {

    override lazy val neededHappines: Int = 2

  }
}
