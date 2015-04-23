package com.comtop.spark


/**
 * Created by zhaoqunqi on 15-4-16.
 */
object TaskTestScala {
  def main(args: Array[String]) {
    this.test((task: TaskTest, i: Int) => {
      println(task, i); i
    })
  }

  def test(func: (TaskTest, Int) => Int): Unit = {
    println(func(TaskTest.get(), 1))
    println("test")
  }
}
