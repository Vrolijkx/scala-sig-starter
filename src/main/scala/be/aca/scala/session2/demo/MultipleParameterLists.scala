package be.aca.scala.session2.demo

/**
  * Copyright (C) 07/05/2017 - REstore NV
  */
object MultipleParameterLists extends App {

  example("hoera")(6)
  //second argument list comes from the foreach
  (1 to 6).foreach(example("hoera"))

  def example(someText: String)(times: Int): Unit = {
    println(s"x$times $someText")
  }

  thisIsHowISeeIt("hoera")(6)

  def thisIsHowISeeIt(someText: String): Int => Unit = {
    //the body of our High order function
    times => println(s"x$times $someText")
  }


  //EXTRA partial applied functions and currying
  def curryExample(): Unit = {
    val partialApplied1: Int => Unit = example("t")

    //give the compile a hint if you don't want to define your type
    //by ending with an _
    //this tell the compiler "I din't give you all arguments on purpose"
    //The _ stands for the placeholder still needed to be filled in
    val partialApplied2 = example("test") _


    //You can even do it without multiple parameters other functions

    def multiply(number1: Int, number2: Int) = number1 * number2

    val multiplyBy5: Int => Int = multiply(5, _)

    multiplyBy5(9)

  }


}
