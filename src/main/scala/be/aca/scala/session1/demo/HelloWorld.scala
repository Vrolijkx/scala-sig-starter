package be.aca.scala.session1.demo

object HelloWorld {

  def main(args: Array[String]): Unit = {
    val readableArgs: String = args.mkString(",")

    println("Hello World!" )
    println(s"arguments = $readableArgs")
  }
}

