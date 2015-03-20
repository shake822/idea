package com.comtop.base

import scala.collection.mutable.Set

/**
 * Created by zhaoqunqi on 15-3-2.
 */
object Coll {
  def main(args: Array[String]) {
    val a = Set[String]("1", "1")
    val v = Set[String]("3", "2")
    println(a.|(v))
  }
}
