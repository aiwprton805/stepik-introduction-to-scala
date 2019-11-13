package step_5_6_2

/*
Напишите функцию flatten(options: List[Option[Int]]): List[Int], возвращающую список из всех не-None элементов списка.
Пользуйтесь частичными функциями.
Ничего считывать и выводить не нужно, просто реализуйте функцию
*/

object Main extends App {
  def flatten(options: List[Option[Int]]): List[Int] = {
    options.collect{case e if e.nonEmpty => e.get}
  }
}
