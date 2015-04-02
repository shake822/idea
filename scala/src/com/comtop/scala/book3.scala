import scala.collection.mutable.ArrayBuffer

/**
 * Created by zhaoqunqi on 15-3-12.
 */

val a = Array[String]("1", "2", "3")
//a += "3"
println(a.length)
for (ac <- a) {
  println(ac)
}

val b = ArrayBuffer[String]()
b += "a"
b += "r"
b insert(1, "d")
//b remove 1
//b foreach { item =>
//  b.-(item)
//}

//for(i <- 0 until b.length){
//  b remove(i)  //有问题。和java一样
//}
//b trimEnd 1
//b trimStart 1
b foreach print
println
val c = for (aItem <- a if ("1".equals(aItem))) yield aItem * 2
c foreach print
println
val d = a.filter(aItem => aItem == "2").map(cItem => cItem * 3)
d foreach print
val intA = ArrayBuffer[Int](3, 4, 5, 6, 9, 7, 8)
println(intA.max)
println(intA.sorted reverse)
println(intA.sortBy(item => item))
println((intA.sorted reverse).mkString("[", ">", "]"))
println("练习题")
println("1")
val n = scala.util.Random
println(n.nextInt(3))
val eOne = ArrayBuffer[Int]()
for (i <- 0 until 10) {
  eOne += n.nextInt(10)
}
println(eOne)

val e2 = Array[Int](1, 2, 3, 4, 5)

def reverse(arr: Array[Int]) = {
  for (i <- 0 until(arr.length - 1, 2)) {
    val t = arr(i)
    arr.update(i, arr(i + 1))
    arr.update(i + 1, t)
  }
}
reverse(e2)
e2.foreach(println)

println("3+=========")
def reverseE3(arr: Array[Int]) = {
  for (i <- 0 until e2.length) yield {
    if (i % 2 == 0) {
      if (i < e2.length - 1) {
        arr(i + 1)
      } else {
        arr(i)
      }
    } else {
      arr(i - 1)
    }
  }
}
val e31 = Array[Int](1, 2, 3, 4, 5)
val e3 = reverseE3(e31)
e3.foreach(println)
println("4+=========")
val e4 = Array[Int](2, 44, 6, -4, 3, -1, 0, 23)
def method4(arr: Array[Int]) = {
//  for()
}
println(e4.sum)