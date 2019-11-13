package step_5_2_2

/*
На вход программе подается имя пользователя, email и список его коммитов, возможно пустой (коммит - одно из ключевых
понятий системы контроля версий Git - https://ru.wikipedia.org/wiki/Git. В данном контексте - это просто строка).
Считанные построчно данные лежат в списке input. После имени мог стоять как пробел, так и перенос строки, каждый коммит
был в отдельной строчке. Другими словами, первые два элемента списка это либо имя и электронная почта, либо имя с почтой
через пробел и первый коммит. Используя pattern-matching и регулярные выражения напечатайте через пробел имя
пользователя и домен электронной почты (все, что стоит после собаки). Для некорректных данных напачатайте "invalid".
Подсказка: регулярное выражение для имени [a-zA-Z]+, для электронного адреса \\w+@\\w+\.\\w+ . Для извлечения параметров
используйте круглые скобки, чтобы объявить группы в нужных местах.
Считывать ничего не нужно, переменная input уже проинициализирована.

Sample Input 1:
oleg
oleg@email.com
7bdaf0a1be3
a8af118b1a2
28d74b7a3fe

Sample Output 1:
oleg email.com

Sample Input 2:
oleg oleg@email.com
7bdaf0a1be3
a8af118b1a2
28d74b7a3fe

Sample Output 2:
oleg email.com
*/

object Main extends App {
  val input = List("oleg", "oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")
  //val input = List("oleg oleg@email.com", "7bdaf0a1be3", "a8af118b1a2", "28d74b7a3fe")

  val nameRegex = "([a-zA-Z]+)".r
  val mailRegex = "\\w+@(\\w+.\\w+)".r
  val contactRegex = "([a-zA-Z]+) \\w+@(\\w+.\\w+)".r

  val result = input match {
    case List(nameRegex(name), mailRegex(mail), rest@_*) => s"$name $mail"
    case List(contactRegex(name, mail), rest@_*) => s"$name $mail"
    case _ => "invalid"
  }
  println(result)
}
