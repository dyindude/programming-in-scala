object InsertionSort {
  def main {
    def isort(xs: List[Int]): List[Int] = xs match {
      case List() => List()
      case x :: xs1 => insert(x, isort(xs1))
    }
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs
                      else y :: insert(x, ys)
    }
    def append[T](xs: List[T], ys: List[T]): List[T] =
      xs match {
        case List() => ys
        case x :: xs1 => x :: append(xs1, ys)
      }
    
    val fruit: List[String] = List("apples", "oranges", "pears")
    val a :: b :: rest = fruit
  }
}
