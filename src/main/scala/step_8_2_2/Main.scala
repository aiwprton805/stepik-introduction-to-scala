package step_8_2_2

/*
Исправьте определение класса Pair, чтобы он стал ковариантным.

Метод printNames принимает на вход пары с объектами типа Person и печатает их имена. Однако нам хочется на вход этому
методу передавать также и Student. Для этого нужна ковариантность пар: Pair[Student] <: Pair[Person].

Подсказка: в определении Pair в методе replaceFirst тип T стоит в контрвариантной позиции, что мешает быть Pair
ковариантным по T.

Sample Input:
Pavel Oleg

Sample Output:
1: Oliver  2: Oleg
*/

object Main extends App {
  def printNames(pair: Pair[Person]): Unit = {
    println("1: " + pair.first.name + " 2: " + pair.second.name)
  }

  val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
  printNames(pair.replaceFirst(new Person("Oliver")))
}
