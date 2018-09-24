import Command.{FORWARD, LEFT, RIGHT}
import org.scalatest.{FunSuite, Matchers}

/**
  * Test Suite for `LawnPosition`
  */
class LawnPositionSuite extends FunSuite with Matchers {
  test("Initial position") {
    val position = LawnPosition(5, 5, 1, 2, Direction.NORTH)
    position.display should equal ("1 2 N")
  }

  test("Initial position 2") {
    val position = LawnPosition(5, 5, 3, 3, Direction.EAST)
    position.display should equal ("3 3 E")
  }

  test("Move left from north") {
    val position = LawnPosition(5, 5, 1, 2, Direction.NORTH)
    val result = position.next(LEFT)
    result.display should equal ("1 2 O")
  }

  test("Move forward from west") {
    val position = LawnPosition(5, 5, 1, 2, Direction.WEST)
    val result = position.next(FORWARD)
    result.display should equal ("0 2 O")
  }

  test("Move left from west") {
    val position = LawnPosition(5, 5, 1, 2, Direction.WEST)
    val result = position.next(LEFT)
    result.display should equal ("1 2 S")
  }

  test("Move forward from south") {
    val position = LawnPosition(5, 5, 1, 2, Direction.SOUTH)
    val result = position.next(FORWARD)
    result.display should equal ("1 1 S")
  }

  test("Move right from east") {
    val position = LawnPosition(5, 5, 3, 3, Direction.EAST)
    val result = position.next(RIGHT)
    result.display should equal ("3 3 S")
  }

}
