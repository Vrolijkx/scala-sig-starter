package be.aca.scala.session2.demo


/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
object FoldingExample extends App {
  private type StringTransFormer = String => String

  def replaceTransFormer(matchPart: String, replace: String): StringTransFormer = {
    value => value.replace(matchPart, replace)
  }

  val transformers = List[StringTransFormer](
    replaceTransFormer("I", "You"),
    replaceTransFormer("java", "scala"),
    replaceTransFormer("know", "learn"),
    replaceTransFormer("java rules", "java")
  )


  def foldRigthExample(): Unit = {
    val startText = "I know that java rules"

    val result = transformers.foldRight(startText)((transformer: StringTransFormer, value: String) => {
      transformer(value)
    })

    println(result)
    // You learn that scala
  }


  def foldLeftExample(): Unit = {
    val startText = "I know that java rules"

    val result = transformers.foldLeft(startText)((value: String, transformer: StringTransFormer) => {
      transformer(value)
    })

    println(result)
    //You learn that scala rules
  }



  println("left:")
  foldLeftExample()
  println("right:")
  foldRigthExample()

}
