package step_8_3

import scala.annotation.tailrec

/*
Aux - паттерн может быть использован для создания обобщённых типов без использования тайп-параметров. Данная задача -
пример такого использования.
Реализуем компактные представления массива Char и массивов Boolean (для Boolean массивы не больше 8 и 64 элементов) в
памяти.
Заведём вспомогательный трейт:

trait Vect extends Any{
  type Item
  def length: Int
  def get(index: Int): Item
  def set(index: Int, item: Item): Aux[Item]
}

object Vect {
  type Aux[I] = Vect { type Item = I }
}

Реализуем оптимальный массив Char:

final case class StringVect(str: String) extends  AnyVal with Vect {
  type Item = Char
  def length                                             = str.length
  def get(index: Int)                                     = str.charAt(index)
  def set(index: Int, item: Char): Aux[Char] = StringVect(str.updated(index, item))
}

Ваша задача - реализовать недостающие метода интерфейса Vect у BoolVect64 и BoolVect8:

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 64
  def get(index: Int) = ???
  def set(index: Int, item: Boolean) = ???
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length = 8
  def get(index: Int) = ???
  def set(index: Int, item: Boolean) = ???
}

Обратите внимание, что разряды в двоичной записи числа возрастают справа налево. Однако BoolVect8(1) должен
представляться в виде List(true, false, false, false, false, false, false, false).

Подсказка: используйте битовые операции.
Также реализуйте вспомогательный метод toList, возвращающий список элементов переданного массива:

def toList(vect: Vect): List[vect.Item] = ???

Ничего считывать или выводить не надо. Просто реализуйте недостающие методы.
*/

object Main extends App {
  def toList(vect: Vect): List[vect.Item] = {
    @tailrec
    def toList(list: List[vect.Item], index: Int): List[vect.Item] = {
      if (index == vect.length)
        list
      else
        toList(list :+ vect.get(index), index + 1)
    }

    toList(List.empty, 0)
  }
}
