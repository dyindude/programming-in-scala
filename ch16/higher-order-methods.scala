object HigherOrder {
  def main {
    assert((List(1, 2, 3) map (_ + 1)) == List(2, 3, 4))
    val words = List("the", "quick", "brown", "fox")
    assert((words map(_.length)) == List(3, 5, 5, 3))
    assert((words map(_.toList.reverse.mkString)) == List("eht", "kciuq", "nworb", "xof"))
    assert((words map(_.toList)) == List[List[Char]](List('t', 'h', 'e'),
                                                     List('q', 'u', 'i', 'c', 'k'),
                                                     List('b', 'r', 'o', 'w', 'n'),
                                                     List('f', 'o', 'x')))
    assert((words flatMap(_.toList)) == List[Char]('t', 'h', 'e',
                                                   'q', 'u', 'i', 'c', 'k',
                                                   'b', 'r', 'o', 'w', 'n',
                                                   'f', 'o', 'x'))
    var sum = 0
    List(1, 2, 3, 4, 5) foreach (sum += _)
    assert(sum == 15)

    //filter, partition, find, takeWhile, dropWhile, span ch16 p326-327
    assert((List(1, 2, 3, 4, 5) filter (_ % 2 == 0)) == List(2, 4))
    assert((List(1, 2, 3, 4, 5) partition (_ % 2 == 0)) == (List(2, 4),List(1, 3, 5)))
    assert((List(1, 2, 3, 4, 5) find (_ % 2 == 0)) == Some(2))
    assert((List(1, 2, 3, 4, 5) find (_ <= 0)) == None)
    assert((List(1, 2, 3, -4, 5) takeWhile (_ > 0)) == List(1, 2, 3))
    assert((words dropWhile (_ startsWith "t")) == List("quick", "brown", "fox"))
    assert((List(1, 2, 3, -4, 5) span (_ > 0)) == (List(1, 2, 3), List(-4, 5)))
    //forall, exists ch16 p328
    assert((List(1, 2, 3, 4, 5) forall (_ > 0)) == true)
    assert((List(1, 2, 3, -4, 5) forall (_ > 0)) == false)
    def hasZeroRow(m: List[List[Int]]) =
      m exists (row => row forall (_ == 0))
    assert((hasZeroRow(List[List[Int]](List(0,0,0,0,0), List(1,2,3,4,5)))) == true)
    assert((hasZeroRow(List[List[Int]](List(1,0,0,0,0), List(1,2,3,4,5)))) == false)
  }
}
