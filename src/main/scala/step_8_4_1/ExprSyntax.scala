package step_8_4_1

object ExprSyntax {
  def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)

  def X[T](implicit expr: Expr[T]): T = expr.variable("x")

  def Y[T](implicit expr: Expr[T]): T = expr.variable("y")

  def Z[T](implicit expr: Expr[T]): T = expr.variable("z")

  implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
    def lit: T = expr.literalInt(x)
  }

  implicit class NumOps[T](val x: T) extends AnyVal {
    def +(y: T)(implicit expr: Expr[T]): T = expr.plus(x, y)

    def -(y: T)(implicit expr: Expr[T]): T = expr.minus(x, y)

    def *(y: T)(implicit expr: Expr[T]): T = expr.times(x, y)

    def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
  }

}
