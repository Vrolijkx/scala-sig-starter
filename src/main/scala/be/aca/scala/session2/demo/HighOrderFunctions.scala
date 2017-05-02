package be.aca.scala.session2.demo

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

}
