package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-30.
 */

class MyPerson(val name: String) extends Serializable  {
}

object book9_1 extends App{
  import java.io._
//  val pp = new MyPerson("shake")
//  val outP = new ObjectOutputStream(new FileOutputStream("outP.person"))
//  outP.writeObject(pp)
//  outP.close()

  val inP= new ObjectInputStream(new FileInputStream("outP.person"))
  val savedP = inP.readObject().asInstanceOf[MyPerson]
  println(savedP.name)
  inP.close()

  import sys.process._
  val res1 = "ls -la" !!

}
