package step_8_2_2

class Pair[+T](val first: T, val second: T) {
  def replaceFirst[S >: T](newValue: S): Pair[S] = {
    new Pair(newValue, second)
  }
}
