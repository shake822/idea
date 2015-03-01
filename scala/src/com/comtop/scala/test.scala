/**
 * Created by zhaoqunqi on 15-1-29.
 */
println("test")
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}
println("foreach")
args.foreach(it => println(it))
println("foreach2")
args.foreach(println)
println("数组测试")
var greetString = new Array[String](5)
greetString(0) = "hello"
greetString(1) = "how"
greetString(2) = "are"
greetString(3) = "you"
for (it <- 0 to 3) {
  print(greetString(it)+ " ")
}
println("List测试")
val oneTwo = List(1,2,3)
val threeFour = List(3,4)
val resultList = oneTwo ::: threeFour
println (oneTwo,threeFour)
println (resultList)
println("Set测试")
import scala.collection.mutable.Set
val tmpSet = Set("one","two")
println(tmpSet)
tmpSet += "three"
println(tmpSet)
println("Map测试")
var tmpMap = Map[Int,String]()
tmpMap +=(1->"one")
tmpMap +=(2->"tow")
tmpMap +=(2->"ttttt")
tmpMap.foreach(it => println(it._1))
println(tmpMap)
println("读取文件")
import scala.io.Source
val lines= Source.fromFile("/home/zhaoqunqi/bookTest.go").getLines().toList

def widthOfLength(s:String) = s.length.toString.length

val longLine = lines.reduceLeft(
  (a,b) => if(a.length > b.length) a else b
)

val maxWidth = widthOfLength(longLine)
println(longLine)
for(line <- lines){
  val numSpaces = maxWidth-widthOfLength(line)
  val padding=" "*numSpaces
  println(padding+line.length+" | "+line)

}

println("class test")
/*
var t2 = new TestClass()
var t3 = new TestClass()
println(t2.message)
println(t2.message==t3.message)
*/

println("test String")

val tmpString="helloWorld"
println(tmpString indexOf 'o')

println("rational")

//val tmpRational = new Rat