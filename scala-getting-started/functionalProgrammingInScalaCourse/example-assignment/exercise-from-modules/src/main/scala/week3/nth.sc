import week3._


object nth {
  def nth[T](n: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    if (n == 0) list.head
    else nth(n - 1, list.tail)
  }

  val list = new Cons(10, new Cons(20, new Cons(30, new Nil)))

  nth(2, list)
  nth(1, list)
}
