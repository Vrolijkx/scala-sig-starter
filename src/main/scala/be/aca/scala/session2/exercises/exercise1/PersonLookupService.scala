package be.aca.scala.session2.exercises.exercise1

import be.aca.scala.session2.exercises.domain.{Hobby, Person, PersonDataSource}

/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class PersonLookupService(val dataSource: PersonDataSource) {
  // imports implicit functions from the companion object
  import PersonLookupService._

  def findPersonByFuzzyName(pieceOfText: String) = {
    dataSource.allPersons.filter((p: Person) => p.firstName.fuzzyMatches(pieceOfText) ||
      p.lastName.fuzzyMatches(pieceOfText))
  }

  def findPersonByFirstName(name: String): Seq[Person] = {
    dataSource.allPersons.filter(_.firstName equalsIgnoreCase (name))
  }

  def findPersonByLastName(name: String): Seq[Person] = {
    dataSource.allPersons.filter(_.lastName.equalsIgnoreCase(name))
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

object PersonLookupService {

  implicit class StringWithFuzzySearch(content: String) {
    def fuzzyMatches(toMatch: String): Boolean = {
      content.toLowerCase() contains toMatch.toLowerCase()
    }
  }

}
