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

  infix fun Any.toBe(actual: Any) = assert(this == actual, formatEqualityErrorMessage(this, actual))
  infix fun Any.notToBe(actual: Any) = assert(this != actual, "expected: not equal but was: both <$actual>")
  // toBeSame - ===

  infix fun <T> Array<out T>.toBeDeepEqual(actual: Array<out T>) =
      assert(this contentDeepEquals actual, formatEqualityErrorMessage(this.contentDeepToString(), actual.contentDeepToString()))

  infix fun String.toMatchRegex(regex: String) =
      assert(regex.toRegex().find(this) != null, "expected: <$this> to match regex <$regex>")

  infix fun Int.toBeLessThan(actual : Int) = assert(this < actual, "expected: <$this> to be less than <$actual>") // TODO: support generic number: https://stackoverflow.com/questions/40587118/kotlin-generic-operation-on-number


  private fun assert(condition : Boolean, message : String) {
    if (!condition){
      Assert.fail("[$expectation] $message")
    }
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

