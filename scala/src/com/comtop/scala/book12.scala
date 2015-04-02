package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-31.
 */
object book12 extends App {

  def fun(i: Double): Int = {
    i.toInt
  }
 println((1.22).toInt)
  val a = Array(1.22,2.33,4.55).map(fun)
  a.foreach(println(_))

  val line = 9

  (0 until line).map(index => {
    val spaceNum =  line - index -1
    " "*spaceNum+"* "*index
  } ).foreach(println(_))


  def mutil(x:Int,y:Int): Int ={
    x*y
  }

  def mutilAtTime(x:Int) = (y:Int) => x*y
  println(mutil(3,5))
  println(mutilAtTime(3)(4))


  val aa = Array("Hello","world")
  val ab = Array("hello","World")
  println(aa.corresponds(ab)(_.equalsIgnoreCase(_)))

}
