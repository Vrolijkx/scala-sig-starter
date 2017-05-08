package be.aca.scala.session1.exercises.exercise1

/**
  * Copyright (C) 26/04/2017 - REstore NV
  */
object CrappyCalculator extends App {
  val sum = createSum(args)
  val product = createProduct(args)

  println(
    s"""${args.mkString(",")}
       |sum: $sum
       |product: $product
     """.stripMargin
  )

  def createSum(arguments: Array[String]): Double = {
    arguments.map(_.toDouble).sum
  }

  def createProduct(arguments: Array[String]): Double = {
    arguments.map(_.toDouble).product
  }

}
