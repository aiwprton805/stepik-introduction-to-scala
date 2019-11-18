package step_7_3_2

import scala.io.StdIn.readLine

/*
Объекты-компаньоны, в которых реализован метод unapply называются extractor objects. Этот метод позволяет "разбирать"
объекты, получая аргументы, из которых он был создан. Например, в кейс-классах, с которыми вы уже немного сталкивались,
он реализован по умолчанию. Это позволяет записывать подобные конструкции pattern matching для кейс-классов:

case class Dog(name: String, ownerName: String)
  val rex = Dog("Rex", "Josh")
  val match {
    case Dog(name, ownerName) => println(s"My owner is $ownerName")
    case _ => println("I am not a dog")
  }

Ваша задача - реализовать метод unapply у объекта FacedString﻿. Считать из потока ввода строку, сделать паттерн матчинг с
ней, который определит, могла ли она быть результатом некоторого вызова apply. Если получилось выделить строку, от
которой она была сконструирована, вывести эту строку на экран, если нет - вывести "Could not recognize string".
Почитать про extractor objects можно тут (https://docs.scala-lang.org/ru/tour/extractor-objects.html).

Sample Input 1:
*_*test*_*

Sample Output 1:
test

Sample Input 2:
*_*test

Sample Output 2:
Could not recognize string
*/

object Main {

  object FacedString {
    def apply(input: String) = s"*_*$input*_*"

    def unapply(arg: String): Option[String] = {
      if (arg.length >= 6 && arg.startsWith("*_*") && arg.endsWith("*_*"))
        Some(arg.substring(3, arg.length - 3))
      else
        None
    }
  }

  def main(args: Array[String]): Unit = {
    val str = readLine() match {
      case FacedString(input) => input
      case _ => "Could not recognize string"
    }
    println(str)
  }
}
