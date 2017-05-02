package be.aca.scala.session1.exercises.exersise2

/**
  * Copyright (C) 27/04/2017 - REstore NV
  */
object IsWholeNumber {

  def unapply(value: Double): Option[Int] = {
    Option(value).filter(_.isValidInt).map(_.toInt)
  }
}
