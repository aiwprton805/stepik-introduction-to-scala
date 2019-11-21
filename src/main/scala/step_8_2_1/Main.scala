package step_8_2_1

/*
Заданы тип A и его подтип B, а также функции, которые умеют распечатывать их поле value:

val printA = FunctionPrint[A]("A-value:")
val printB = FunctionPrint[B]("B-value:")

class FunctionPrint[T <: A](prefix: String) {
  def apply(t: T): Unit = println(prefix + " " + t.value)
}

Также существует важный метод methodPrint, который принимает на вход экземпляр типа B и функцию, которая умеет
распечатывать его значение. methodPrint(printB, objB) компилируется без проблем, однако, иногда нужно задействовать
функцию printA.
Действительно: B <: A, поэтому любая f: A => Any умеет работать и с B. Но есть один нюанс: в текущей реализации printA
инвариантна к printB (не является ни родителем, ни наследником), поэтому эту функцию нельзя передать в метод
methodPrint.
Задание: исправьте компиляцию кода. В конце будет вызываться:

methodPrint(printA, objB)

Подсказка: этот пример демонстрирует, почему функции в Scala контринвариантны по аргументам.

Sample Input:
A-value:
B-value:

Sample Output:
B-value: It is a B.value
A-value: It is a B.value
*/

object Main extends App {
  val objB = B("It is a B.value")
  val objA = A("It is a A.value")

  def methodPrint(f: FunctionPrint[B], obj: B): Unit = {
    f(obj)
  }

  val printA = FunctionPrint[A]("A-value")
  val printB = FunctionPrint[B]("B-value")

  methodPrint(printA, objB)
}
