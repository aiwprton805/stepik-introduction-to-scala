package step_7_5_1

trait Animal {
  val sound: String

  def voice: Unit = println("voice: " + sound)
}
