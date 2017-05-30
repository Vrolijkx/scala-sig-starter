package be.aca.scala.session3.exercises.exercise2

import java.time.LocalDate

import be.aca.scala.session3.exercises.domain.{Person, PersonId}

import scala.concurrent.Future
import scala.io.Source
import scala.util.parsing.json.{JSON, JSONArray, JSONObject}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Copyright (C) 30/05/2017 - REstore NV
  */
class AsyncPersonDataSource {

  def fetchOtherPerson(id: PersonId): Future[Person] = Future {
    val source = Source.fromURL(s"https://randomuser.me/api?seed=${id.number}")

    val user = try source.getLines().mkString finally source.close()

    val person = for {
      JSONObject(root) <- JSON.parseRaw(user)
      JSONArray(results) <- root.get("results")
      JSONObject(person) <- results.headOption
      JSONObject(names) <- person.get("name")
      first <- names.get("first")
      last <- names.get("last")
      email <- person.get("email")
      birthDate <- person.get("dob")
    } yield {
      val parseBirthDate = LocalDate.parse(birthDate.toString.split(" ")(0))
      Person(id, first.toString, last.toString, parseBirthDate, Some(email.toString), None)
    }

    person.get
  }

}
