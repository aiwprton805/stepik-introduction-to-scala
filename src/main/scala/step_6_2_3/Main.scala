package step_6_2_3

/*
Некоторые генетические алгоритмы для генерации новых хромосом из старых используют приём под названием кроссинговер.

Будем представлять хромосому с генами [xxxxx]   в виде списка List('x', 'x', 'x', 'x', 'x'). Тогда суть приёма
заключается в следующем:
Берутся две хромосомы одинаковой длины, например [xxxxx] и [yyyyy]. Списки для них будут выглядеть так:

List('x', 'x', 'x', 'x', 'x')
List('y', 'y', 'y', 'y', 'y')

Выбираются так называемые `точки кроссинговера`. В нашем случае это некоторые индексы в диапазоне [1, длина списка генов
хромосомы]. Пусть выбраны индексы 1 и 3. Для  каждого индекса, по возрастанию, хромосомы обмениваются своими частями,
стоящими после этого индекса. В  нашем случае после кроссинговера по индексу 1:

List('x', 'y', 'y', 'y', 'y')
List('y', 'x', 'x', 'x', 'x')

А после дальнейшего кроссинговера по индексу 3:

List('x', 'y', 'y', 'x', 'x')
List('y', 'x', 'x', 'y', 'y')

Ничего считывать из ﻿консоли не надо. ﻿Вам даны:

val points: List[Int] = Lesson.points // точки кроссинговера
val chr1: List[Char] = Lesson.chr1 // первая хромосома
val chr2: List[Char] = Lesson.chr2 // вторая хромосома

﻿Выведите результат хромосомы после кроссинговера, сначала первую, затем вторую. Без пробелов и знаков препинания.

Sample Input 1:
1 3
xxxxx
yyyyy

Sample Output 1:
xyyxx
yxxyy

Sample Input 2:
2 4 5
aaaaaaa
ddddddd

Sample Output 2:
aaddadd
ddaadaa
*/

object Main {
  def main(args: Array[String]): Unit = {
    val points = List(1, 3)
    val chr1 = List('x', 'x', 'x', 'x', 'x')
    val chr2 = List('y', 'y', 'y', 'y', 'y')

    def cross(indexes: List[Int], list1: List[Char], list2: List[Char]): (List[Char], List[Char]) = {
      if (indexes.isEmpty)
        (list1, list2)
      else
        cross(indexes.tail,
          list1.patch(indexes.head, list2.drop(indexes.head), list1.length - indexes.head),
          list2.patch(indexes.head, list1.drop(indexes.head), list2.length - indexes.head))
    }

    val crossover = cross(points, chr1, chr2)
    println(crossover._1.mkString)
    println(crossover._2.mkString)
  }
}
