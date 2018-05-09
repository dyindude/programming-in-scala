object ListMethods {
  def main {
    //apply similar to list literals
    assert((List.apply(1, 2, 3)) == List(1, 2, 3))
    //range from x >= i > y
    assert((List.range(1, 5)) == List(1, 2, 3, 4))
    assert((List.range(9, 1, -3)) == List(9, 6, 3))
    //fill creates copies of the same element
    assert((List.fill(5)('a')) == List('a', 'a', 'a', 'a', 'a'))
    assert((List.fill(2, 3)('b')) == List[List[Char]](List('b','b','b'), List('b','b','b')))
    //tabulate similar to fill, ,but applies a function to index #
    assert((List.tabulate(5)(n => n * n)) == List(0, 1, 4, 9, 16))
    assert((List.tabulate(5,5)(_ * _)) == List[List[Int]]( List(0, 0, 0, 0, 0),
                                                            List(0, 1, 2, 3, 4),
                                                            List(0, 2, 4, 6, 8),
                                                            List(0, 3, 6, 9, 12),
                                                            List(0, 4, 8, 12, 16)))
    //concat - like it sounds
    assert((List.concat(List('a', 'b'), List('c'))) == List[Char]('a', 'b', 'c'))
  }
}
