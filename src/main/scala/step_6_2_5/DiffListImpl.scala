package step_6_2_5

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {
  override def prepend(s: List[A]): DiffListImpl[A] = {
    val f: List[A] => List[A] = list => s ::: listFunc(list)
    new DiffListImpl[A](f)
  }

  override def append(s: List[A]): DiffListImpl[A] = {
    val f: List[A] => List[A] = list => listFunc(s ::: list)
    new DiffListImpl[A](f)
  }

  override def result: List[A] = {
    listFunc(List.empty)
  }
}
