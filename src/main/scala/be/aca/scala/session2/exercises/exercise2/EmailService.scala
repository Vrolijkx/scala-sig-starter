package be.aca.scala.session2.exercises.exercise2

import be.aca.scala.session2.exercises.domain.{Hobby, Person}
import be.aca.scala.session2.exercises.exercise1.PersonLookupService


/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class EmailService(val personLookupService: PersonLookupService, val from:String) {

  def sendMailToPeopleWithHobby(hobby:Hobby, body:String): Seq[Email] = {
    personLookupService.findPersonWithHobby(hobby.name).map(p => Email(from, p.email, populateBody(p, body)))
  }

  private def populateBody(person:Person, body: String): String = {
    body.replaceAll("\\$\\{firstName\\}", person.firstName)
  }

}

object EmailService {
  def apply(personLookupService: PersonLookupService, from:String): EmailService = new EmailService(personLookupService, from)


}
