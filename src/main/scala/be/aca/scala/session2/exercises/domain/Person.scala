package be.aca.scala.session2.exercises.domain

case class Person(
  firstName: String,
  lastName: String,
  email: String,
  hobbies: Seq[Hobby] = Seq()
)
