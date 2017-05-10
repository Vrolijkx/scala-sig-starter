package be.aca.scala.session2.demo

import java.util

import scala.collection.mutable.Buffer


/**
  * Copyright (C) 08/05/2017 - REstore NV
  */
object collectionsFromJava {


  //needed to bring asScala and asJava in scope
  import scala.collection.JavaConverters._

  def convertToScalaExample(): Unit = {
    val someJavaList: java.util.List[String] = java.util.Arrays.asList(
      "waarde1", "waarde2", "waarde2"
    )

    val scalaVariant: Buffer[String] = someJavaList.asScala

  }

  def converToJavaExample(): Unit = {
    val someScalaList = List("waard1", "waarde1", "waarde3")

    val javaVariant: util.List[String] = someScalaList.asJava
  }

}
