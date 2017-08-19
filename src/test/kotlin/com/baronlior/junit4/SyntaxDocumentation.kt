package com.baronlior.junit4

import org.junit.Test

class SyntaxDocumentation {

  @Test
  fun myTestMethod() {

      it("The 'toBe' matcher compares with ===") {
          expect { 2 + 2 toBe 4 }
          expect { null toBe null }
          expect { 1 to "2" toBe Pair(1,"2") }

          expect ("string concatenation") { "2" + "2" notToBe "4" }
          expect { "null" notToBe null }
      }

      it("The 'toBeLessThan' matcher is for mathematical comparisons") {
          val PI = 3.1415926
          val e = 2.78

          expect {e toBeLessThan PI}
      }

      it("The 'toMatch' matcher is for regular expressions") {
          val message = "foo bar baz";

          expect { message toMatchRegex "bar" }
          expect { message notToMatchRegex "quux" }
      }
  }
}
