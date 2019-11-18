package step_7_2

import scala.io.StdIn.readLine

/*
Дан трейт

trait StringProcessor {
  def process(input: String): String
}

Напишите несколько его реализаций:
1. tokenDeleter - в методе process обрабатывает строку, удаляя из неё все знаки препинания.
2. toLowerConvertor - заменяет все прописные буквы на строчные.
3. shortener - если строка имеет размер больше 20 символов, он оставляет первые 20 и добавляет к ней "...".
Реализовав их, считайте из стандартного потока ввода строку и примените к ней все написанные преобразования вызовом
.process у каждого из них. Порядок: перевести в нижний регистр, удалить знаки препинания, сократить

Sample Input:
This is a Wonderful Test!

Sample Output:
this is a wonderful ...
*/

object Main {
  def main(args: Array[String]): Unit = {
    val tokenDeleter = new StringProcessor {
      override def process(input: String): String = for (chr <- input if chr.isLetterOrDigit || chr.isSpaceChar) yield chr
    }

    val shortener = new StringProcessor {
      override def process(input: String): String = input match {
        case str if str.length > 20 => str.substring(0, 20).concat("...")
        case str => str
      }
    }

    val toLowerConvertor = new StringProcessor {
      override def process(input: String): String = input.toLowerCase
    }

    val s = readLine()
    println(shortener.process(tokenDeleter.process(toLowerConvertor.process(s))))
  }
}
