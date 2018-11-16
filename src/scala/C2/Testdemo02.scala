package scala.C2

sealed trait Testdemo02
case object Nil extends Testdemo02

case class Testdemo03(x: Any) extends Testdemo02

class T03(x: String) extends Testdemo03(x) {

}

object Testdemo02 {
  val a = 3
  def add(x: Int) = x * 2

  def sum(x: Testdemo02): Int = x match {
    case Testdemo03(y: Int) => y + 1
  }

  def main(args: Array[String]): Unit = {
    val o = Testdemo02
  }
}
