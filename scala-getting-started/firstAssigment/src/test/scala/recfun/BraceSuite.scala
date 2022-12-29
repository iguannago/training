package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import recfun.Main._

/**
  * Created by davicres on 08/06/2016.
  */
@RunWith(classOf[JUnitRunner])
class BraceSuite extends FunSuite {
  import Main.braces

  test("() is balanced") {
    val value = Array("()")
    val result = braces(value)
    println("result: ")
    for (value <- result) {
      println(value)
      assert(value.eq("YES"))
    }
  }

  test("({}) is balanced") {
    val value = Array("({})")
    val result = braces(value)
    println("result: ")
    for (value <- result) {
      println(value)
      assert(value.eq("YES"))
    }
  }




}
