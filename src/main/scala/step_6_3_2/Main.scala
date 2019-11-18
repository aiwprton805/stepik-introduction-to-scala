package step_6_3_2

import scala.util.Random

/*
Вам даны четыре микросервиса

def service1: Either[String, Double]
def service2(res1: Double): Either[String, Int]
def service3: String
def service4(res1: Double, res2: Int, res3: String): Either[String, String]

Первый, второй и четвертый возвращают Either с ошибкой слева или результатом справа. service2 должен получить на вход
результат работы первого сервиса, а четвертый - трех предыдущих. Используя только for-comprehension реализуйте функцию
result, которая возвращает результат работы четвертого сервиса.
*/

object Main extends App {
  val rnd: Random.type = Random

  def service1: Either[String, Double] = {
    if (rnd.nextInt(2) == 0)
      Left("Error service 1")
    else
      Right(0.5)
  }

  def service2(res1: Double): Either[String, Int] = {
    if (rnd.nextInt(2) == 0)
      Left("Error service 2")
    else
      Right(10 + res1.toInt)
  }

  def service3: String = "Service 3"

  def service4(res1: Double, res2: Int, res3: String): Either[String, String] = {
    if (rnd.nextInt(2) == 0)
      Left("Error service 4")
    else
      Right(s"Service 4 have res1: $res1 res2: $res2 res3: $res3")
  }

  def result = for {
    s1 <- service1
    s2 <- service2(s1)
    s3 = service3
    s4 <- service4(s1, s2, s3)
  } yield s4

  println(result)
}
