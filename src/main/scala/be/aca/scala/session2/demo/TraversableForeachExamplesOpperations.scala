package be.aca.scala.session2.demo

import scala.math._

/**
  * Copyright (C) 02/05/2017 - REstore NV
  */
object TraversableForeachExamplesOpperations extends App {
  //first show collection hierarchy
  val data: Traversable[Int] = 1 to 20
  foreachExample(data)
  nestedForeachExample(data)
  forComprehensionExample(data)
  usage()


  def foreachExample(data: Traversable[Int]): Unit = {
    data.foreach(number => {
      val sevenFold = number * 5
      print(sevenFold + " ")
    })

    data.foreach(println(_))
  }

  def nestedForeachExample(data: Traversable[Int]): Unit = {
    data.foreach(outerNumber => {
      data.foreach(innerNumber => {
        val product = outerNumber * innerNumber
        print(product + " ")
      })
    })
  }

  def forComprehensionExample(data: Traversable[Int]): Unit = {
    for {
      outerNumber <- data
      innerNumber <- data
    } {
      val product = outerNumber * innerNumber
      print(product + " ")
    }
  }

  def customComprehensionExample(data: Traversable[Int]): Unit = {
    for {
      outerNumber <- data
      word <- Times(outerNumber, "hoera")
    } {
      print(s"$word ")
    }
  }

  case class Times(times: Int, word: String) {

    def foreach[R](callFunc: String => R): Unit = {
      for(i <- 0 to times) callFunc(word)
    }

  }

  def usage(): Unit = {
    for(word <- Times(20, "scala")) {
      println(word)
    }
  }



}
