object InsertionSort {
  def main {
    def isort(xs: List[Int]): List[Int] =
      if (xs.isEmpty) Nil
      else insert(xs.head, isort(xs.tail))
    def insert(x: Int, xs: List[Int]): List[Int] =
      if (xs.isEmpty || x <= xs.head) x :: xs
      else xs.head :: insert(x, xs.tail)

    val fruit: List[String] = List("apples", "oranges", "pears")
    val a :: b :: rest = fruit
  }
}
