package step_2_3_2

import scala.io.StdIn.readInt

/*
Напишите программу, которая считает произведение трех целых чисел.

Sample Input:
2
11
3

Sample Output:
66
*/

object Main extends App {
  val a = readInt()
  val b = readInt()
  val c = readInt()
  println(a * b * c)
}
