package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-4-3.
 */
object book17_1 extends App {
  val p = Pair(1, 2)
  println(p.getClass)
  println(p._1)
  println(new PairTwo(ClildOne(), new ClildTwo()).com)
  println(new PairThree[Int](1,2).com)
}

class Pair[X, S](val tt: X, val ss: S)

class PairTwo[T <: Parent](val one: T, val two: T) {
  def com = one.count() > two.count()
}

class PairThree[T <% Comparable[T]](val one: T, val two: T) {
  def com = one.compareTo(two)
}

abstract class Parent {
  def count(): Int
}

//case class ClildOne extends Parent {
//  override def count(): Int = {
//    1
//  }
//}

class ClildTwo extends Parent {
  override def count(): Int = {
    2
  }
}
