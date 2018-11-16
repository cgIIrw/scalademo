package scala.C2

/**
  * 练习2.3，将fDemo这个函数柯里化为fcurried
  */
object MyModule2_3 {

  def curry[A,B,C](f: (A,B) => C):A =>(B=>C) = f.curried

  def fDemo = (x: Int, y: Int) => x * y

  def main(args: Array[String]): Unit = {
    val fcurried = curry(fDemo)
    print(fcurried(3)(4))
  }
}
