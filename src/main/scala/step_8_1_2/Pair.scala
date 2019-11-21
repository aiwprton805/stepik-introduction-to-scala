package step_8_1_2

/*
Исправьте определение класса Pair так, чтобы можно было создавать пары из различных типов (например, Int или String). В
этой задаче элементы пары имеют одинаковый тип.
Метод smaller должен возвращать наименьшее значение из пары.
Подсказка: трэйт Ordered[A] определяет оператор сравнения, что позволяет удобно сравнивать различные элементы. Например,
BigInt <: Ordered[BigInt], поэтому можно писать: BigInt(1) < BigInt(2) == true.
Дополнительная информация: подробности про View Bounds
https://stackoverflow.com/questions/4465948/what-are-scala-context-and-view-bounds

Sample Input:
8 11

Sample Output:
8
*/

case class Pair[T: Ordering](first: T, second: T) {
  def smaller(implicit ord: Ordering[T]): T = {
    if (ord.lt(first, second))
      first
    else
      second
  }
}
