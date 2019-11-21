package step_8_4_2

final case class Print(s: String, priority: Int, isLit: Boolean = false) {
  def print(outer: Int = 0): String = if (outer <= priority) s else s"($s)"
}
