# KotlinJUnitExtensions
An example of JUnit extensions in Kotlin, allowing:
* Use good-old JUnit (runner, outputs) - e.g. unlike [Spek](http://spekframework.org/)
* Easy-to-read / Fun-to-write Syntax (inspired by [Jasmine](https://jasmine.github.io/2.0/introduction.html))
* expose Kotlin std lib capabilities - e.g. regex matching, deep comparison of nested arrays
* Kotlin native, allowing expressions such as `expect { 1 to "2" toBe Pair(1,"2") } `
* I tried to improve JUnit erorr messages for trackability
** `expect(<extra details>) { ... }` format - to expose extra details in the error message in times of failure

## Syntax Illustrated
```
import com.baronlior.junit4.Assert

  @Test
  fun myTestMethod() {

      it("The 'toBe' matcher compares with ===") {
          expect { 2 + 2 toBe 4 }
          expect { null toBe null }
          expect { 1 to "2" toBe Pair(1,"2") }

          expect { "2" + "2" notToBe "4" }
          expect { "null" notToBe null }
      }

      it("The 'toBeLessThan' matcher is for mathematical comparisons") {
          val PI = 3.1415926
          val e = 2.78

          expect {e toBeLessThan PI}
      }

      it("toBe... LessThan, GreaterThan, etc...") {
          expect { 2 + 2 toBeLessThan 11 }
          // TBD
      }

      it("The 'toMatch' matcher is for regular expressions") {
          val message = "foo bar baz";

          expect { message toMatchRegex "bar" }
          expect { message notToMatchRegex "quux" }
      }
  }
```

## Installation
Right now: just copy `Assert.kt` and `Utility.kt` to your project
If I'll get more than 10 start to the repository - I'll probably load it to maven