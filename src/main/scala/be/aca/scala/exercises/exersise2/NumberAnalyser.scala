package be.aca.scala.exercises.exersise2


object NumberAnalyser extends App {
  //TODO analyse the number from the first arg

  def analyseNumber(number: Double): String = {
    //TODO make the below code compile without altering it
//    number match {
//      case IsWholeNumber(wholeNumber) => analyseWholeNumber(wholeNumber)
//      case _ => analyseFloatingNumber(number)
//    }
    ???
  }

  private def analyseFloatingNumber(number: Double): String = {
    //TODO: tell how many fractional digits the number has
    ???
  }

  private def analyseWholeNumber(number: Int): String = {
//    TODO: make the below code compile
//    val by3 = DivisibleBy(2)
//    val by2 = DivisibleBy(3)
//
//    number match {
//      case by3(value) /* TODO: only positive */ => s"$number is a positive whole number divisible by 3"
//      case by2(value) /* TODO: only negative */ => s"$number is a negative whole number divisible by 2"
//      case /* positive */ => s"$number is a positive whole number"
//      case _ => s"$number is a negative whole number"
//    }
    ???
  }
}
