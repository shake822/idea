package com.comtop.scala

import scala.collection.mutable.Map

/**
 * Created by zhaoqunqi on 15-4-1.
 */
object book13_1 extends App {

  println(indexs("shake s"))

  def indexs(str: String): Map[Char, Seq[Int]] = {
    val indexMap = Map[Char, Seq[Int]]()
    println(str.zipWithIndex)
    str.zipWithIndex.foreach(_ match {
      case (a: Char, b: Int)=> {
        indexMap += (a -> (indexMap.getOrElse(a, Seq[Int]()) :+ b))
      }
      case _=> println("x")
    })
    indexMap
  }
}