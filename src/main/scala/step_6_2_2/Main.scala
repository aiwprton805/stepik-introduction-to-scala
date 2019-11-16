package step_6_2_2

import scala.io.StdIn.readLine

/*
Считайте числа из консоли до слова END.
С полученным списком необходимо выполнить:
1. выбрать каждый второй элемент
2. каждый выбранный элемент умножить на 2
3. вывести в консоль сумму элементов полученного списка
Рекомендация: для считывания в список можно использовать Stream (LazyList)

Sample Input:
28
40
9
61
END
23
12
34

Sample Output:
202
*/

object Main {
  def main(args: Array[String]): Unit = {
    println(LazyList.continually(readLine).takeWhile(_ != "END").grouped(2).map {
      case lst if lst.length == 2 => lst.last.toInt * 2
      case _ => 0
    }.sum)
  }
}
