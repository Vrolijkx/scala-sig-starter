package be.aca.scala.session2.demo

import scala.annotation.tailrec
import scala.util.Random

/**
  * Copyright (C) 07/05/2017 - REstore NV
  */
object OtherOpperations extends App {
  case class Person(name: String, age: Int = Random.nextInt(40))
  val people = (1 to 200).map(i => Person(s"person $i"))

  groupByExample(people)
  enrichCollection(people)
  destructureCollection(people)

  def groupByExample(people: Seq[Person]): Unit = {
    val groupedByAge: Map[Int, Seq[Person]] = people.groupBy(_.age)
  }

  def enrichCollection(people: Seq[Person]): Unit = {
    val kristof = Person("Kristof", 23)
    val bram = Person("Bram", 33)

    val withKristofAppended = people :+ kristof
    println(s"with Kristof: $withKristofAppended")

    //an example of right associative function
    val withBramPrepended = bram +: people
    println(s"with Bram in front: $withBramPrepended")

    val withBoth = people ++ Seq(bram, kristof)

    var hoera = people

    hoera :+= bram

    // side note
    // for the List type there are also the :: :::
    // but I try to avoid those.
  }


  def destructureCollection(people: Seq[Person]): Unit = {

    val Seq(_, second, third, _*) = people

    val other :+ last = people

    val head +: other2 = people

    println(
      s"""head: $head
         |last: $last
         |second: $second
         |third: $third
         |other: $other
      """.stripMargin
    )
  }


  def useFullMethods(people: Seq[Person]): Unit = {

    val firstPerson: Person = people.head

    //If we don't want to crach on a empty list
    val maybeFirstPerson: Option[Person] = people.headOption


    val lastPerson: Person = people.last

    //If we don't want to crach on a empty list
    val maybeLastPerson: Option[Person] = people.lastOption

    val everyPersonButTheFirst: Seq[Person] = people.tail

    val first3Persons: Seq[Person] = people.take(3)

    val last3Persons: Seq[Person] = people.takeRight(3)

    //many more not include here
  }



}
