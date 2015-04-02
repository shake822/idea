package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-30.
 */
trait Log{
  val maxLength =10
  def log(msg: String): Unit ={
    println("default" +msg)
  }
}
