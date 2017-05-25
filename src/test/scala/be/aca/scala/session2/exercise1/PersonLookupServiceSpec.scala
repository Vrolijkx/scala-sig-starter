package be.aca.scala.session2.exercise1

import be.aca.scala.session2.exercises.domain.{Hobby, PersonDataSource}
import be.aca.scala.session2.exercises.exercise1.PersonLookupService
import org.scalatest.{FlatSpec, Matchers}

class PersonLookupServiceSpec extends FlatSpec with Matchers {

  val personLookupService = new PersonLookupService(new PersonDataSource())

  behavior of "A PersonLookupService"

  it can "filter persons on firstname" in {
    val persons = personLookupService.findPersonByFirstName("Marcelina")

    persons should have length 10
    persons.map(_.firstName) should contain only "Marcelina"
  }

  it can "filter persons on firstname and lastname" in {
    val persons = personLookupService.findPersonByFirstAndLastName("Marcelina", "Smith")

    persons should have length 1
    val names = persons.map(p => Tuple2(p.firstName, p.lastName))
    names should contain only Tuple2("Marcelina", "Smith")
  }

  it can "filter persons on hobby" in {
    val persons = personLookupService.findPersonWithHobby("tennis")

    persons.map(_.hobbies).foreach(_ should contain (new Hobby("tennis")))
  }

  it can "find persons with a collection of hobbies" in {
    val expectedHobbies = List(Hobby("tennis"), Hobby("swimming"))
    val persons = personLookupService.findPersonWithAllHobbies(expectedHobbies)

    persons.map(_.hobbies).foreach(_ should contain allOf(expectedHobbies.head, expectedHobbies.tail.head, expectedHobbies.tail.tail))
  }

  it can "find persons with at least one hobby out of a collection of hobbies" in {
    val expectedHobbies = List(Hobby("tennis"), Hobby("swimming"))
    val persons = personLookupService.findPersonWithAnyHoby(expectedHobbies)

    persons.map(_.hobbies).foreach(_ should contain atLeastOneOf (expectedHobbies.head, expectedHobbies.tail.head, expectedHobbies.tail.tail))
  }

}
