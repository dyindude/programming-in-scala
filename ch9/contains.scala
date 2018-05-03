val numbers = List[Int](-1,2,3,-5)
def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
assert(containsNeg(numbers))
assert(containsOdd(numbers))
