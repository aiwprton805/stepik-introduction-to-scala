package step_8_4_2

class StringOrderExpr extends Expr[Print] {
  override def literalInt(value: Int): Print = Print(value.toString, 4, isLit = true)

  override def variable(name: String): Print = Print(name.toUpperCase, 5)

  override def times(x: Print, y: Print): Print = {
    if (x.isLit)
      Print(x.print(3) + y.print(3), 3)
    else
      Print(x.print(3) + "*" + y.print(3), 3)
  }

  override def plus(x: Print, y: Print): Print = Print(x.print(2) + "+" + y.print(2), 2)

  override def minus(x: Print, y: Print): Print = Print(x.print(2) + "-" + y.print(2), 2)

  override def negate(x: Print): Print = Print("-" + x.print(1), 1)
}
