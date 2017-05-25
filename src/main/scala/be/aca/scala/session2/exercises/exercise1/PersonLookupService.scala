package be.aca.scala.session2.exercises.exercise1

import be.aca.scala.session2.exercises.domain.{Hobby, Person, PersonDataSource}

/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class PersonLookupService(val dataSource:PersonDataSource) {

  def findPersonByFirstName(name: String): Seq[Person] = {
    dataSource.allPersons.filter(_.firstName == name)
  }

  def findPersonByFirstAndLastName(first: String, last: String) = {
    dataSource.allPersons
        .filter(_.firstName == first)
        .filter(_.lastName == last)
  }

  def findPersonWithHobby(hobbyName: String) = {
    dataSource.allPersons.filter(_.hobbies.contains(Hobby(hobbyName)));
  }

  def findPersonWithAllHobbies(hobbies: Seq[Hobby]) = {
    dataSource.allPersons.filter(_.hobbies.filter(h => hobbies.contains(h)).sortBy(_.name) == hobbies.sortBy(_.name))
  }

  def findPersonWithAnyHoby(hobbies: Seq[Hobby]) = {
    dataSource.allPersons.filter(!_.hobbies.filter(h => hobbies.contains(h)).isEmpty)
  }

}
