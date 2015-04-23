package com.comtop

import _root_.scala.collection.JavaConversions._

/**
 * Created by zhaoqunqi on 15-4-7.
 */
object Test extends App {
  val ss = System.getProperties

  val props: _root_.scala.collection.mutable.Map[String, String] = System.getProperties()
  println(props)
  println(None.orElse(props.get("os.name1")).orElse(props.get("sun.jnu.encoding")))
}
