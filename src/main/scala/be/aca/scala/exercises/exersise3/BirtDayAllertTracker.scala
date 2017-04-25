package be.aca.scala.exercises.exersise3

import java.time.LocalDate


/**
  * Copyright (C) 25/04/2017 - REstore NV
  */
class BirtDayAllertTracker {
  private val nextBirthDays = Map(
    "kristof" -> new LocalDate(2017, 7, 2),
    "Niels" -> new LocalDate(), //TODO fill in dates
    "Bram" -> new LocalDate()
  )


  def getBirthDayAlert(person: String): Option[String] = {
    val birthDayDate: LocalDate = nextBirthDays(person)
    val now = new LocalDate()

//    TODO: make the below code compile
//    val amoutOfDays = DaysBetween(now) and birthDayDate
//
//    if(amountOfDays < 5) {
//      Some(s"Hurry you have only $amountOfDays to get a present".)
//    } else if(amoutOfDays < 20) {
//      Banner("Maybe it's time to start looking for a gift for your girlfiend.")
//    } else {
//      None
//    }
    ???
  }

}
