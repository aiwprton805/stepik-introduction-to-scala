package step_7_1

/*
Ваша задача - спроектировать и реализовать класс официанта. Официант умеет принимать блюдо в заказ и в конце повторять,
что было заказано. Также он вежлив и представляется.
Требования:
- имя класса Waiter
- метод для заказа блюда giveMe, принимает название блюда
- метод complete, возвращает список того, что было заказано
- при своем появлении официант здоровается с гостем
- необходимо, чтобы была возможна следующая запись

val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()

Sample Input:
иван борщ хлеб

Sample Output:
My name иван
Order: борщ,хлеб
*/

class Waiter(name: String, val dishList: List[String]) {
  if (!name.isEmpty)
    println(s"My name $name")

  def giveMe(dish: String): Waiter = {
    new Waiter("", dishList :+ dish)
  }

  def complete: List[String] = {
    dishList
  }
}
