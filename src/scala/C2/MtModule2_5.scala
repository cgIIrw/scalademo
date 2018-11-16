package scala.C2

/**
  * 练习2.5，用来实现compose，将两个函数合成一个函数
  */
object MtModule2_5 {

  // 可以用匿名函数来实现，不仅方便实现传参，而且最后返回的形式也是函数形式
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (x: A) => f(g(x))

  def main(args: Array[String]): Unit = {
    val f01 = (x: Int) => x * 3
    val f02 = (x: Int) => x + 1
    println(compose(f02, f01)(3))
  }
}
