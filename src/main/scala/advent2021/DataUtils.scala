package advent2021

import java.io.InputStream
import scala.io.Source

object DataUtils {

  def getDataInts[A](clazz: Class[A]): LazyList[Int] = {
    getDataLines(clazz).map(_.toInt)
  }

  def getDataLines[A](clazz: Class[A]): LazyList[String] = {
    val lines = Source.fromInputStream(getDataStream(clazz)).bufferedReader().lines().iterator()
    LazyList.continually {
      if(lines.hasNext)
        Option(lines.next())
      else
        None
    }.takeWhile(_.isDefined).map(_.get)
  }

  private def getDataStream[A](clazz: Class[A]): InputStream = {
    clazz.getResourceAsStream("input.txt")
  }
}
