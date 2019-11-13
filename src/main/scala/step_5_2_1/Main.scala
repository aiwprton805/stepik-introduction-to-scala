package step_5_2_1

/*
Сase-класс Pet(name: String, says: String) описывает питомца, с именем name, издающего звук says.
Известно, что все, кто говорит "meow" или "nya" - кошки, все, кого зовут "Rex" - собаки, а цифры "0" или "1" (обратите
внимание, что нужно проверять наличие символов, а не целочисленных типов) в строке says есть только у роботов. (Кошек и
роботов не могут звать "Rex", собаки не мяукают)
Используя pattern-matching, определите вид питомца в переменной pet. Выведите "cat" для кошек, "dog" для собак, "robot"
для роботов и "unknown" иначе.

case class Pet(name: String, says: String)
val pet = Pet(...)

// Ваш код
val kind = pet match {
// Напишите нужные case
}
println(kind)

Считывать ничего не нужно, переменная pet уже проинициализирована.
*/

object Main extends App {
  case class Pet(name: String, says: String)

  val pet = Pet("r2d2", "01meow10")

  val regex = "([\\w]*[01]+[\\w]*)".r

  val kind = pet match {
    case Pet(_, "meow") => "cat"
    case Pet(_, "nya") => "cat"
    case Pet("Rex", _) => "dog"
    case Pet(_, regex(_)) => "robot"
    case _ => "unknown"
  }
  println(kind)
}
