import scala.actors.Actor

/**
 * Created by zhaoqunqi on 15-3-20.
 */

class HiActor extends Actor {
  def act(): Unit = {
    while (true) {
      receive {
        case "Hi" => println("Hello")
        case _ => println("none")
      }
    }
  }
}

val hi = new HiActor
hi.start()
hi ! "Hi"
hi ! "Hi1"

case class Add(a: Int)

case class Rem(a: Int)

class AccountActor extends Actor {
  private var count = 0

  def printlnAccount() = {
    println(count)
  }

  def act() = {
    while (true) {
      receive {
        case Add(a) => count += a
        case Rem(a) => count -= a
        case "print" => println(count)
      }
    }
  }
}

val aa = new AccountActor
aa.start()
aa ! Add(3)
aa ! Add(1)
//aa ! Rem(2)
//aa.printlnAccount()
aa ! "print"

case class Fraction(n: Int, m: Int) {
  override def toString(): String = {
    n + "/" + m
  }

  def *(other:Fraction):Fraction={
    this
  }
}

implicit def int2Fraction(n:Int) = Fraction(n,1)

val dd = 3 * Fraction(1,1)
println(dd.toString)