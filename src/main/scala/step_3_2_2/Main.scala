package step_3_2_2

import scala.io.StdIn.readInt

/*
Посчитайте число единиц в битовой записи числа, считанного с клавиатуры, и выведите на экран.
Справка: возможно, Вам понадобится цикл. Цикл for в Scala выглядит так:

for (i <- 1 to 10) {
// any code
}

Цикл while ﻿вот так:

while(condition) {
// any code
}

Sample Input:
3

Sample Output:
2
*/

object Main {
  def main(args: Array[String]): Unit = {
    var n = readInt()
    var count = 0
    while(n != 0){
      if((n & 1) == 1) count += 1
      n = n >> 1
    }
    println(count)
  }
}
