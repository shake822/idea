/**
 * Created by zhaoqunqi on 15/6/11.
 */
int xInt = 077
println xInt
println 1e3 as int
println 1_22_3_2322.0 as int
println 3**4

def lst = ["00",1,2,"33",4,5,6]
def lst2 = lst[0,1,3]
println lst2[-1]
lst2.each {
    println it
}

def key = 'name'
def person = [(key): 'Guillaume']

println person