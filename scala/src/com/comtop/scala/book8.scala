/**
 * Created by zhaoqunqi on 15-3-27.
 */

class Base {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Base {
  override val range: Int = 2
}

val a = new Ant()
println(a.env.length)