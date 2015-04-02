package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-4-2.
 */
object book14_3 extends App {
  val aa = Dollar(213.33)
  var sss: String = _
  println(sss)
}

sealed abstract class Amount

case class Dollar(value: Double) extends Amount


