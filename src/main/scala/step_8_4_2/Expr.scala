package step_8_4_2

trait Expr[T] {
  def literalInt(value: Int): T

  def variable(name: String): T

  def times(x: T, y: T): T

  def plus(x: T, y: T): T

  def minus(x: T, y: T): T = plus(x, negate(y))

  def negate(x: T): T = times(x, literalInt(-1))
}

object Expr {
  implicit val stringOrderExpr: Expr[Print] = new StringOrderExpr
}
