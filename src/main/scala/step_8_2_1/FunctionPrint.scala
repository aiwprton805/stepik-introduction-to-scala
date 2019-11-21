package step_8_2_1

class FunctionPrint[-T <: A](prefix: String) {
  def apply(t: T): Unit = println(prefix + " " + t.value)
}

object FunctionPrint {
  def apply[T <: A](prefix: String): FunctionPrint[T] = new FunctionPrint[T](prefix)
}
