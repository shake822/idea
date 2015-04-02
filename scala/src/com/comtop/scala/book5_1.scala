/**
 * Created by zhaoqunqi on 15-3-24.
 */
class Person(val age: Int, val name: String) {
  println("sdf")
  override def toString:String= {
    age+" "+name
  }
}

object Person {
  println(" Personsdf")

  def test() = {
    println("test")
  }

  def apply(name: String) = {
    new Person(20, name)
  }
}

println(Person("shake"))
//Person.test
//val p = new Person(1, "222")
