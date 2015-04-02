package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-3-31.
 */
object book13 extends App {
  val seqx = Seq(1, 2, 3, 4, 5, 6, 7, 8)
  println(seqx.head)
  println(seqx.headOption.getOrElse(2))
  println(seqx.init)
  println(seqx.reduceLeft((a, b) => a - b))
  println(seqx.reduceRight((a, b) => a - b))
  println(seqx.map(2 * _))
  println(seqx.foldLeft(3)((a, b) => a - b))
  println(seqx.foldRight(3)((a, b) => a - b))
  println(seqx.reduce((a, b) => a - b))
  //  println(seqx.aggregate())
  println(seqx.max)
  println(seqx.sum)
  println(seqx.product)
  println(seqx)

  println(seqx.count(_ % 2 == 0))
  println(seqx.forall(_ > 2))
  println(seqx.exists(_ == 4))

  println(seqx.filter(_ % 2 == 0))
  println(seqx.filterNot(_ % 2 == 0))
  println(seqx.partition(_ % 2 == 0))

  println(seqx.takeWhile(_ < 4))
  println(seqx.dropWhile(_ < 4))
  println(seqx.span(_ < 4))

  println(seqx.take(3))
  println(seqx.drop(3))
  println(seqx.splitAt(3))

  println(seqx.slice(3, 5))
  val companies = List(Company("B"), Company("A"), Company("T"))
  //同构
  println(companies.foldLeft(Company("King", Nil))((a, b) => Company(a.name, a.children :+ b)))
  println(companies.foldLeft("")((acc, company) => {
    println(acc)
    acc + company.name
  }))
  //异构
  println(companies.aggregate(BigCompany("BigC"))((big, com) => BigCompany(big.name, big.other :+ com), (b1, b2) => BigCompany(b1.name + b2.name, b1.other ++ b2.other)))


  val zipO = List(2, 4, 5)
  val zipT = List(3, 5, 4, 51)
  println(zipO zip zipT)

  println(zipO zipAll(zipT, "O", "T"))

  println("21111".zipWithIndex)
  println("21111".zipWithIndex.max)
  println("21111".zipWithIndex.min)

  import scala.collection.JavaConversions._

  val props: scala.collection.mutable.Map[String, String] = System.getProperties()
  println(props.getClass.getName)

  for (i <- (0 until (100)).par) {
    println(i)
  }
}

case class Company(name: String, children: Seq[Company] = Nil)

case class BigCompany(name: String, other: Seq[Company] = Nil)