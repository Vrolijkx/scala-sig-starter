package be.aca.scala.session3.exercises.domain

import java.time.LocalDate

/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
class PersonDataSource {
  private val firstNames: Seq[String] = Seq(
    "Marcelina", "Beulah", "Juliana", "Jude", "Heike", "Reanna", "Crista", "Sandee", "Iola", "Jaime", "Lizeth",
    "Evangeline", "Johnna", "Laverne", "Jazmin", "Berenice", "Melaine", "Elizabeth", "Sterling", "Noriko", "Otha",
    "Elfriede", "Rigoberto", "Soledad", "Juan", "Antonette", "Hermine", "Andria", "Fernanda", "Miles", "Dino", "Kathie",
    "Lashanda", "Narcisa", "Glady", "Carleen", "Zack", "Willis", "Carl", "Mandy", "Nelle", "Joya", "Lu", "Ardell",
    "Charline", "Laura", "Alisia", "Mattie", "Nery"
  )

  private val lastNames: Seq[String] = Seq(
    "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"
  )

  val allPersons: Seq[Person] = {
    val start = LocalDate.ofYearDay(1970, 1)

    val withoutParnter = for {
      (firstName, index1) <- firstNames.zipWithIndex
      (lastName, index2) <- lastNames.zipWithIndex
    } yield {
      val id = PersonId(index1 * 999 + index2)
      val birthDay = start.plusDays(index1 * 100 + index2 * 100)
      val email = if(index1 + index2 % 15 == 0) None else Some(s"$firstName.$lastName@gmail.com")

      Person(id, firstName, lastName, birthDay, email, None)
    }

    val personsWithAPartnerSeq = for {
      (Seq(person, partner), index) <- withoutParnter.grouped(2).zipWithIndex if index > 40 && index < 90
      witPartner <- Seq(
        person.copy(partner = Some(partner.id)),
        partner.copy(partner = Some(person.id))
      )
    } yield (witPartner.id, witPartner)

    val personsWithAPartner: Map[PersonId, Person] = personsWithAPartnerSeq.toMap

    withoutParnter.map(p => {
      personsWithAPartner.getOrElse(p.id, p)
    })
  }
}
