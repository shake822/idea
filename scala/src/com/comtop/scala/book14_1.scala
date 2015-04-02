package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-4-2.
 */


object book14_1 extends App {
  swap(Array((1, 2), (3, '4')))

  def swap(arr: Array[(Int, Any)]): Array[(Int, Any)] = {
    arr.foreach(item => item match {
      case (a, b: Int) => println(a, b)
      case _ => println(0)
    })
    null
  }

  def change(any: Any): Int = {
    any match {
      case '+' => 1
      case '-' => -1
      case ch: Char if Character.isDigit(ch) => Character.digit(ch, 10)
      case _ => 0
    }
  }

  println(change("xxx"))
  println(change('+'))

  def arrMatch(arr: Array[Any]): Unit = {
    arr match {
      case Array(0) => println("Array(0)")
      case Array(0,_*)=>println("Array(0......)")
      case Array(x,y)=>println("Array(x,y)")
      case _ =>println("other")
    }
  }

  arrMatch(Array(1))
  arrMatch(Array(0))
  arrMatch(Array(0,0,0))
  arrMatch(Array(0,0))

  def patternMatch(str:String) ={
    val pattern="(\\d+) (\\w+)".r
    str match {
      case pattern(num,item)=>{
        println(num,item)
      }
      case _ => println("other")
    }
  }
  patternMatch("12 sjek")
  patternMatch("1 2")

  import scala.collection.JavaConversions.propertiesAsScalaMap

  for((k,v) <- System.getProperties() if v==""){
    println(k,v)
  }

  val testA = TestBean("shake",18)
  val testB = testA.copy()
  testB.name="ask"
  println(testA,testB)
}

case class TestBean(var name:String,age:Int){}
abstract class TestA