package be.aca.scala.session2.exercises.exercise2

import be.aca.scala.session2.exercises.domain.{Hobby, Person}
import be.aca.scala.session2.exercises.exercise1.PersonLookupService


/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class EmailService(val personLookupService: PersonLookupService, val from: String) {

  def sendMailToPeopleWithHobby(hobby: Hobby, body: String): Seq[Email] = {
    personLookupService.findPersonWithHobby(hobby.name).map(p => Email(from, p.email, populateBody(p, body, hobby.name)))
  }

  def sendMailToPeopleWithLastName(lastName: String, body: String): Seq[Email] = {
    personLookupService.findPersonByLastName(lastName).map(p => Email(from, p.email, populateBody(p, body, "")))
  }

  def sendMailToPeopleWithFirstName(firstName: String, body: String): Seq[Email] = {
    personLookupService.findPersonByFirstName(firstName).map(p => Email(from, p.email, populateBody(p, body, "")))
  }

  def sendMailToPeopleWithFuzzyName(pieceOfText: String, body: String): Seq[Email] = {
    personLookupService.findPersonByFuzzyName(pieceOfText).map(p => Email(from, p.email, populateBody(p, body, "")))
  }

  private def populateBody(person: Person, body: String, hobby: String): String = {
    body.replaceAll("\\$\\{firstName\\}", person.firstName)
      .replaceAll("\\$\\{lastName\\}", person.lastName)
      .replaceAll("\\$\\{hobby\\}", hobby)
  }
}

object EmailService {
  def apply(personLookupService: PersonLookupService, from: String): EmailService = new EmailService(personLookupService, from)


}
