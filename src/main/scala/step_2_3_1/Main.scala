package step_2_3_1

import scala.io.StdIn.readInt

/*
Напишите программу, которая считывает построчно два целых числа и считает их разницу.
Подсказка: для считывания целого числа из строки во входном потоке можно воспользоваться методом readInt() объекта
StdIn.

Sample Input:
8
11

Sample Output:
-3
*/

object Main extends App {
  val a = readInt()
  val b = readInt()
  println(a - b)
}
