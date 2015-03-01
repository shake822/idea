/**
 * Created by zhaoqunqi on 15-1-30.
 */
class Rational(n:Int,d:Int){
  require(d !=0)
  val number : Int = n
  val domon : Int = d
  def add(that:Rational):Rational= {
    new Rational(number * that.domon+ domon*that.number,domon*that.domon)
  }
  def this(n:Int) = this(n,2)
  override def toString = n+"/"+d
}
