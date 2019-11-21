package step_8_1_1

/*
Реализуйте неизменяемый класс Pair с методом swap, возвращающим пару, где компоненты поменяны местами.
*/

final case class Pair[T, S](first: T, second: S) {
  def swap: Pair[S, T] = new Pair[S, T](second, first)
}
