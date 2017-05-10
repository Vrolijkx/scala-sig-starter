package be.aca.scala.session1.exercises.exercise1

/**
  * Copyright (C) 26/04/2017 - REstore NV
  */
object CrappyCalculator extends App {
  val sum = createSum(args)
  val product = createProduct(args)
  println(s"sum: ${createSum(args)}")


  def createSum(args: Array[String]): Double = {
    var sum = 0d

    for(argument <- args) {
//      sum += argument.toDouble.isV
    }

    sum
  }

  def createProduct(args: Array[String]): Double = {
    args.map(_.toDouble).reduce(_ * _)
  }



}
