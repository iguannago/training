import week3._

object intsets extends App {
  println("Welcome to the Week3")

}

abstract class IntSets {
  def incl(x: Int): IntSets

  def contains(x: Int): Boolean

  def union(other: IntSets): IntSets
}

class Empty extends IntSets {
  def incl(x: Int): IntSets =
    new NonEmpty(x, new Empty, new Empty)

  def contains(x: Int): Boolean = false

  override def toString = "."

  def union(other: IntSets): IntSets = other
}

class NonEmpty(elem: Int, left: IntSets, right: IntSets) extends IntSets {
  def incl(x: Int): IntSets = if (x < elem) new NonEmpty(elem, left incl x, right)
  else if (x > elem) new NonEmpty(elem, left, right incl x)
  else this

  def contains(x: Int): Boolean = if (x < elem) left contains x
  else if (x > elem) right contains x
  else true

  override def toString = "{" + left + elem + right + "}"

  def union(other: IntSets): IntSets =
    ((left union right) union other) incl elem
}
val t1 = new NonEmpty(3, new Empty, new Empty)
val t2 = t1 incl 4
val t3 = new Empty
val unionSetOfEmpty = t3 union t1
val union = t1 union t2

//val nothing = new Nothing

if (true) 1 else false



