package scala.caseclassdemo

case class A(x: Int) {

}

class B(x: Int) extends A(x) {

}

class C extends A(1) {

}

object CaseClassDemo01 {
  def main(args: Array[String]): Unit = {

  }

}
