package step_6_1_1

import scala.util.Random

/*
Получив некоторый произвольный список нулей и единиц, разделите их на два списка.
Результат выведите через запятую, каждый в отдельную строку, первыми выводятся нули.

Sample Input:
0 1 1 0 1 0 0 1 1 1 0 1 0

Sample Output:
0,0,0,0,0,0
1,1,1,1,1,1,1
*/

object Main {
  def main(args: Array[String]): Unit = {
    val ints: List[Int] = List.fill(10)(Random.nextInt(2))
    println(ints.filter(e => e == 0).mkString(","))
    println(ints.filter(e => e == 1).mkString(","))
  }
}
