package scala.C3

import scala.annotation.tailrec

// 所有实现都要定义在这个文件
sealed trait List[+A]

// 表现空List的List数据构造器
case object Nil extends List[Nothing]

// 另一个构造器，非空List
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def product01(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  //
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  // 3.2答案：删除第一个元素
  def tail[A](e: List[A]): List[A] = e match {
    case Nil => Nil
    case Cons(head, tail) => tail
  }

  // 3.3答案：用不同的值替代列表第一个元素
  def setHead[A](x: A, e: List[A]): List[A] = e match {
    // 没有第一个元素不作处理
    case Nil => Nil
    case Cons(_, tail) => Cons(x, tail)
  }

  // 3.4答案：删除前n个元素
  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = if (n <= 0) l else l match {
    case Nil => Nil
    case Cons(_, tail) => drop(tail, n - 1)
  }

  // 3.5答案：实现dropWhile函数，删除列表中*前缀*全部符合判定的元素
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, tail) if f(x) => dropWhile(tail, f)
    case _ => l
  }

  def f[A](x: A): Boolean = x.equals(3)

  // 改进dropWhile类型推导，使其传入的Lambda表达式不需要书写类型
  def dropWhile02[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, tail) if f(x) => dropWhile02(tail)(f)
    case _ => l
  }

  // 基于list的递归并泛化为高阶函数
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    //
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x, y) => x + y)

  // 3.9答案：使用foldRight计算List的长度
  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((x, y) => 1 + y)
  }


  def main(args: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    println(x)

    // 3.2验证
    println(tail(List(1, 2, 3, 4)))

    // 3.3验证
    println(setHead(7, List(1, 2, 3, 4)))

    // 3.4验证
    println(drop(List(1, 2, 3, 4, 5, 6, 7), 3))

    // 3.5验证
    println(dropWhile(List(3, 3, 3, 4, 3, 4, 5), f))
    println(dropWhile02(List(3, 3, 3, 4, 3, 4, 5))(x => x == 3))

    // 3.9验证
    println(length(List(5,3,1,1,7)))
  }
}

