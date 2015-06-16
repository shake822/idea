import groovy.transform.PackageScope

println "Hello Let's go"

def shake(String str){
      println "${str}"
}

System.out.println("sss")
 
 shake("hehe ")

 def map=[:]
 map."key1" = "value1"
 shake(map.key1)
def param="hehe"
 /*

 */
 def aMultilineString = '''\
line one\
line two ${map."key1"} ${param}
line three'''
shake(aMultilineString) 
def str1 = " ${map."key1"} ${param}"
shake(str1)
str1='${map."key1"} ${param}'
shake(str1)

def person =[name:'shake',age:10]
shake(person.name)

def number =1
def stringNumber1 = "value=${number}"
def stringNumber2 = "value=${->number}"
assert stringNumber1 =="value=1"
assert stringNumber2=="value=1"
number ++
assert stringNumber1 =="value=1"
assert stringNumber2=="value=2"

String takeString(String message){
	shake("takeString:${message.class}")
	assert message instanceof String
	return message
}
def message = "The message is ${'Hello'}"
shake("${message.class}")
assert message instanceof GString
def result = takeString(message)
shake("${result.class}")
assert result instanceof String
assert result =="The message is Hello"
println "${message}".hashCode() +" " +result.hashCode()
def fooPattern=/foo* \//
println fooPattern

def multilineSlashy = /one
    two
    three/
  println multilineSlashy

  def name = "Guillaume"
def date = "April, 1st"
/*
def dollarSlashy = $/
    Hello $name,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \  backslash
    / forward slash
    $/ escaped forward slash
    $/$ escaped dollar slashy string delimiter
/$ 


println dollarSlashy
*/
def numbers =[1,2,3] as LinkedList
println  "${numbers.class}"
numbers << 4
println numbers 
def key="name"
def personKey=[key:"shake"]
println personKey
personKey=[(key):"ask"]
println personKey
 

 class User {
    public final String name
    @PackageScope int age
    User(String name) { this.name = name}
    String getName() { "Name: $name" }                     
}
def user = new User('Bob')
assert user.name == 'Name: Bob' 
assert user.@name =='Bob'
println user.age
def str ="hello shake"
println str.&toUpperCase()