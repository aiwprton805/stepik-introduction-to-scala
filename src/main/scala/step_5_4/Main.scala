package step_5_4

/*
Напишите функцию swap3(tuple: (Int, Int, Int)): (Int, Int, Int), возвращающую кортеж с элементами в обратном порядке.
Ничего считывать и выводить в консоль не нужно, просто реализуйте функцию.

swap3((1, 2, 3)) == (3, 2, 1)
*/

object Main extends App {
  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = {
    (tuple._3, tuple._2, tuple._1)
  }
}
