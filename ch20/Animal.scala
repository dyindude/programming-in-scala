class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) = {}
}
class Horse extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) = {}
}
class DogFood extends Food
class Dog extends Animal {
  type SuitableFood = DogFood
  override def eat(food: DogFood) = {}
}
class Pasture {
  var animals: List[Animal { type SuitableFood = Grass }] = Nil
}
object Animal {
  def main {
    val p = new Pasture
    println(p.animals) // still empty??
  }
}
