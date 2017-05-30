package be.aca.scala.session3.demo

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

//Bring our executionContext into implicit scope
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
  * Copyright (C) 30/05/2017 - REstore NV
  */
object FutureExamples extends App {
  println("for:")
  forComprehensionExample()
  println("parallel:")
  executingParallel()
  println("haneling failures:")
  handelingErrors()

  def longRunningComputation(number: Int): Future[Int] = {
    Future {
      println(s"starting longRunningComputation: $number")
      Thread.sleep(300)
      val result = number * number
      println(s"result of longRunningComputation: $result")
      result
    }

  }

  def otherLongRunningComputation(number: Int): Future[Int] = {
    Future {
      println(s"starting otherLongRunningComputation: $number")
      Thread.sleep(600)
      val result = number * number * number
      println(s"result of otherLongRunningComputation: $result")
      result
    }
  }

  def forComprehensionExample(): Unit = {

    //This is the same as using map and flatmap.
    val opperation: Future[Unit] = for {
      val1 <- longRunningComputation(30)
      val2 <- otherLongRunningComputation(val1)
    } yield println(s"async result: ${val1 + val2}")

    println("The above code is async")
    Await.ready(opperation, 1 second)
  }

  def executingParallel(): Unit = {
    val parallelComputation: Future[Seq[Int]] = Future.sequence(Seq(
      otherLongRunningComputation(300),
      longRunningComputation(300)
    ))

    println("The above code is async and parallel")

    val result = Await.result(parallelComputation, 650 millis)

    println(s"result: $result")
  }

  def handelingErrors(): Unit = {
    val failingFuture: Future[String] = Future.failed(new RuntimeException("failed"))

    //This method takes a partial function which is new
    //explain and give the collect example
    failingFuture.onFailure {
      case e: RuntimeException => println("we have a failure")
    }

    failingFuture.onComplete {
      case Success(result) => println(result) //not called in our situation
      case Failure(exception) => println(exception)

    }
  }

}
