object rationals {
  val x1 = new Rational(1, 2)
  x1.numer
  x1.denom

  class Rational(x: Int, y: Int) {
    require(y != 0, "denom must be nonzero")
    private val g = gcd(x, y)

    def numer = x / g

    def denom = y / g

    def + (r: Rational) =
      new Rational(numer * r.denom + r.numer * denom,
        denom * r.denom)

    def unary_- : Rational = new Rational(-numer, denom)

    def - (r: Rational) = this + -r

    private def gcd(a: Int, b: Int): Int = if (b == 0) a
    else gcd(b, a % b)

    def < (r: Rational) = numer * r.denom < r.numer * denom

    def max(r: Rational) = if (this < r) r else this

    override def toString = numer + "/" + denom

  }


  val r = new Rational(1, 3)
  -r

  val s = new Rational(2, 4)
  r + s

  r - s

  new Rational(1, 2) + (new Rational(2, 3))


  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x - y - z
  y + z

  x < y
  x max y

//  val strange = new Rational(1, 0)
//  strange.add(strange)

  x + y

  x max y

  -x

}

