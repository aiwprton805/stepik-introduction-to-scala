package step_4_3_1

import scala.annotation.tailrec

/*
Реализуйте эффективное вычисление числа Фибоначчи, используя хвостовую рекурсию.
В n лежит порядковый номер числа Фибоначчи, требуется вывести его значение.

Sample Input:
100

Sample Output:
354224848179261915075
*/

object Main extends App {
  @tailrec
  def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
    if (n == currentNumber){
      f2
    }else{
      fibs(n, currentNumber + 1, f2, f1 + f2)
    }
  }
}
