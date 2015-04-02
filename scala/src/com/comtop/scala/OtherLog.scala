package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-30.
 */
trait OtherLog  extends Log{
  override def log(msg:String): Unit ={
    println("other"+msg)
  }

  def other(msg:String): Unit ={
    println("other"+msg)
  }
}
