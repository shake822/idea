package com.comtop.scala

import scala.xml.{Text, XML, NodeSeq, NodeBuffer}

/**
 * Created by zhaoqunqi on 15-4-3.
 */
object book16 extends App {
  val doc = <html test="tests">shake
    <head></head>
  </html>
  println(doc.getClass)
  println(doc.text)
  println(doc.child)
  println(doc.attributes)
  println(doc.attributes.get("youmeiyou").getOrElse("没有"))
  println(doc.attributes("youmeiyou"))
  val head = doc \ "head"
  println(head)
  val data = Array(123, 223)
  val items = new NodeBuffer
  items += <li>shake
    {data(0)}
  </li>
  items += <li>ask2
    {data(1)}
  </li>
  val nodes: NodeSeq = items
  println(nodes)
  XML.save("/home/zhaoqunqi/root.xml", doc)
  val newFile = XML.loadFile("/home/zhaoqunqi/root.xml")
  println(newFile)

  val testO = <shake/>
  println(testO(0)(0)(0))
  <li>shake</li> match {
    case <li>{Text(t)}</li> => println(t)
    case _ => println("no")
  }
  <li>{"shake"}</li> match {
    case <li>{Text(t)}</li> => println(t)
    case _ => println("no")
  }
}
