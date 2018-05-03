def first(x: Int) = (y: Int) => x + y
val second = first(1)
assert(first(1)(2) == 3)
assert(second(2) == 3)
