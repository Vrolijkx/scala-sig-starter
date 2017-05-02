package be.aca.scala.session2.demo

import scala.math._

/**
  * Copyright (C) 02/05/2017 - REstore NV
  */
object TraversableOpperations extends App {
  //first show collection hierarchy
  val data: Traversable[Int] = 1 to 50
  mapExample(data)
  flatMapExample(data)
  foldExample(data)


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


  //jump into thunks(multiple parameter lists
  def foldExample(data: Traversable[Int]): Unit = {

    //from lef => right
    val sumOfSqrt1 = data.foldLeft(0.0)((original, item) => original + sqrt(item))

    //from right => left
    val sumOfSqrt2 = data.foldRight(0.0)((original, item) => original + sqrt(item))

    //you have no control
    val sumOfSqrt3 = data.fold(0.0)((original, item) => original + sqrt(item))

    println(s"sum of sqrRoots: $sumOfSqrt1, $sumOfSqrt2, $sumOfSqrt3")
  }



}
