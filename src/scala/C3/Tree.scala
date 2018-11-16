package scala.C3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

case class A(x: Int)

class B
object B

object Tree {

  // 3.25答案：统计树的节点数
  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(value) => 1
    case Branch(left, right) => 1 + size(left) + size(right)
  }

  def main(args: Array[String]): Unit = {
    val b01 = new B
    val b02 = B
    val leafleft = new A(1);
    val leafleft001 = A(1)
    val leafleft01 = Leaf(3)
    val leafright = Leaf(4)
//    val branch = Branch(leafleft, leafright);
    println(leafleft.hashCode())
    println(leafleft001.hashCode())
    println(leafleft01.hashCode())
    println(b01.hashCode())
    println(b02.hashCode())
  }
}
