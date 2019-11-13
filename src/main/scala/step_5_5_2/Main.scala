package step_5_5_2

/*
Дана некоторая функция bar: Int => Option[Int] и опциональное значение x: Option[Int]. Примените bar к содержимому x
так, чтобы получилось Option[Int].
Считывать ничего не нужно, bar и x уже проинициализированы. Напечатайте результат. В тестах указано значение x.

Sample Input 1:
Some(10)

Sample Output 1:
Some(6)

Sample Input 2:
None

Sample Output 2:
None
*/

object Main extends App {
  def bar(n: Int): Option[Int] = {
    Option.apply(n - 4)
  }

  //val x = Option.apply(10)
  val x = Option.empty
  println(x.flatMap(bar))
}
