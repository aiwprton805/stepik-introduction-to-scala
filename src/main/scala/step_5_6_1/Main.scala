package step_5_6_1

/*
Правильной называется дробь, у которой модуль числителя  меньше модуля знаменателя. Будем представлять дробь парой
(числитель, знаменатель).
Реализуйте операцию деления divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)], возвращающую результат
деления p на q или текст ошибки. Проверьте корректность входных данных, если входные дроби неправильные, верните ошибку
Left("Invalid input"). Если делитель нулевой, верните Left("Zero divisor"). Если в результате получилась неправильная
дробь, ошибка Left("Improper result").
Сократите результат до простой дроби. Воспользуйтесь алгоритмом Евклида, разобранным в модуле про кортежи, или методом
BigInt.gcd.
Ничего считывать и выводить в консоль не нужно, просто реализуйте функцию.
*/

object Main extends App {
  def divide(p: (Int, Int))( q: (Int, Int)): Either[String, (Int, Int)] = {
    if (q._1 == 0 || q._2 == 0 || p._2 == 0)
      return Left("Zero divisor")
    if (Math.abs(p._1) >= Math.abs(p._2) || Math.abs(q._1) >= Math.abs(q._2))
      return Left("Invalid input")
    val s = (p._1 * q._2, p._2 * q._1)
    if (Math.abs(s._1) >= Math.abs(s._2))
      return Left("Improper result")
    val d = BigInt(s._1).gcd(BigInt(s._2)).toInt
    Right((s._1 / d, s._2 / d))
  }
}
