package scala.C2

/**
  * 兼带练习2.1递归求解
  */
object MyModule {


  def fib(n: Int): Int = {

    if (n <= 0) throw new IllegalArgumentException("请输入大于0的参数")
    else if (n <= 2 && n > 0) n - 1
    else if (n == 3) 1
    else fib(n-2) + fib(n-1)
  }

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(fib(6))
  }
}
