package be.aca.scala.demo

import org.scalatest.{FlatSpec, Matchers}


class ApplyUnApplySpec extends FlatSpec with Matchers {

  "Calling apply on Conpanion object" should "create correct instance with both params" in {
    // both below are actualy the same
    // ApplyUnApply.apply("param1", "param2")
    val applyUnApply = ApplyUnApply("param1", "param2")

    applyUnApply.param1 shouldBe "param1"
    applyUnApply.param2 shouldBe "param2"
  }

  it should "create correct instance with single param" in {
    val applyUnApply = ApplyUnApply("param")

    applyUnApply.param1 shouldBe "param"
    applyUnApply.param2 shouldBe "param"
  }

  "Calling apply on instance" should "return a correct string" in {
    val applyUnApply = new ApplyUnApply("param1", "param2")

    applyUnApply() shouldBe "apply param1, param2"
    applyUnApply.param2 shouldBe "param2"
  }

  "unnaply" should "make it possible to destructure an instance" in {
    val toDesctructure = new ApplyUnApply("param1", "param2")

    val ApplyUnApply(param1, param2) = toDesctructure

    param1 shouldBe "param1"
    param2 shouldBe "param2"
  }

  it should "make it possible to use it with pattern matching" in {
    val toMatch = new ApplyUnApply("param1", "param2")

    val result = toMatch match {
      case ApplyUnApply(param1, param2) => s"$param1, $param2"
    }

    result shouldBe "param1, param2"
  }

}
