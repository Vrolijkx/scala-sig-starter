package be.aca.scala.session2.demo

/**
  * Copyright (C) 02/05/2017 - REstore NV
  */
object TraversableFilterOpperations extends App {
  //first show collection hierarchy
  val data: Traversable[Int] = 1 to 50

  filterExample(data)


  def filterExample(data: Traversable[Int]): Unit = {
    val devisableBy2 = data.filter(_ % 2 == 0)
    val notDevisableBy2 = data.filterNot(_ % 2 == 0)

    //withFilter is optimized for chaining and can be used in for comprehensions
    val devisableBy3And4 = data.withFilter(_ % 3 == 0).withFilter(_ % 4 == 0)

    println(s"by 2: $devisableBy2")
    println(s"not by 2: $notDevisableBy2")
  }

  def filterForComprehension(data: Traversable[Int]): Unit = {
    for {
      number <- data if number >= 20
    } println(number)
  }


  def collectionConversions(data:Traversable[Int]): Unit = {
    val list = data.toList
    val seq = data.toSeq
    val set = data.toSet
    val array = data.toArray
    val vector = data.toVector
    val buffer = data.toBuffer

    //We can also create a map if we first make tuples
    data.map(number => (number, number * number)).toMap
  }




}
