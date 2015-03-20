/**
 * Created by zhaoqunqi on 15-3-10.
 */


val test = if(3>4) 1
println(test)
val name = readLine("名字：")
println(name)
//val age =readInt()
//println(age)

for(i <- 0 until(name.length,2)  ){
  println(name(i))
}

for(i<- 1 to 3;j <- 1 to 3){
  print(i*10+j +" ")
}
println("------")

for(i<- 1 to 3 if(i>1);j <- 1 to 3 if (i==j)){
  print(i*10+j +" ")
}

def fac(n:Int):Unit={
  "ccccc"
}
println(fac(2))
var sum = 0
for (ch <- "hello") {
  sum += ch
}
println(sum)

def defaultParam(body: String, left: String = "[", right: String = "]"): String = {
  left + body + right
}

println(defaultParam("hello"))
println(defaultParam("hello", "xx", "yy"))

def sum(args: Int*): Int = {
  var res = 0
  args.foreach(res += _)
  res
}

println(sum(1))
println(sum(1, 2))
println(sum(1 to 8: _*))

def numsign(num: Int): Int = {
  if (num > 0
  ) {
    1
  } else if (num < 0) {
    -1
  }else{
    0
  }
}

println(numsign(12))
println(numsign(-12))
println(numsign(0))


for(i <- 0 to 10 reverse){
  print(i+" ")
}

