package be.aca.scala.session1.exercises.exersise2

import org.scalatest.{FlatSpec, Matchers}


class NumberAnalyserSpec extends FlatSpec with Matchers {
  import NumberAnalyser._

  "analyseNumber" should "analyse a positive whole number divisible by 3" in {
    val output = analyseNumber(30)

    output shouldBe "30 is a positive whole number divisible by 3"

  }

  it should "analyse a negative whole number divisible by 2" in {
    val output = analyseNumber(-8)

    output shouldBe "-8 is a negative whole number divisible by 2"
  }

  it should "analyse a positive whole number not divisible by 2" in {
    val output = analyseNumber(7)

    output shouldBe "7 is a positive whole number"
  }

  it should "analyse a negative whole number not devisible by 2" in {
    val output = analyseNumber(-9)

    output shouldBe "-9 is a negative whole number"
  }


  it should "analyse floatining numbers correctly" in {
    val output = analyseNumber(4.0453)

    output shouldBe "4.0453 has 4 fractional digits"
  }


}
