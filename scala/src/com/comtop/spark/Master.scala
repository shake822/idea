package com.comtop.spark

import com.comtop.spark

class TestClass {}

object TestClass

object TestClass2

class TestClass2 {}

/**
 * Created by zhaoqunqi on 15-4-10.
 */
object Master {
  def main(args: Array[String]) {
    val startService: Int => (TestClass, Int) = { actualPort =>
      doCreateActorSystem(actualPort)
    }
    println(startService)
    testMatch(TestClass)
  }

  def testMatch(item: Any): Unit = {
    item match {
      case TestClass => println("test"); TestClass2
      case TestClass2 => println("test2")
      case _ => println("other")
    }
  }

  def doCreateActorSystem(actualPort: Int): (TestClass, Int) = {
    (null, 2)
  }

}
