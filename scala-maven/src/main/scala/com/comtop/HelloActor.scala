package com.comtop

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}

/**
 * Created by zhaoqunqi on 15-4-10.
 */
object HelloActor extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor], name = "ss")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}
