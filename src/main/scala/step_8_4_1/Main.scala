package step_8_4_1

import step_8_4_1.Expr.Calc
import step_8_4_1.ExprSyntax._

/*
Данная задача состоит из двух частей.
Часть 1
Мы написали трейт, представляющий собой часть математического выражения, использующего переменные, сложение, вычитание и
умножение:

trait Expr[T] {
  def literalInt(value: Int): T
  def variable(name: String): T
  def times(x: T, y: T): T
  def plus(x: T, y: T): T
  def minus(x: T, y: T): T = plus(x, negate(y))
  def negate(x: T): T      = times(x, literalInt(-1))
}

Объект ExprSyntax содержит методы, добавляющие "синтаксический сахар":

object exprSyntax {
  def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)
  def X[T](implicit expr: Expr[T]): T                      = expr.variable("x")
  def Y[T](implicit expr: Expr[T]): T                      = expr.variable("y")
  def Z[T](implicit expr: Expr[T]): T                      = expr.variable("z")

  implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
    def lit: T = expr.literalInt(x)
  }

  implicit class NumOps[T](val x: T) extends AnyVal {
    def +(y: T)(implicit expr: Expr[T]): T  = expr.plus(x, y)
    def -(y: T)(implicit expr: Expr[T]): T   = expr.minus(x, y)
    def *(y: T)(implicit expr: Expr[T]): T   = expr.times(x, y)
    def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
  }
}

В качестве примера написали одну реализацию:

object Expr {
  ﻿﻿implicit val stringExpr: Expr[String] = new Expr[String] {
    ﻿ override def literalInt(value: Int): String = s"$value"
    ﻿override def variable(name: String): String      = s"${name.toUpperCase}"
    ﻿override def times(x: String, y: String): String = s"($x)*($y)"
    ﻿override def plus(x: String, y: String): String  = s"($x)+($y)"
    ﻿override def minus(x: String, y: String): String = s"($x)-($y)"
    ﻿override def negate(x: String): String           = s"-($x)"
    ﻿}
  ﻿}

Она расставляет в выражении скобки согласно с приоритетами операций:

def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
println(function[String]) // ((((X)*(X))+((2)*((Y)+(((Z)*(X))*(2)))))-((7)*(Z)))+(4)

Ваша задача - написать реализацию трейта, которая позволит вычислять подобные выражения на заданных значениях
переменных. Подстановки переменных удобно хранить в виде функции из ассоциативного массива значений переменных в сами
значения (Calc в коде ниже):

type Calc[T] = Map[String, T] => T

implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new Expr[Calc[T]] {
import Numeric.Implicits._
// methods
}

Тогда наше выражение, записанное в function можно будет переиспользовать таким образом:

println(function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2))) // 2.4

Ничего выводить в консоль и считывать не надо. Просто реализуйте недостающие методы.
Дополнительная информация:
1) Подсказка: для реализации метода конвертации числа в литерал вам, скорее всего, понадобится посмотреть интерфейс
scala.math.Numeric.
2) Почему выражение выполняется в правильном порядке? https://docs.scala-lang.org/tour/operators.html
3) Context bounds
def g[A : B](a: A) = h(a)
https://docs.scala-lang.org/tutorials/FAQ/context-bounds.html
*/

object Main extends App {
  def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit

  println(function[String])
  println(function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2)))
}
