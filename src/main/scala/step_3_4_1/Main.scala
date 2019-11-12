package step_3_4_1

import scala.io.StdIn.readLine

/*
Cчитайте из консоли два числа: startIndex и endIndex. Считайте строку str.
Напечатайте в ответ входную строку, обратив порядок символов от startIndex до endIndex ﻿включительно.

Sample Input:
2 6
foobarbaz

Sample Output:
fobraboaz
*/

object Main {
  def main(args: Array[String]): Unit = {

    val indexes = readLine().split(" ")
    val startIndex = indexes(0).toInt
    val endIndex = indexes(1).toInt
    val str = readLine()
    val result = str.substring(0, startIndex) + str.substring(startIndex, endIndex + 1).reverse +
      str.substring(endIndex + 1)
    println(result)
  }
}
