package be.aca.scala.demo

/**
  * Copyright (C) 17/04/2017 - REstore NV
  *
  */
object HelloWorld2 extends App {
  private val readableArgs = args.mkString(",")

  println("Hello World!" )
  println(s"concat arguments = $readableArgs")

}
