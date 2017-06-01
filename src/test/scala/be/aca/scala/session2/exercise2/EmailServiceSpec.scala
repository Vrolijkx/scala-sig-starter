package be.aca.scala.session2.exercise2

import be.aca.scala.session2.exercises.domain.{Hobby, Person}
import be.aca.scala.session2.exercises.exercise1.PersonLookupService
import be.aca.scala.session2.exercises.exercise2.{Email, EmailService}
import org.mockito.Mockito
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

class EmailServiceSpec extends FlatSpec with Matchers with MockitoSugar {

  import EmailServiceSpec._

  behavior of "sendMailToPeopleWithHobby"

  it should "return an email for every person" in new TestFixture {
    val body = "body"
    emailService.sendMailToPeopleWithHobby(hobby, body) should contain only Email(from, kristof.email, body)
  }

  it should "return an email for every fuzzy person" in new TestFixture {
    val body = "body"
    emailService.sendMailToPeopleWithFuzzyName("ToF", body) should contain only Email(from, kristof.email, body)
  }

  it should "replace placeholders in body" in new TestFixture {
    val body = "body with ${firstName} ${lastName} ${hobby}"
    emailService.sendMailToPeopleWithHobby(hobby, body) should contain only Email(from, kristof.email,
      s"body with ${kristof.firstName} ${kristof.lastName} ${hobby.name}")
  }
}

object EmailServiceSpec extends MockitoSugar {

  class TestFixture {
    val personLookupService = mock[PersonLookupService]
    val from = "ronny@aca-it.be"
    val emailService = EmailService(personLookupService, from)
    val hobby = Hobby("fietsen")
    val kristof = Person("Kristof", "Vrolijkx", "k.vrolijkx@aca-it.be", Seq(hobby))

    Mockito.when(personLookupService.findPersonWithHobby(hobby.name)).thenReturn(Seq(kristof))
    Mockito.when(personLookupService.findPersonByFuzzyName("ToF")).thenReturn(Seq(kristof))
  }

}


