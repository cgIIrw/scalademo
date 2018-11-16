object Hello {
  def main(args: Array[String]): Unit = {
    println(max(b = 10,a = 21,c = 3))

    val tripler = Multiplier.staticMethod(3)
    val result = tripler.product(13)

    println(result)
  }

  def max(a: Int, b: Int, c: Int) = {
    def max(x: Int, y: Int)= {
      println(s"输入：$x, $y")
      if (x > y) x else y
    }
    max(a, max(b, c))
  }
}

class Multiplier(val x: Int) { def product(y: Int) = x * y}

object Multiplier {
  def staticMethod(x: Int): Multiplier = new Multiplier(x)
//  def apply(x: Int): Multiplier = new Multiplier(x)
}