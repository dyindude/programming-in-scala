val someNumbers = List(-11, -10, -5, 0, 5, 10)

//demonstrate equality of different short forms of
//function literals
assert(
  (
    someNumbers.filter((x:Int) => x > 0) ==
    someNumbers.filter((x) => x > 0)) && (
    someNumbers.filter((x) => x > 0) ==
    someNumbers.filter(x => x > 0)) && (
    someNumbers.filter(x => x > 0) ==
    someNumbers.filter(_ > 0))
) // true

println(someNumbers)
