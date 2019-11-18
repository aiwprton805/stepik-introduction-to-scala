package step_7_5_1

class Fish extends Animal {
  override val sound: String = "Fishes are silent!"

  override def voice: Unit = println(sound)
}
