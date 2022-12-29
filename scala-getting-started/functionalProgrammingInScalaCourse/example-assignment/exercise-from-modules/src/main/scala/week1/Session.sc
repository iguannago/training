object session {
  def abs(x: Double): Double = if (x < 0) -x else x
  abs(-1)
  abs(1)
  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001
    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }
    sqrtIter(1.0)
  }
  sqrt(2)
  sqrt(9)
  sqrt(4)
  sqrt(6)
  sqrt(5)
  sqrt(1e-60)
  sqrt(1e60)
  //Some recursive functions
  /*
  gcd(a,b)
   */
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) b
    else gcd(b, a % b)
  }

  gcd(4, 8)

  /*
  non-tail recursive factorial function
   */
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)
  factorial(0)
  factorial(1)
  factorial(3)

  /*
  tail recursive factorial function
   */
  def tailRecursiveFactorial(n: Int): Int = {
    def factorialIter(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else {
        factorialIter(acc * n, n - 1)
      }
    }

    factorialIter(1, 4)
  }
  tailRecursiveFactorial(4)

  /*
  anonymous functions
   */
  (a: Int, b: Int) => a + b

  /*
  high order functions
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  sum(x => x * x, 3, 5)

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  product(x => x * x)(3, 4)

  //factorial function reusing the product function.
  def fact(n: Int) = product(x => x)(1, n)
  fact(5)


}
