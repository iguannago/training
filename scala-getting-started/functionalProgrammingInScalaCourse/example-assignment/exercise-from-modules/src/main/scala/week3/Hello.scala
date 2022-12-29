package week3

/**
  * Created by davicres on 23/06/2016.
  */
object Hello {
  def error(msg: String) = throw new Error(msg)

  def main(args: Array[String]) = {
    print("Hello World!")
  }
}
