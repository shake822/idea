package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-30.
 */
trait ConsoleLog extends Log{
  override def log(msg:String): Unit ={
    println(msg)
  }
}
