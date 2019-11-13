package step_5_5_1

/*
Метод List.find(p: Char => Boolean): Option[Char] пытается найти первый символ, удовлетворяющий предикату p. Напишите
функцию foo(list: List[Int]): Int, которая находит в списке list первое число, которое делится на 3, и домножает его на
2. Если таких чисел нет, функция должна вернуть 0.
Пользуйтесь только find, анонимными функциями и методами Option.
Ничего считывать и выводить в консоль не нужно. Просто реализуйте функцию.

foo(List(1, 2, 3, 4, 5, 6)) == 6

Sample Input:
1 2 3 4 5 6

Sample Output:
6
*/

object Main extends App {
  def foo(list: List[Int]): Int = {
    list.find(e => e % 3 == 0).map(e => e * 2).getOrElse(0)
  }
}
