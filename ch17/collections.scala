object Collections {
  def main {
    import scala.collection.mutable

    //sets
    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    val words = mutable.Set.empty[String]
    for (word <- wordsArray)
      words += word.toLowerCase
    assert(words == Set("see", "run", "spot"))
    words.clear

    //sets common operations table 17.1 ch17 p 348
    //immutable
    val setNums = Set(1, 2, 3)
    assert(setNums.toString == "Set(1, 2, 3)")
    assert((setNums + 5) == Set(1, 2, 3, 5))
    assert((setNums - 3) == Set(1, 2))
    assert((setNums ++ List(5,6)) == Set(1, 2, 3, 5, 6))
    assert((setNums -- List(1,2)) == Set(3))
    assert((setNums & Set(1, 3, 5, 7)) == Set(1,3)) // intersection
    assert(setNums.size == 3)
    assert(setNums.contains(3) == true)
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

    //maps
    def countWords(text: String) = {
      val counts = mutable.Map.empty[String, Int]
      for (rawWord <- text.split("[ ,!.]+")) {
        val word = rawWord.toLowerCase
        val oldCount =
          if (counts.contains(word)) counts(word)
          else 0
        counts += (word -> (oldCount + 1))
      }
      counts
    }
    assert(countWords("See spot run! Run, Spot. Run!") == Map("spot" -> 2, "see" -> 1, "run" -> 3))

    //maps common operations table ch17 p350-351
    //immutable
    val mapNums = Map("i" -> 1, "ii" -> 2)
    assert((mapNums + ("vi" -> 6)) == Map("i" -> 1, "ii" -> 2, "vi" -> 6))
    assert((mapNums - "ii") == Map("i" -> 1))
    assert((mapNums ++ List("iii" -> 3, "v" -> 5)) == Map("i" -> 1, "ii" -> 2, "iii" -> 3, "v" -> 5))
    assert((mapNums -- List("i", "ii")) == Map())
    assert(mapNums.size == 2)
    assert(mapNums.contains("ii") == true)
    assert(mapNums("ii") == 2)
    assert(mapNums.keys == Set("i", "ii")) // actually returns Iterable
    assert(mapNums.keySet == Set("i", "ii")) // returns Set
    //assert(mapNums.values == Set(1, 2)) // need to find proper way to test this
    assert(mapNums.isEmpty == false)
    //mutable
    //import scala.collection,mutable (already up there for another example)
    val mapMutableWords = mutable.Map.empty[String, Int]
    mapMutableWords += ("one" -> 1)
    assert(mapMutableWords.toString == "Map(one -> 1)")
    mapMutableWords -= "one"
    assert(mapMutableWords.toString == "Map()")
    mapMutableWords ++= List("one" -> 1, "two" -> 2, "three" -> 3)
    //assert(mapMutableWords.toString == "Map(one -> 1, two -> 2, three -> 3)") //this failing too
    mapMutableWords --= List("one", "two")
    assert(mapMutableWords.toString == "Map(three -> 3)")

  }
}
