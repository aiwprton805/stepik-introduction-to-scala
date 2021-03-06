package step_4_1_1

/*
Раскомментируйте строчку в методе ﻿fibs и допишите код; а затем исправьте ошибку компиляции.
P.S. Данная реализация вычисления чисел Фибоначчи крайне неоптимальна (имеет временную сложность алгоритма до Θ(φ^n))
*/

object Main extends App {
  def fibs(num: Int): Int = {
    if (num == 1) 1
    else if (num == 2) 1
    else fibs(num - 2) + fibs(num - 1)
  }
}
