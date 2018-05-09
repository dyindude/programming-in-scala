object Collections {
  def main {
    import scala.collection.mutable

    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    val words = mutable.Set.empty[String]
    for (word <- wordsArray)
      words += word.toLowerCase
    assert(words == Set("see", "run", "spot"))
    words.clear

    //sets common operations table 17.1 ch17 p 348
    //immutable
    val nums = Set(1, 2, 3)
    assert(nums.toString == "Set(1, 2, 3)")
    assert((nums + 5) == Set(1, 2, 3, 5))
    assert((nums - 3) == Set(1, 2))
    assert((nums ++ List(5,6)) == Set(1, 2, 3, 5, 6))
    assert((nums -- List(1,2)) == Set(3))
    assert((nums & Set(1, 3, 5, 7)) == Set(1,3)) // intersection
    assert(nums.size == 3)
    assert(nums.contains(3) == true)
    //mutable
    //import scala.collection,mutable (already up there for another example)
    //val words = mutable.Set.empty[String] //reusing this val because lazy
    words += "the"
    assert(words == Set("the"))
    words -= "the"
    assert(words.toString == "Set()")
    words ++= List("do", "re", "mi")
    assert(words.toString == "Set(re, do, mi)")
    words --= List("do", "re")
    assert(words.toString == "Set(mi)")
    words.clear
    assert(words.toString == "Set()")
  }
}
