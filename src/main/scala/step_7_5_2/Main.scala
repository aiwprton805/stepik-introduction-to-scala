package step_7_5_2

/*
Программист Олег решил выдавать кредиты. Для этого ему нужно реализовать класс CreditBank и его метод issueCredit,
который выводит на консоль слово "CREDIT". К сожалению, у Олега нет своего капитала, и он решил собирать выдаваемый
кредит по кусочкам в других банках. Имеется пять банков:

trait BankA extends AbstractBank {
  override val b = 'T'
  override val d = 'R'
  override val f = 'I'
}

trait BankB extends AbstractBank {
  override val a = 'E'
  override val f = 'D'
}

trait BankC extends AbstractBank {
  override val b = 'C'
  override val d = 'D'
}

trait BankD extends AbstractBank {
  override val b = 'C'
  override val c = 'R'
  override val d = 'E'
}

trait BankE extends AbstractBank {
  override val b = 'C'
  override val a = 'I'
  override val e = 'T'
}

Все они наследуют трейт:

trait AbstractBank {
  def a: Char
  def b: Char
  def c: Char
  def d: Char
  def e: Char
  def f: Char
  def issueCredit: Unit
}

Задание: помогите Олегу собрать кредит, подмешав в нужной последовательности банки в CreditBank и реализовав метод
issueCredit ("CREDIT" должен собираться из кусочков a–f).

Справка. Множественное наследование, линеизация:
Для того, чтобы выстроить зависимости в линию, компилятор идет по всем предкам класса, объявленным после ключевого слова
extends, и назначает текущий найденный класс или трейт суперклассом всех следующих членов списка предков. Если текущий
найденный класс, в свою очередь, имеет предков, к ним так же применяются правила линеизации. Полученная цепочка
зависимостей становится в списке перед текущим найденным предком.
Следствия линеизации:
● Конструкторы классов выполняются в том порядке в котором были расставлены в процессе линеизации. Последним будет
выполнен конструктор создаваемого класса.
● Доступ к членам суперклассов через ключевое слово super происходит в обратном порядке. Т.е. super.memberName обратится
к memberName ближайшего суперкласса, полученного в процессе линеизации.

Sample Input:
CREDIT

Sample Output:
CREDIT
*/

object Main extends App {
  val creditBank = new CreditBank
  creditBank.issueCredit
}
