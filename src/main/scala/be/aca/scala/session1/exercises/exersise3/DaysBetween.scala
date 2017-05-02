package be.aca.scala.session1.exercises.exersise3

import java.time.{LocalDate, Period}

/**
  * Copyright (C) 01/05/2017 - REstore NV
  */
case class DaysBetween(start: LocalDate) {

  def and(end: LocalDate): Int = {
    Period.between(start, end).getDays
  }

}
