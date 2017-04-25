package be.aca.scala.exercises.exersise3

import java.time.LocalDate


/**
  * Copyright (C) 25/04/2017 - REstore NV
  */
class BirtDayAlertTracker {
  private val nextBirthDays = Map(
    "kristof" -> LocalDate.of(2017, 7, 2),
    "Jan" -> LocalDate.of(2017, 5, 12),
    "Ronny" -> LocalDate.of(2017, 4, 30)
  )


  def getBirthDayAlert(person: String): Option[String] = {
    val birthDayDate: LocalDate = nextBirthDays(person)
    val now = LocalDate.now()

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
