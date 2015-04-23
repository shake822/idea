package com.comtop.scala

import scala.collection.JavaConverters._

/**
 * Created by zhaoqunqi on 15-4-7.
 */
object MainTest extends App {
  val t = System.getProperties.asScala
  println(t.keySet)
}
