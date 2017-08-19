package com.baronlior.junit4

import org.junit.Assert

/**
 * @author liorb
 * @since: 19/08/2017.
 */

fun it (message : String, block: Argument.() -> Unit) {
  val argument = Argument(message)

  with(argument) {
    block()
  }
}

class Matcher(private val expectation: String) {

  private val e = "[$expectation]"

  infix fun Any.toBe(actual: Any) = Assert.assertEquals(e, this, actual)
  infix fun Any.notToBe(actual: Any) = assert(this != actual, "$e expected: not equal but was: both <$actual>")
  infix fun Int.toBeLessThan(actual : Int) = assert(this < actual, "$e expected: <$this> to be less than <$actual>")

}

private fun assert(condition : Boolean, message : String) {
  if (!condition){
    Assert.fail(message)
  }
}

class Argument(private val text: String) : Assert() {

  fun expect(block: Matcher.() -> Unit) {
    Matcher(text).block()
  }

  fun expect(subMessage : String, block: Matcher.() -> Unit) {
    Matcher("$text / $subMessage").block()
  }

}

