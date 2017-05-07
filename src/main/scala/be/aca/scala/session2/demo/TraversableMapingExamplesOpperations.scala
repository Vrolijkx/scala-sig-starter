package be.aca.scala.session2.demo

import scala.math._

/**
  * Copyright (C) 02/05/2017 - REstore NV
  */
§object TraversableMapingExamplesOpperations extends App {
  //first show collection hierarchy
  val data: Traversable[Int] = 1 to 50
  mapExample(data)
  flatMapExample(data)


  def mapExample(data: Traversable[Int]): Unit = {
    val tenFolds = data.map(number => number * 10)
    val sevenFolds = data.map(_ * 7)

    println(sevenFolds)
  }

  def flatMapExample(data: Traversable[Int]): Unit = {
    val treeTimesTheSame = data.flatMap(number => List(number, number, number))

    println(treeTimesTheSame)

    //map + flatten for same result
    val twoTimesTheSampe = data.map(number => List(number, number)).flatten

    println(twoTimesTheSampe)
  }


  def forComprehensionExample(data: Traversable[Int]): Unit = {
    val treeTimesTheSame = for {
      number <- data
      nestedNumber <- List(number, number, number)
    } yield {
      nestedNumber * 3
    }

    println(treeTimesTheSame)
  }

}
