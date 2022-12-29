package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if ((c == 0) || (c == r)) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceRecursive(chars: List[Char], counter: Int): Boolean = {
      if (chars.isEmpty)  {
        counter == 0
      }
      else {
        val char = chars.head
        if (char.equals('(')) balanceRecursive(chars.tail, counter + 1)
        else if (char.equals(')')) {
          if (counter > 0) balanceRecursive(chars.tail, counter - 1)
          else false
        }
        else {
          balanceRecursive(chars.tail, counter)
        }
      }
    }
    balanceRecursive(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money > 0) {
      if (coins.nonEmpty) {
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      }
      else 0
    }
    else if (money == 0) 1
    else 0
  }

}
