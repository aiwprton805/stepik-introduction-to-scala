package step_8_4_1

import step_8_4_1.Expr.Calc

class NumericExpr[T: Numeric] extends Expr[Calc[T]] {

  import Numeric.Implicits._

  override def literalInt(value: Int): Calc[T] = map => implicitly[Numeric[T]].fromInt(value)

  override def variable(name: String): Calc[T] = map => map(name)

  override def times(x: Calc[T], y: Calc[T]): Calc[T] = map => x(map) * y(map)

  override def plus(x: Calc[T], y: Calc[T]): Calc[T] = map => x(map) + y(map)
}
