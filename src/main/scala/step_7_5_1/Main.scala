package step_7_5_1

/*
Имеется трейт "Животное", в котором реализован метод "подать голос", а также поле "звук", который животное издает.

trait Animal {
  val sound: String
  def voice: Unit = println("voice: " + sound)
}

Задание: реализуйте классы "Кошка", "Собака" и "Рыба". В последнем случае метод voice должен печатать на экран фразу
"Fishes are silent!". Программа будет запускаться следующим образом:

object Main extends App {
  val animals = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice)
}

Sample Input:

Sample Output:
voice: Meow!
voice: Woof!
Fishes are silent!
*/

object Main extends App {
  val animals = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice)
}
