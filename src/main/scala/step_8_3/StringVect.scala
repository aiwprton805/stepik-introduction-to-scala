package step_8_3

final case class StringVect(str: String) extends AnyVal with Vect {
  override type Item = Char

  override def length: Int = str.length

  override def get(index: Int): Item = str.charAt(index)

  override def set(index: Int, item: Item): Vect.Aux[Item] = StringVect(str.updated(index, item))
}
