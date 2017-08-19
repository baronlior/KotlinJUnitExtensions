package com.baronlior.jke

import com.baronlior.junit4.it
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * @author liorb
 * @since: 19/08/2017.
 */

class AssertTest {

  @Before
  fun setUp() {
  }

  @Test
  fun basic() {
    it("test the simple stuff") {
      expect { 2 + 2 toBe 4 }
      expect("!=") { 2 + 2 notToBe 5 }
      expect("smaller than") { 2+2 toBeLessThan 1 }
    }
  }

}
