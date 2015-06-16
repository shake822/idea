/**
 * Created by zhaoqunqi on 15/6/12.
 */
Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')
}
println isTextFile(new File("/Users.txt"))

def magicNumber = { -> 42 }

// this call will fail because the closure doesn't accept any argument
//magicNumber(11)
class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { this }
            this
        }
        println this.getClass().getName()
        assert nestedClosures() == this
    }
}
new NestedClosures().run()