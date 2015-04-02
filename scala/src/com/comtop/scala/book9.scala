/**
 * Created by zhaoqunqi on 15-3-12.
 */


import java.io.PrintWriter

import scala.io.Source

val filePath = "/home/zhaoqunqi/ideacode/scala/src/com/comtop/scala/book4.scala"
val file = Source.fromFile(filePath)
file.getLines() foreach (println)

val context = Source.fromFile(filePath).mkString
println("=-======")
println(context)
println("=-======")
/*
for(c <- Source.fromFile(filePath)){
  println(c)
}*/

val urlSource = Source.fromURL("http://10.10.50.120/bpms", "UTF-8")
urlSource.getLines().foreach(println(_))

val out = new PrintWriter("out.out")
out.print("s")
out.append("d")
out.close()

println("序列号1")

class MyPerson(val name: String) extends Serializable  {
}

import java.io._
val pp = new MyPerson("shake")
val outP = new ObjectOutputStream(new FileOutputStream("outP.person"))
outP.writeObject(pp)
outP.close()
//val inP= new ObjectInputStream(new FileInputStream("outP.person"))
//val savedP = inP.readObject().asInstanceOf[MyPerson]
//println(savedP.name)
//inP.close()