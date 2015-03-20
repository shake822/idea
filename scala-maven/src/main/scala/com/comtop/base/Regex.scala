package com.comtop.base

/**
 * Created by zhaoqunqi on 15-3-9.
 */
object Regex {
  def main(args: Array[String]) {
    val reg = """^[0-9]+$""".r
    val res = reg.findFirstIn("") match {
      case Some(num) =>
        num
      case _ => (null)
    }
    println(res)
  }
}
