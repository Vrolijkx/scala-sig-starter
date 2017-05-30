package be.aca.scala.session3.exercises.domain

import java.time.LocalDate

case class Person(
    id: PersonId,
    firstName: String,
    lastName: String,
    birthDate: LocalDate,
    email: Option[String],
    partner: Option[PersonId]
)

case class PersonId(number: Long)
