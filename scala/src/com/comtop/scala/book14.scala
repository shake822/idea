/**
 * Created by zhaoqunqi on 15-3-20.
 */

def swap(arr: Array[(Int, Any)]): Array[(Int, Any)] = {
  arr.foreach(item => item match {
    case (a, b:Int) => println(a, b)
    case _ => println(0)
  })
  null
}
swap(Array((1, 2), (3, '4')))