package com.comtop.json

import java.text.SimpleDateFormat
import java.util.Date
/**
 * Created by zhaoqunqi on 15-3-2.
 */
object MainTest {

  def main(args: Array[String]) {
    val date = new Date()
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    println(format.parse("2015-02-03 15:40:51").getTime)
  }
}
