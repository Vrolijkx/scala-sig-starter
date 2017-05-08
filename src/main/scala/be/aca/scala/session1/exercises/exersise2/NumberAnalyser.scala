package be.aca.scala.session1.exercises.exersise2


object NumberAnalyser {

  def analyseNumber(number: Double): String = {
    number match {
      case WholeNumber(wholeNumber) => analyseWholeNumber(wholeNumber)
      case _ => analyseFloatingNumber(number)
    }
  }

  private def analyseFloatingNumber(number: Double): String = {
    val Array(whole, fractionalDigitWithDot) = number.toString.split("\\.")
    val amountOfDigits = fractionalDigitWithDot.stripMargin('.').length
    s"$number has $amountOfDigits fractional digits"

  }

  private def analyseWholeNumber(number: Int): String = {
    val by3 = DivisibleBy(3)
    val by2 = DivisibleBy(2)

    number match {
      case by3(value) if value >= 0 => s"$number is a positive whole number divisible by 3"
      case by2(value) if value <= 0 => s"$number is a negative whole number divisible by 2"
      case value if value <= 0 => s"$number is a positive whole number"
      case _ => s"$number is a negative whole number"
    }
  }
}