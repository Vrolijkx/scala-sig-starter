package be.aca.scala.session1.demo

import org.scalatest.{FlatSpec, Matchers}

class TupleSpec extends FlatSpec with Matchers {

  "tuples" should "be possibe to create with syntax suggar" in {

    val tupleOf2: Tuple2[String, Int] = ("hopla", 5)
    val tupleOf3: Tuple3[List[_], Double, Int] = (List(), 60.8, 8)

  }

  it should "be possible write the type with syntax suggar" in {

    val tupleOf2: (String, Int) = ("hopla", 5)
    val tupleOf3: (List[_], Double, Int) = (List(), 60.8, 8)

  }

  it should "be possible to use tupples with patternMatching" in {

    ("vis", 4, 8) match {
      case ("hond", _, _) => fail("should not match")
      case ("vis", value1, _) if value1 > 5 => fail("should not match")
      case ("vis", _, _) => println("we have a match")
    }



  }



}
