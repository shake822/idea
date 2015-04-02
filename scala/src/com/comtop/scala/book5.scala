/**
 * Created by zhaoqunqi on 15-3-24.
 */

class Person {
  var age = 0
  var name=""
  def this(age:Int,name:String){
    this()
    this.age=age
    this.name=name
  }
}
val p = new Person
p.age=12
println(p.age)
val pp = new Person(12,"22")
println(pp.name,pp.age)
class Person2{
  private var privateAge = 0

  def age = privateAge
  def age_=(newAge:Int){
    privateAge = newAge
  }
}

val p2 = new Person2
p2.age=23
println(p2.age)