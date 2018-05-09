object Collections {
  def main {
    import scala.collection.mutable

    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    val words = mutable.Set.empty[String]
    for (word <- wordsArray)
      words += word.toLowerCase
    assert(words == Set("see", "run", "spot"))
  }
}
