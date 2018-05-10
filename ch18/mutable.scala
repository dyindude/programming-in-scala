class BankAccount {
  private var bal: Int = 0
  def balance: Int = bal
  def deposit(amount: Int) = {
    require(amount > 0)
    bal += amount
  }
  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
}
class Time {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_: (x: Int) = {
    require(0 <= x && x < 24)
    h = x
  }
  def minute = m
  def minute_= (x: Int) = {
    require(0 <= x && x < 60)
    m = x
  }
}
class Thermometer {
  var celsius: Float = _
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) = {
    celsius = (f - 32) * 5 / 9
  }
  def kelvin = celsius + 273.15f
  def kelvin_= (f: Float) = {
    celsius = f - 273.15f
  }
  override def toString = fahrenheit + "F/" + celsius + "C/" + kelvin + "K"
}
object MutableObjects {
  def main {
    val account = new BankAccount
    account deposit 100
    assert((account withdraw 80) == true)
    assert((account withdraw 80) == false)
    val t = new Thermometer
    t.celsius = 100
    assert(t.fahrenheit == 212.0)
    t.fahrenheit = -40
    assert(t.celsius == -40)
    t.kelvin = 223.15f
    assert(t.celsius == -50)
    }
}
