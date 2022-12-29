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
    if (r == c || r == 1 || c == 0) {
      return 1
    }
    pascal(c - 1, r - 1) + pascal(c, r - 1);
  }


  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceRecursive(chars: List[Char], count: Int): Boolean = {
      if (chars.nonEmpty) {
        val element = chars.head;
        if (element.equals('(')) {
          return balanceRecursive(chars.tail, count + 1);
        }
        else {
          if (element.equals(')')) {
            if (count > 0) {
              return balanceRecursive(chars.tail, count - 1);
            }
            else return false;
          }
          else return balanceRecursive(chars.tail, count);
        }
      }
      return true;
    }
    return balanceRecursive(chars, 0);
  }

  /**
    * Exercise 3
    */

  def countChange(money: Int, coins: List[Int]): Int = {
    def count(capacity: Int, changes: List[Int]): Int = {
      if (capacity == 0)
        1
      else if (capacity < 0)
        0
      else if (changes.isEmpty && capacity >= 1)
        0
      else {
        println(s"count($capacity, ${changes.tail}) + count($capacity - ${changes.head}, $changes)");
        count(capacity, changes.tail) + count(capacity - changes.head, changes)
      }
    }

    count(money, coins.sortWith(_.compareTo(_) < 0))
  }

  /**
    * Custom exercise, which is similar to Exericse 2
    */
  def braces(values: Array[String]): Array[String] = {
    val result = new Array[String](values.length)
    var i = 0
    for (value <- values) {
      if (bracesRecursive(value.toList, 0)) {
        result(i) = "YES"
      }
      else {
        result(i) = "NO"

      }
      i = i + 1
    }
    return result
  }


  def bracesRecursive(chars: List[Char], count: Int): Boolean = {
    if (chars.nonEmpty) {
      val element = chars.head;
      if (element.equals('(')||element.equals('{')) {
        return bracesRecursive(chars.tail, count + 1);
      }
      else {
        if (element.equals(')')||element.equals('}')) {
          if (count > 0) {
            return bracesRecursive(chars.tail, count - 1);
          }
          else return false;
        }
        else return bracesRecursive(chars.tail, count);
      }
    }
    return true;
  }


}
