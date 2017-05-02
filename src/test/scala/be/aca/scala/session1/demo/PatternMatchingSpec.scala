package be.aca.scala.session1.demo

import org.scalatest.{FlatSpec, Matchers}

/**
  * Copyright (C) 18/04/2017 - REstore NV
  *
  */
class PatternMatchingSpec extends FlatSpec with Matchers {
  import PatternMatching._

  "isBobtail" should "return true for dog with bobtail as species" in {
    val samson = Dog("Samson", "bobtail")
    isBobtail(samson) shouldBe true
  }

  it should "return false for other dog species" in {
    val lassy = Dog("Lassy", "bordercolly")
    isBobtail(lassy) shouldBe false
  }

  it should "return false for cats species" in {
    val wiskers = Cat("Wiskers")
    isBobtail(wiskers) shouldBe false
  }

  "rateLanguage" should """return "don't really like scripting languages" for javascript""" in {
    rateLanguage("javascript") shouldEqual "don't really like scripting languages"
  }

  it should "result in MatchError for unkown language GO" in {
    intercept[MatchError] {
      rateLanguage("GO")
    }
  }

}
