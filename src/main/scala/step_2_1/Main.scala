package step_2_1

import scala.io.StdIn.readLine

/*
Считайте со входного потока имя (строку) и напечатайте "Hi, *считанное имя*!" Все нужные библиотеки уже подключены,
просто напишите решение!

Sample Input:
Oleg

Sample Output:
Hi, Oleg!
*/

object Main {
  def main(args: Array[String]): Unit = {
    val name = readLine()
    println("Hi, " + name + "!")
  }
}
