package step_4_2

/*
В объекте LessonData определен метод searchInArray, который находит в массиве элементы, удовлетворяющие заданному
условию:

object LessonData{
  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)

  }
}

Задание: исправьте определение функции searchOdd: List[Int] => List[Int] так, чтобы программа стала компилироваться.
Добавлять вывод на экран не нужно.
Пример использования:

println(searchOdd(List(8,11,12))) // List(11)
*/

object Main extends App {
  object LessonData {
    def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
      array.filter(cond)
    }
  }

  val searchOdd: List[Int] => List[Int] = LessonData.searchInArray(_ % 2 == 1, _)
}
