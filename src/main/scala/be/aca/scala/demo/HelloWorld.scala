package be.aca.scala.demo

object HelloWorld {

  def main(args: Array[String]): Unit = {
    val readableArgs: String = args.mkString(",")

    println("Hello World!" )
    println(s"arguments = $readableArgs")
  }
}

