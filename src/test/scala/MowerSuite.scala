import Command.{FORWARD, LEFT, RIGHT}
import org.scalatest.{FunSuite, Matchers}

/**
  * Test suite for `Mower`
  */
class MowerSuite extends FunSuite with Matchers {
  test("Initial position") {
    val mower = new Mower(LawnPosition(5, 5, 1, 2, Direction.NORTH))
    mower.display should equal ("1 2 N")
  }

  test("Initial position 2") {
    val mower = new Mower(LawnPosition(5, 5, 3, 3, Direction.EAST))
    mower.display should equal ("3 3 E")
  }
  test("Chain commands") {
    val mower = new Mower(LawnPosition(5, 5, 1, 2, Direction.NORTH))
    mower.execute(Seq(LEFT, FORWARD,LEFT, FORWARD,LEFT, FORWARD,LEFT, FORWARD, FORWARD))
    mower.display should equal ("1 3 N")
  }

  test("Chain commands 2") {
    val mower = new Mower(LawnPosition(5, 5, 3, 3, Direction.EAST))
    mower.execute(Seq(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD))
    mower.display should equal ("5 1 E")
  }
}
