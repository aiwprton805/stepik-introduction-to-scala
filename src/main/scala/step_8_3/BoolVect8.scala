package step_8_3

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  override type Item = Boolean

  override def length: Int = 8

  override def get(index: Int): Item = ((values & (1 << index)) & 0xFF) != 0

  override def set(index: Int, item: Item): Vect.Aux[Item] = {
    if (item)
      BoolVect8((values & ((~(1 << index)) & 0xFF) | (1 << index) & 0xFF).toByte)
    else
      BoolVect8((values & ((~(1 << index)) & 0xFF)).toByte)
  }
}
