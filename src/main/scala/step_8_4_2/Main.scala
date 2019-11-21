package step_8_4_2

import ExprSyntax._

/*
Часть 2
В прошлом степе мы реализовали аппарат по вычислению математических выражений. Давайте теперь реализуем строковое
представление этих выражений.

Заведём вспомогательную сущность. Она будет помогать нам расставлять скобки, где нужно:

final case class Print(s: String, priority: Int, isLit: Boolean = false) {
  def print(outer: Int = 0) = if (outer <= priority) s else s"($s)"
}

s - математическое выражение, которому соответствует данный объект;
priority - приоритет математического выражения. Определяется приоритетом среди всех операций, переменных и литералов,
содержащихся в нём.
isLit - является ли выражение литералом

Список приоритетов:
1. Унарный минус
2. Сложение и вычитание
3. Умножение
4. Литерал
5. Переменная

Примеры:
1. X * Y * 2  имеет приоритет 3
2. 42 имеет приоритет 4
3. X имеет приоритет 5
4. -X+Y*3 имеет приоритет 1

Необходимо реализовать тот же интерфейс, что и в прошлом степе:

implicit val stringOrderExpr: Expr[Print] = new Expr[Print] {  override def literalInt(value: Int) = ???
override def variable(name: String): Print = ???
override def times(x: Print, y: Print): Print = ???
override def plus(x: Print, y: Print): Print  = ???
override def minus(x: Print, y: Print): Print = ???
override def negate(x: Print): Print          = ???
}

Использование выглядит так:

def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
println(function[Print].print()) // X*X+2(Y+Z*X*2)-7Z+4

Разделители операций:
1. Сложение - "+"
2. Вычитание - "-"
3. Унарный минус - "-", например "-X"
4. Умножение - если первый множитель литерал, то пустая строка "", иначе - "*". Например "2X" и "X*Y"

Ничего выводить в консоль и считывать из неё не надо. просто реализуйте недостающие методы.
*/

object Main extends App {
  def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit

  println(function[Print].print()) // X*X+2(Y+Z*X*2)-7Z+4
}
