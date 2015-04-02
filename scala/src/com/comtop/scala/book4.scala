import scala.collection.{SortedMap, mutable}
import scala.io.Source

/**
 * Created by zhaoqunqi on 15-3-12.
 */

val arr = Array[String]("1","2","3","4")
val arr2 = Array[String]("a","b")
val arr3 = arr.zip(arr2).toMap
arr3 foreach print

println("111111")
val device = Map("sss" ->10,"aaa"->20)
val newDevice = for((k,v) <- device) yield (k,v*0.9)
println(newDevice)
println("222222")
val file = Source.fromFile("/home/zhaoqunqi/ideacode/scala/src/com/comtop/scala/data")

import scala.collection.mutable._
val wordsMap = mutable.HashMap[String,Int]()
var wordsMap2 = SortedMap[String,Int]()
for(line <- file.getLines()){
    for(word <- line.split(" ")){
      println(word)
      wordsMap.put(word,wordsMap.getOrElse(word,0)+1)
      wordsMap2+=(word -> (wordsMap2.getOrElse(word,0)+1))
    }
}
println(wordsMap)

println(wordsMap2)

println("Hello".zip("123"))
println