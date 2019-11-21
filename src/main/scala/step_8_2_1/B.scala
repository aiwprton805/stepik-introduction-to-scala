package step_8_2_1

class B(override val value: String) extends A(value)

object B {
  def apply(value: String): B = new B(value)
}
