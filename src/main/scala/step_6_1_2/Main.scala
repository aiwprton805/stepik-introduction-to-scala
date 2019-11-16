package step_6_1_2

import scala.io.StdIn.{readInt, readLine}

/*
В данной задаче необходимо реализовать алгоритм нахождения k-ой порядковой статистики, матожидание времени работы
которого составляет O(n). Для этого реализуйте метод kOrder (его сигнатура в шаблоне).
На вход в первой строке подаётся k ﻿- номер порядковой статистики, которую надо найти. Во второй строке - элементы
набора.

Sample Input 1:
4
3 8 1 12 23

Sample Output 1:
12

Sample Input 2:
3
4 7 6 5 12 9 5

Sample Output 2:
5
*/

object Main {
  def main(args: Array[String]): Unit = {
    val n: Int = readInt()
    val list: List[Int] = readLine().split(" ").map(_.toInt).toList

    def kOrder(list: List[Int], k: Int): Int = list match {
      case head :: tail =>
        val left = tail.filter(_ <= head)
        left.length match {
          case len if len + 1 == k => head
          case len if len + 1 > k => kOrder(left, k)
          case len if len + 1 < k => kOrder(tail.filter(_ > head), k - len - 1)
        }
      case Nil => 0
    }

    println(kOrder(list, n))
  }
}
