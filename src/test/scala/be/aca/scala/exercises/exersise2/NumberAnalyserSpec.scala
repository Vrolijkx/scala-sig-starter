package be.aca.scala.exercises.exersise2

import org.scalatest.{FlatSpec, Matchers}


class NumberAnalyserSpec extends FlatSpec with Matchers {
  import NumberAnalyser._


  "analyseNumber" should "analyse a positive whole number divisible by 3" in {
    val analisses = analyseNumber(30)

    analisses shouldBe "30 is a positive whole number divisible by 3"
  }

  it should "analyse a negative whole number divisible by 2" in {
    val analisses = analyseNumber(4)

    analisses shouldBe "4 is a negative whole number divisible by 2"
  }

  // TODO write spec for floating numbers and implement the logic described in the comments

}
