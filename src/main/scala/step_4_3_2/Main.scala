package step_4_3_2

/*
Задание: напишите обобщенный метод middle возвращающий средний элемент из любого экземпляра Iterable[T] Если элементов
четное число, необходимо выбрать элемент с бОльшим порядковым номером.

Подсказка. Один из возможных вариантов решения:
1 Узнать размер последовательности: метод data.size: Int
2 Разбить последовательность на две по индексу: data.splitAt(n: Int): (Iterable[T], Iterable[T])
3 Из полученного кортежа взять правую последовательность (поле tuple._2: Iterable[T])
4 Взять первый элемент последовательности (iterable.head: T)
*/

object Main extends App {
  def middle[T](data: Iterable[T]): T = {
    data.splitAt(data.size / 2)._2.head
  }

  require(middle("Scala") == 'a')
  require(middle(Seq(1, 7, 5, 9)) == 5)
}
