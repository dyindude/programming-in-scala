import org.scalatest.FunSuite
import Element.elem

class ElementSuite extends FunSuite {
  test("elem result should have passed width (using assert())") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
  test("elem result should have passed width (using assertResult())") {
    val ele = elem('x', 2, 3)
    assertResult(2) {
      ele.width
    }
  }
  //not implemented (yet)
//  test("elem result should throw IllegalArgumentException for negative width") {
//    assertThrows[IllegalArgumentException] {
//      elem('x', -2, 3)
//    }
//  }
}
