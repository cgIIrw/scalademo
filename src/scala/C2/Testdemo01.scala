package scala.C2

/**
  * 本例主要用来研究孤立对象 & 伴生对象
  */
class Testdemo01 {
  val s01 = "chenchen"
  var s02 = "guoguo"

  def newAdd(b: Int) = {
     b + 1
  }

  def add(x: Int) = x + 15
}

object Testdemo01 {
  val a = 3
  def add(x: Int) = x * 2

  def main(args: Array[String]): Unit = {
    a
    add(a)
  }
}
