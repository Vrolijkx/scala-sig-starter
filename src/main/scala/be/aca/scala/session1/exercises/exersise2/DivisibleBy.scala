package be.aca.scala.session1.exercises.exersise2

/**
  * Copyright (C) 01/05/2017 - REstore NV
  */
case class DivisibleBy(denominator: Int) {

  def unapply(nominator: Int): Option[Int] = {
    if(nominator % denominator == 0) {
      Some(nominator)
    } else {
      None
    }
  }

}
