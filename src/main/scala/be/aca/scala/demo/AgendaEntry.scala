package be.aca.scala.demo

import java.time.LocalDateTime

case class AgendaEntry(
  title: String,
  description: String,
  date: LocalDateTime = LocalDateTime.now()
)

object AgendaEntry {

  val sigDate = LocalDateTime.of(2017, 4, 19, 17, 30)
  val entry = AgendaEntry("Scala SIG", "learning an awesome language", sigDate)
  val otherEntry = AgendaEntry(
    title = "Scala SIG",
    description = "learning an awesome language"
  )
  val rescheduled = entry.copy(date = sigDate plusMinutes 30)
  val entryDate = entry.date

  println(entry)

}
