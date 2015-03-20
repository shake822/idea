package com.comtop.base

/**
 * Created by zhaoqunqi on 15-3-19.
 */

case class Person(name: String, age: Int)

class Person1(val name: String, val age: Int)

object CaseClass {
  def main(args: Array[String]) {
    val p1 = Person("shake", 1)
    val p3 = Person("ddd", 3)
    println(p3)
    val p2 = new Person1("ask", 2)
    println(p2.name)
    testMatch("hello")
    testMatch((2,3,4))
    List(1,2).length
    println(List.concat(List('a','c'),List('c')))
    val aa = Person("shake", 1)
    val bb = aa.copy()
    println(aa,bb)
    val f:PartialFunction[Char,Int] = {
      case '+' =>1
      case '-' => -1
    }
    println(f('-'),f.isDefinedAt('*'))
  }

  def testMatch(expr: Any): Unit = {
    expr match {
      case (a, b, c) => println(a, b, c)
      case s:String =>println("String :",s)
      case _ => println("not found",expr)
    }
  }
}
