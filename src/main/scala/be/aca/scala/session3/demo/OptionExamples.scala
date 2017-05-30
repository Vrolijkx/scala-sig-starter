package be.aca.scala.session3.demo

/**
  * Copyright (C) 23/05/2017 - REstore NV
  */
object OptionExamples {

  private def getOptionalOddMillis: Option[Long] = {
    if(System.currentTimeMillis() % 2 != 0) {
      Some(System.currentTimeMillis())
    } else None
  }

  private def getOptionalEvenMillis: Option[Long] = {
    if(System.currentTimeMillis() % 2 == 0) {
      Some(System.currentTimeMillis())
    } else None
  }

  def fallingBackToDefaults(): Unit = {
    val optionalMillis: Option[Long] = getOptionalOddMillis

    val fallingBackOnValue: Long = optionalMillis.getOrElse(0)

    val fallingBackOnOtherOption: Option[Long] = optionalMillis.orElse(getOptionalEvenMillis)

    //Only do this when communicating with java code
    val fallingBackToNull: String = optionalMillis.map(_.toString).orNull

  }

  def fromNullables(): Unit = {
    val someValue: String = null
    val otherValue: String = "34"

    Option(someValue) == None
    Option(otherValue) == Some(otherValue)

  }

  def mapFlatMapFilterExample(): Unit = {
    val optionalMillis: Option[Long] = getOptionalOddMillis

    val optionalDuration: Option[String] = optionalMillis.filter(_ % 3 == 0).map(millis => s"$millis ms")

  }


}
