package be.aca.scala.session2.exercise2

import be.aca.scala.session2.exercises.domain.{Hobby, Person}
import be.aca.scala.session2.exercises.exercise1.PersonLookupService
import be.aca.scala.session2.exercises.exercise2.{Email, EmailService}
import org.mockito.Mockito
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class EmailServiceSpec extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfter {

    val personLookupService = mock[PersonLookupService]
    val from = "ronny@aca-it.be"
    val emailService = EmailService(personLookupService, from)
    val hobby = Hobby("fietsen")
    val kristof = Person("Kristof", "Vrolijkx", "k.vrolijkx@aca-it.be", Seq(hobby))

  before {
    Mockito.when(personLookupService.findPersonWithHobby(hobby.name)).thenReturn(Seq(kristof))
  }

  behavior of "sendMailToPeopleWithHobby"

  it should "return an email for every person" in {
    val body = "body"
    emailService.sendMailToPeopleWithHobby(hobby, body) should contain only Email(from, kristof.email, body)
  }

  it should "replace placeholders in body" in {
    val body = "body with ${firstName}"
    emailService.sendMailToPeopleWithHobby(hobby, body) should contain only Email(from, kristof.email, "body with " + kristof.firstName)
  }

}
