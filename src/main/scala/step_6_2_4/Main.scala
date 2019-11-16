package step_6_2_4

import scala.io.StdIn.{readLine, readInt}
import Naval.{Point, Field, Ship, Fleet, Game}
import Lesson.field

/*
Многие играли в игру  Морской бой (https://goo.gl/SMWykY). В игре используется квадратное поле клеток, на которое перед
началом игры каждый из игроков расставляет свои корабли.
Представим клетку корабля как пару координат этой клетки на поле. С ключевым словом type вы познакомитесь в скором
времени, сейчас достаточно знать, что оно позволяет задать псевдоним для некоторого типа, который мы не хотим
прописывать каждый раз, когда он встречается.

type Point = (Int, Int)

Игровое поле может быть представлено как двумерный массив, хранящий для каждой ячейки булево значение, о том стоит ли на
этой клетке корабль:

type Field = Vector[Vector[Boolean]]

Проинтерпретируем корабль как список точек:

type Ship = List[Point]

А множество всех кораблей на поле как ассоциативный массив. По строковому ключу (имени корабля) находится список точек
корабля.

type Fleet = Map[String, Ship]

Игра описывается её игровым полем и списком кораблей:

type Game = (Field, Fleet)

Обращаем внимание на то, что все коллекции иммутабельны.
Данные типы объявлены в объекте Naval и уже импортированы в шаблоне.

Входные данные
На вход в первой строке вам даётся число кораблей, которые игрок хочет добавить на поле.
Далее мы задаем положения кораблей: первая строка - название корабля (одним словом) и число клеток, занимаемых им,
последующие строки - координаты его клеток, по одной клетке (соответственно, по две координаты) на строку.

Задание
Корабли добавляются на поле field (квадратное поле размера 10 на 10 клеток, задано заранее, булево значение во всех его
клетках проинициализировано как false, координаты нумеруются с нуля) в такой же очередности, как они подаются на вход.
Необходимо проверять условия:
1. Корабль не имеет изгибов (ширина корабля всегда единица).
2. Длина корабля не больше четырёх.
3. Корабли могут примыкать к границам поля, но не могут касаться друг друга, даже углами своих клеток.

Выведите имена кораблей, которые получилось расставить на поле.
Для удобства предлагаем реализовать методы, сигнатуры которых написаны в шаблоне.

Sample Input 1:
2
MillenniumFalcon 4
2 5
3 5
4 5
5 5
Varyag 1
9 9

Sample Output 1:
MillenniumFalcon
Varyag

Sample Input 2:
3
BlackPearl 3
1 6
1 7
1 8
MillenniumFalcon 4
2 5
3 5
4 5
5 5
Varyag 1
9 9

Sample Output 2:
BlackPearl
Varyag
*/

object Main {
  def main(args: Array[String]): Unit = {
    val count = readInt()
    inputShips(count, (field, Map.empty))
  }

  def validateShip(ship: Ship): Boolean = {
    if (ship.length > 4 || ship.length < 1)
      false
    else
      ship.forall(p => p._1 >= 0 && p._1 <= 9 && p._2 >= 0 && p._2 <= 9) &&
        (ship == List.tabulate(ship.length)(i => (ship.head._1, ship.head._2 + i)) ||
          ship == List.tabulate(ship.length)(i => (ship.head._1 + i, ship.head._2)))
  }

  def validatePosition(ship: Ship, field: Field): Boolean = {
    !ship
      .flatMap(p => List(
        (p._1 - 1, p._2 - 1), (p._1 - 1, p._2), (p._1 - 1, p._2 + 1),
        (p._1, p._2 - 1), (p._1, p._2), (p._1, p._2 + 1),
        (p._1 + 1, p._2 - 1), (p._1 + 1, p._2), (p._1 + 1, p._2 + 1)))
      .distinct
      .filter(p => p._1 >= 0 && p._1 <= 9 && p._2 >= 0 && p._2 <= 9)
      .exists(p => field(p._1)(p._2))
  }

  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
    fleet + (name -> ship)
  }

  def markUsedCells(field: Field, ship: Ship): Field = ship match {
    case Nil => field
    case head :: tail => markUsedCells(field.updated(head._1, field(head._1).updated(head._2, true)), tail)
  }

  def tryAddShip(game: Game, name: String, ship: Ship): Game = {
    if (!validateShip(ship) || !validatePosition(ship, game._1))
      game
    else
      (markUsedCells(game._1, ship), enrichFleet(game._2, name, ship))
  }

  def inputShips(n: Int, game: Game): Game = {
    if (n == 0)
      return game
    val shipFeatures = readLine().split(" ")
    val ship = List.tabulate(shipFeatures(1).toInt)(_ => readLine().split(" "))
      .map { case Array(i, j) => (i.toInt, j.toInt) }
    val newGame = tryAddShip(game, shipFeatures(0), ship)
    if (newGame != game)
      println(shipFeatures(0))
    inputShips(n - 1, newGame)
  }
}
