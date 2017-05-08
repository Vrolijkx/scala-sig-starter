package be.aca.scala.session2.exercises.exercise1

import be.aca.scala.session2.exercises.domain.{Hobby, Person}

/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class PersonLookupService {

  def findPersonByFirstName(name: String): Seq[Person] = ???

  def findPersonByFirstAndLastName(first: String, last: String) = ???

  def findPersonWithHobby(hobbyName: String) = ???

  def findPersonWithAllHobbies(hobbies: Seq[Hobby]) = ???

  def findPersonWithAnyHoby(hobbies: Seq[Hobby]) = ???

}
