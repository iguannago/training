package com.rockthejvm

object Basics extends App {
  val meaningOfLife: Int = 43
  val aBoolean = true
  val aString = "I love Scala"
  val aComposedString = "I" + "love" + "Scala"
  val aInterpolatedString = s"The meaning of life is $aString"

  println(aInterpolatedString)

  //expressions
  val anExpression = 2 + 3

  val ifExpression = if (meaningOfLife == 43) "life is good" else "you are too young"
  println(ifExpression)

  // code blocks
  val aCodeBlock = {
    val aLocalValue = 2

    aLocalValue + 3
  }
  println(aCodeBlock)

  // define a function
  def myFunction(x: Int, y: String): String = y + " " + x
  println(myFunction(3, "hey you!"))

  // recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n -1)

  println(factorial(3))

  // Unit type
  def myUnitReturningFunction(message: String): Unit = println(message)
  myUnitReturningFunction("hey world!")

}
