package be.aca.scala.session1.demo

import java.time.LocalDate

trait BirthDay {
  def birthDay: LocalDate

  def age: Int = {
    birthDay.until(now).getYears
  }

  def nextBirthDay: LocalDate = {
    if(birthDay.getDayOfYear > now.getDayOfYear) {
      birthDay.withYear(now.getYear)
    } else {
      birthDay.withYear(now.getYear + 1)
    }
  }

  protected def now: LocalDate = LocalDate.now()
}

trait HappinessTracking {
  var happiness: Int = 0

  protected def neededHappiness: Int

  def giveCompliment(compliment: String): Unit = {
    println(s"Thanks for telling $compliment")
    happiness += 1
  }

  def saySomethingUgly(): Unit = happiness -= 1

  def howAreYou(): String = {
    happiness match {
      case happy if happy > neededHappiness => "I am happy"
      case ok if ok == neededHappiness => "I am ok"
      case bad if bad < neededHappiness => "I am not very well"
    }
  }

}

class Person2 extends HappinessTracking with BirthDay {

  override def neededHappiness: Int = 5

  override def birthDay: LocalDate = LocalDate.of(1993, 2, 7)
}
