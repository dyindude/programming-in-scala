object MergeSort {
  def main {
    def msort[T](less: (T, T) => Boolean)
    (xs: List[T]): List[T] = {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, _) => ys
          case (_, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (less(x, y)) x :: merge(xs1, ys)
            else y :: merge (xs, ys1)
        }
      val n = xs.length / 2
      if (n == 0) xs
      else {
        val (ys, zs) = xs splitAt n
        merge(msort(less)(ys), msort(less)(zs))
      }
    }

    val intSort = msort((x: Int, y: Int) => x < y) _
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    val mixedInts = List(4,1,9,0,5,8,3,6,2,7)
    assert(intSort(mixedInts) == List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
    assert(reverseIntSort(mixedInts) == List(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
  }
}
