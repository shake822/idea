/**
 * Created by zhaoqunqi on 15-1-30.
 */
object MainTest {

  def main(args : Array[String]){
    println("Hello")
    val rational2 = new Rational(1,3)
    val rational3 = new Rational(1,3)
    val rational4 = new Rational(1)
    println(rational4)
    print(rational2 add rational3)
  }
}
