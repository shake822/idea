/**
 * Created by zhaoqunqi on 15-3-12.
 */

val s = Array[Int](1,2)
val ss = Array[Int](2,3,4)
(s:+(4)) foreach println

((-1) +: s) foreach println

(s++ss) foreach(print)
println