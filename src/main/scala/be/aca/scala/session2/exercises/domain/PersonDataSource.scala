package be.aca.scala.session2.exercises.domain

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

  private val hobbies: Seq[Hobby] = Seq(
    "tennis", "badminton", "squash", "bowling", "pool", "swimming"
  ).map(Hobby.apply)


  val allPersons = {
    val infiniteHobbiesStream = Iterator.continually(hobbies).flatten

    for {
      (firstName, index1) <- firstNames.zipWithIndex
      (lastName, index2) <- lastNames.zipWithIndex
    } yield {
      val amountOfHobbies = (index1 + index2) % 3
      val hobbies = infiniteHobbiesStream.take(amountOfHobbies).toSeq
      Person(firstName, lastName, s"$firstName.$lastName@gmail.com", hobbies)
    }
  }


}
