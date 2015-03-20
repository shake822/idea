/**
 * Created by zhaoqunqi on 15-3-12.
 */

val arr = Array[String]("1","2","3","4")
val arr2 = Array[String]("a","b")
val arr3 = arr.zip(arr2).toMap
arr3 foreach print
println