package be.aca.scala.session2.demo

import java.text.DateFormat
import java.time.LocalDate

object HighOrderFunctions {

  def sum[T](data: Seq[T], converter: T => Double): Double = { //converter is called an HighOrderFunction
    data.map(item => converter(item)).sum
  }

  def printNext7Days(formatter: (LocalDate, DateFormat) => String): Unit = {
    val start = LocalDate.now()

    for(d <- 1 to 7) {
      val date = start.plusDays(d)
      println(formatter(date, DateFormat.SHORT))
    }
  }


  def printNext7DaysDesugared(formatter: Function2[LocalDate, DateFormat, String]): Unit = {
    val start = LocalDate.now()

    for(d <- 1 to 7) {
      val date = start.plusDays(d)
      println(formatter(date, DateFormat.SHORT))
    }
  }


  def ussageExample(): Unit = {
    printNext7Days(format) //just pas an existing method
    printNext7Days((date, format) => "some other format") //inline

    printNext7Days((date: LocalDate, format: DateFormat) => { //expanded version
      "some other format"
    })

    sum[String](Seq("1", "2", "3"), _.toDouble) //using underscore syntax suggar
  }

  def format(d1: LocalDate, d2: DateFormat): String = ???

}
