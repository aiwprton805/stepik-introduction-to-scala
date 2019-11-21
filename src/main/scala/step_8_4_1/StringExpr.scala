package step_8_4_1

class StringExpr extends Expr[String] {
  override def literalInt(value: Int): String = s"$value"

  override def variable(name: String): String = s"${name.toUpperCase}"

  override def times(x: String, y: String): String = s"($x)*($y)"

  override def plus(x: String, y: String): String = s"($x)+($y)"

  override def minus(x: String, y: String): String = s"($x)-($y)"

  override def negate(x: String): String = s"-($x)"
}
