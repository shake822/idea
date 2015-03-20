/**
 * Created by zhaoqunqi on 15-3-12.
 */
import scala.io.Source
val file = Source.fromFile("/home/zhaoqunqi/ideacode/scala/src/com/comtop/scala/book4.scala")
file.getLines() foreach(println)

