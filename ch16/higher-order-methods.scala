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
  }
}
