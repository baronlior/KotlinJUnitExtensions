package com.baronlior.junit4


internal fun formatEqualityErrorMessage(actual: Any?, expected: Any?): String {

  val expectedString = expected.toString()
  val actualString = actual.toString()

  return if (isPrimitive(expected) && isPrimitive(actual)) {
    "expected: <$expectedString> but was: <$actualString>"
  } else {
    "expected: ${formatClassAndValue(expected, expectedString)} but was: ${formatClassAndValue(actual, actualString)}"
  }
}

private fun isPrimitive(value: Any?) : Boolean {
  return when (value) {
    is String -> true
    is Int -> true
    is Long -> true
    is Boolean -> true
    is Double -> true
    is Float -> true
    is Short -> true
    is Byte -> true
    else -> false
  }
}

internal fun formatClassAndValue(value: Any?, valueString: String): String {
  val className = if (value == null) "null" else value::class.java.name
  return "$className <$valueString>"
}
