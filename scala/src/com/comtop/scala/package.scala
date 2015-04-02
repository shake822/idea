package com.comtop

/**
 * Created by zhaoqunqi on 15-3-27.
 */
package object scala {
  val defaultName: String = "Scala测试"
}
package scala {

class Person {
  val name = defaultName

  def getName(): String = {
    name
  }
}

}

package test {

object Person extends App {
  println(scala.defaultName)
  println(new scala.Person().getName())
  import java.util.{HashMap => JavaHashMap}
  val s:JavaHashMap[Int, String]=new JavaHashMap()
}

}