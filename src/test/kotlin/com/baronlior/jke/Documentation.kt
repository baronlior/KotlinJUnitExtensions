package com.baronlior.jke

import com.baronlior.junit4.it
import org.junit.Test

/**
 * @author liorb
 * @since: 19/08/2017.
 */

class Documentation {

  @Test
  fun mainDoc() {

    it("The 'toMatch' matcher is for regular expressions") {
      val message = "foo bar baz";

      expect { message toMatchRegex "bar" }
//      expect { message toMatchRegex "quux" }

    }
  }
}


fun toBeDeepEqual() {
  it("test the simple stuff") {

    expect("different object references") { arrayOf("1", "2") notToBe arrayOf("1", "2") }
    expect { arrayOf("1", "2") toBeDeepEqual arrayOf(1, "2") }
    // java.lang.AssertionError: [test the simple stuff / different object references] expected: <[1, 3]> but was: <[1, 2]>
    // Expected :<[1, 3]>
    // Actual   :<[1, 2]>

    expect { arrayOf("1", "2") toBeDeepEqual arrayOf(1, "2") }
    // java.lang.AssertionError: [test the simple stuff] expected: java.lang.String <[1, 2]> but was: java.lang.String <[1, 2]>
    // Expected :java.lang.String <[1, 2]>
    // Actual   :java.lang.String <[1, 2]>

  }
}
