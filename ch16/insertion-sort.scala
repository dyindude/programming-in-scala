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
    def rev[T](xs: List[T]): List[T] = xs match {
      case List() => xs
      case x :: xs1 => rev(xs1) ::: List(x)
    }
    
    val fruit: List[String] = List("apples", "oranges", "pears")
    val a :: b :: rest = fruit
    //p320 examples
    val abcde = List('a', 'b', 'c', 'd', 'e')
    assert((abcde mkString ("[", ",", "]")) == "[a,b,c,d,e]")
    assert((abcde mkString "") == "abcde")
    assert((abcde mkString) == "abcde")
    assert((abcde mkString ("List(", ", ", ")")) == "List(a, b, c, d, e)")
    assert((abcde mkString ("List(", ", ", ")")) == abcde.toString)
    
  }
}
