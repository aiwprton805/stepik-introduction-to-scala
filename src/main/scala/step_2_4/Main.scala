package step_2_4

import step_2_4.Main.Config.{name => prefix}

/*
Метод greeting задан следующим образом:

def greeting(name: String) {
  println(prefix + name)
}

Он должен брать prefix из текущей зоны видимости, конкатенировать с переданным именем и выводить приветствие на экран.
В объекте Config требуемое значение prefix лежит в поле name.
Задание: Допишите код так, чтобы метод greeting выполнился корректно.
Примечание: метод greeting и объект Config находятся в текущей области видимости.

Sample Input:
Hello,

Sample Output:
Hello, Oleg
*/

object Main extends App {

  object Config {
    val name = "Hello, "
  }

  def greeting(name: String): Unit = {
    println(prefix + name)
  }

  val name = "Oleg"
  greeting(name)
}
