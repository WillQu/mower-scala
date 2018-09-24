import org.scalatest.{FunSuite, Matchers}

class MainSuite extends FunSuite with Matchers {
  test("Main test") {
    val result = Main.execute(
      """5 5
        |1 2 N
        |GAGAGAGAA
        |3 3 E
        |AADAADADDA""".stripMargin)
    result should equal (
      """1 3 N
        |5 1 E""".stripMargin)
  }
}
