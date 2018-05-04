abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}

object Main {
  def main(args: Array[String]) {
    //these are equivalent if we aren't making changes to the class
    class MyQueue extends BasicIntQueue with Doubling
    val q1 = new BasicIntQueue with Doubling
    val q2 = new MyQueue
    q1.put(10)
    q2.put(10)
    assert(q1.get == q2.get)

    //example from p235
    val q3 = (new BasicIntQueue with Incrementing with Filtering)
    q3.put(-1)
    q3.put(0)
    q3.put(1)
    assert(q3.get == 1)

  }
}
