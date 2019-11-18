package step_7_3_1

import scala.annotation.tailrec

/*
Дан список координат в трёхмерном пространстве. Вам нужно написать класс Point, который будет описывать точку в
трёхмерном пространстве и объект-компаньон со следующими функциями:
- apply - фабрика, принимает три координаты и возвращает экземпляр типа Point;
- average - принимает List[Point] и вычисляет усреднённую точку между всеми координатами, либо точку с началом осей
  координат, если её невозможно рассчитать;
- show - принимает Point и превращает её в строку, состоящую из координат разделённых через пробел.
Для каждой строки будет вызвана функция apply, затем для всех точек будет вызвана функция average. На выход будет передан результат функции show, примененный к усреднённой точке.

Sample Input 1:
1 2.5 4
4 3.5 6

Sample Output 1:
2.5 3.0 5.0

Sample Input 2:
1 2 3
4 5 6
7 8 9

Sample Output 2:
4.0 5.0 6.0
*/

class Point(val x: Double, val y: Double, val z: Double) {}

object Point {
  def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)

  def average(points: List[Point]): Point = {
    @tailrec
    def avg(points: List[Point], accPoint: Point, count: Int): Point = points match {
      case head :: tail => avg(tail, apply(accPoint.x + head.x, accPoint.y + head.y, accPoint.z + head.z), count + 1)
      case _ if count == 0 => accPoint
      case _ => apply(accPoint.x / count, accPoint.y / count, accPoint.z / count)
    }

    avg(points, apply(0.0, 0.0, 0.0), 0)
  }

  def show(point: Point): String = s"${point.x} ${point.y} ${point.z}"
}
