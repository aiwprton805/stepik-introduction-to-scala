package step_8_3

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  override type Item = Boolean

  override def length: Int = 64

  override def get(index: Int): Item = (values & (1L << index)) != 0L

  override def set(index: Int, item: Item): Vect.Aux[Item] = {
    if (item)
      BoolVect64(values & (~(1L << index)) | (1L << index))
    else
      BoolVect64(values & (~(1L << index)))
  }
}
