package com.baronlior.junit4

/**
 * @author liorb
 * @since: 19/08/2017.
 */


internal fun formatEqualityErrorMessage(expected: Any, actual: Any): String {

  val expectedString = expected.toString()
  val actualString = actual.toString()

  return if (expectedString == actualString) {
    "expected: ${formatClassAndValue(expected, expectedString)} but was: ${formatClassAndValue(actual, actualString)}"
  } else {
    "expected: <$expectedString> but was: <$actualString>"
  }
}

internal fun formatClassAndValue(value: Any?, valueString: String): String {
  val className = if (value == null) "null" else value.javaClass.name
  return "$className <$valueString>"
}
