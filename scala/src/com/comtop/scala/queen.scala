package com.comtop.scala

import scala.collection.mutable.{Set, ArrayBuffer}

/**
 * Created by zhaoqunqi on 15-3-31.
 */
object queen extends App {
  val QUEEN_COUNT = 8

  def cal(num: Int, queenLocation: ArrayBuffer[(Int, Int)], alreadyUse: Set[(Int, Int)]): (ArrayBuffer[(Int, Int)], Set[(Int, Int)]) = {

    if (num > QUEEN_COUNT) {
      printlnLocation(queenLocation)
    } else {
      (1 to QUEEN_COUNT).foreach(y => {
//        println(num,"=========",y,queenLocation,alreadyUse)
        if (!isExites(num, y, alreadyUse)) {
          val tmpQueenLocation = ArrayBuffer[(Int, Int)]((num, y))
          val tmpAlreadyUse =  getAlready(num, y)
          cal(num + 1, queenLocation++tmpQueenLocation, alreadyUse++tmpAlreadyUse)
        }
      })
    }
    (queenLocation, alreadyUse)
  }

  def isExites(x: Int, y: Int, alreadyUse: Set[(Int, Int)]): Boolean = {
    alreadyUse.foreach(local => {
      if (local._1 == x && local._2 == y) {
        return true
      }
    })
    false
  }

  def getAlready(x: Int, y: Int): Set[(Int, Int)] = {
    val result = Set[(Int, Int)]((x, y))
    val max = (a: Int, b: Int) => {
      if (a > b)
        a
      else
        b
    }
    val min = (a: Int, b: Int) => {
      if (a > b)
        b
      else
        a
    }

    val minValue = min(x, y)
    val maxValue = max(x, y)
    for (i <- 1 to QUEEN_COUNT) {
      result += ((x, i))
      result += ((i, y))
      val xAddi = x + i
      val yAddi = y + i
      val ySubi = y - i
      val xSubi = x - i
      if (xAddi <= QUEEN_COUNT && yAddi <= QUEEN_COUNT) {
        result += ((xAddi, yAddi))
      }
      if (ySubi > 0 && xSubi > 0) {
        result += ((xSubi, ySubi))
      }
      if (ySubi > 0 && xAddi <= QUEEN_COUNT) {
        result += ((xAddi, ySubi))
      }
      if (yAddi <= QUEEN_COUNT && xSubi > 0) {
        result += ((xSubi, yAddi))
      }
    }
    result
  }

  var count=0;
  def printlnLocation(queenLocation: ArrayBuffer[(Int, Int)]): Unit = {
    count=count+1
    println("printlnLocation",count)
    for(x <- 1 to QUEEN_COUNT;y <- 1 to QUEEN_COUNT){

      if(queenLocation.contains((x,y))){
        print("Q")
      }else{
        print("*")
      }
      if(y == QUEEN_COUNT){
        println()
      }
    }
  }

  cal(1, ArrayBuffer[(Int, Int)](), Set[(Int, Int)]())
}
