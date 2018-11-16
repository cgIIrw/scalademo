package scala.C2
import scala.C2.MyModule2_3._

object MyModule2_4 {

  val fcurried = curry(fDemo)

  def uncurry[A,B,C](f: A=> B=> C): (A, B) => C = Function.uncurried(f)

  def main(args: Array[String]): Unit = {
    val curri = uncurry(fcurried)
    print(curri(3, 4))
  }
}
