package step_8_3

trait Vect extends Any {
  type Item

  def length: Int

  def get(index: Int): Item

  def set(index: Int, item: Item): Vect.Aux[Item]
}

object Vect {
  type Aux[I] = Vect {type Item = I}
}
