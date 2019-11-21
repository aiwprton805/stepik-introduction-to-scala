package step_8_4_1

trait Expr[T] {
  def literalInt(value: Int): T

  def variable(name: String): T

  def times(x: T, y: T): T

  def plus(x: T, y: T): T

  def minus(x: T, y: T): T = plus(x, negate(y))

  def negate(x: T): T = times(x, literalInt(-1))
}

object Expr {
  type Calc[T] = Map[String, T] => T

  implicit val stringExpr: Expr[String] = new StringExpr

  implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new NumericExpr
}
