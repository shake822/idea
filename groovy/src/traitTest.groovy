/**
 * Created by zhaoqunqi on 15/6/11.
 */
trait Introspector {
    int i=1
    def whoAmI() { this }
    def test(){
        println getII()
    }
    def getII(){
        i
    }
}
class Foo implements Introspector {
    int i =10
    def getII(){
        12
    }
}
def foo = new Foo()
println foo.test()

trait FlayingA{
    String fly(){
        "flying  ~~"
    }
}
trait FlyingAbility {
   String fly() { "I'm flying!" }
}
trait SpeakingAbility {
    String speak() { "I'm speaking!" }
}

class Duck implements FlayingA{}
def duck = new Duck()
def duck2 = duck.withTraits(FlyingAbility,SpeakingAbility,FlayingA)
println duck2.fly()
println duck2.speak()
