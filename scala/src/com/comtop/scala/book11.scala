/**
 * Created by zhaoqunqi on 15-3-31.
 */

class Fraction(val n: Int,val m: Int) {}

object Fraction {
  def apply(n: Int, m: Int) = new Fraction(n, m)
  def unapply(input:Fraction) = {Some(input.n+" "+input.m)}
}

object Main extends App {
  //  val list = 1 :: 2 :: Nil
  //  3 :: list
  //  println(list)
  val s = Fraction(1, 2)
  val Fraction(x) = s
  println(x)
}