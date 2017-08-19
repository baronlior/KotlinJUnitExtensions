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
  // toBeSame - ===

  infix fun <T> Array<out T>.toBeDeepEqual(actual: Array<out T>) =
      assert(this contentDeepEquals actual, format(e, this.contentDeepToString(), actual.contentDeepToString()))

  infix fun String.toMatch(regex: String) =
      assert(regex.toRegex().find(this) != null, "$e expected: <$this> to match regex <$regex>")

  infix fun Int.toBeLessThan(actual : Int) = assert(this < actual, "$e expected: <$this> to be less than <$actual>") // TODO: support generic number: https://stackoverflow.com/questions/40587118/kotlin-generic-operation-on-number

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

internal fun format(message: String, expected: Any, actual: Any): String {
  val formatted = message + " "

  val expectedString = expected.toString()
  val actualString = actual.toString()

  return if (expectedString == actualString) {
    "${formatted}expected: ${formatClassAndValue(expected, expectedString)} but was: ${formatClassAndValue(actual, actualString)}"
  } else {
    "${formatted}expected: <$expectedString> but was: <$actualString>"
  }
}

private fun formatClassAndValue(value: Any?, valueString: String): String {
  val className = if (value == null) "null" else value.javaClass.name
  return "$className <$valueString>"
}
