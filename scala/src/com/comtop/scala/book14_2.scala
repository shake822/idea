package com.comtop.scala

/**
 * Created by zhaoqunqi on 15-4-2.
 */
object book14_2 extends App {

  abstract class Item

  case class Article(desc: String, price: Double) extends Item

  case class Bundle(desc: String, price: Double, items: Item*) extends Item

  val goodA = Article("book1", 12.30)
  val goodB = Article("book2", 1.30)
  val goodC = Article("book3", 13)
  val bundleA = Bundle("特价书", 10.00, goodA, goodB)
  val bundleAA = Bundle("特价书", 10.00, goodB, goodA)
  val bundleB = Bundle("聚划算", 15.00, bundleA, goodC)

  def itemMatch(item: Item): Unit = {
    item match {
      case Article(n, p) => {
        println("单个物品", n, p)
      }
      case Bundle(_, f, art@Article(n, p), rest) => {
        println("多个物品总价1", art, rest, f, n, p)
      }
      case Bundle(_, f, Article(n, p), _*) if (n == "book2") => {
        println("多个物品包含book2总价", f, n, p)
      }
      case Bundle(_, f, Article(n, p), _*) => {
        println("多个物品总价", f, n, p)
      }
      case _ => println("other")
    }
  }

  itemMatch(goodA)
  itemMatch(bundleA)
  itemMatch(bundleAA)
  itemMatch(bundleB)

}

case class TTT() extends TestA
