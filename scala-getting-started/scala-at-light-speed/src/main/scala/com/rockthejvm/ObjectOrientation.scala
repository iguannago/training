package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance
  abstract class Animal {
    def ?(str: String): Boolean

    //define fields and methods
    val age: Int = 0

    def eat(): Unit = println(s"Animal is $age years old")
  }

  val anAnimal = new Animal {
    override def ?(str: String): Boolean = ???
  }
  anAnimal.eat()

  //inheritance
  class Dog(val name: String) extends Animal {
    override val age: Int = 10

    override def eat(): Unit = println(s"Dog with name $name is $age years old")

    override def ?(str: String): Boolean = ???
  }

  // constructor arguments are NOT fields. We need to put val before the constructor name
  val aDog = new Dog("Lassie")
  println(aDog.name)
  aDog.eat()

  // polymorphism
  class Cat(val name: String) extends Animal {
    override val age: Int = 15

    override def eat(): Unit = println(s"Cat with name $name is $age years old")

    override def ?(str: String): Boolean = ???
  }

  val aCat: Animal = new Cat("Tom")
  aCat.eat()

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true //by default public, can restrict by private or protected

    def walk(): Unit
  }

  class MouseIsWalkingAnimal extends WalkingAnimal {
    override val hasLegs: Boolean = false

    override def walk(): Unit = {
      if (hasLegs) println("the Mouse can walk")
      else println("the mouse can't walk")
    }
  }

  val myMouse: WalkingAnimal = new MouseIsWalkingAnimal
  myMouse.walk()

  //interface
  trait Carnivore {
    def eat(): Unit
  }

  // single-class inheritance, multi-trait mixing
  class Leon extends Animal with Carnivore {
    override def eat(): Unit = println("I am a Leon a Carnivore animal")

    override def ?(str: String): Boolean = {
      if (str.equals("David")) true
      else false
    }
  }

  val aLeon: Animal = new Leon
  println(aLeon.eat())
  println(aLeon ? "David")

  //anonymous classes

}
