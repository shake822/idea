/**
 * Created by zhaoqunqi on 15-3-24.
 */

object Hello extends App {
  println("hello", args)
  println(TrafficLightColor.Green.id)
}

object TrafficLightColor extends Enumeration {
  //  val Red, Yellow, Green = Value
  val Red = Value(1, "stop")
  val Yellow = Value( "wait")
  val Green = Value( "go")
}