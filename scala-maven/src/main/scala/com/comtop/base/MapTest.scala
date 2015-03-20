package com.comtop.base

import scala.collection.mutable
import scala.collection.mutable.{Map, Set}


/**
 * Created by zhaoqunqi on 15-3-10.
 */
object MapTest {
  def main(args: Array[String]) {
    val map = Map[Int, Set[String]]()
    map += (1 -> Set[String]("sdf"))
    println(map)

    mutable.Set[String]("123").|(Set[String]("123"))
//    println(map.get(1).get.|(null))

    println(Integer.MAX_VALUE)
  }
}
