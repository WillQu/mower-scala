/**
  * Direction of the mower
  */
object Direction extends Enumeration {
  val NORTH = Value("N")
  val EAST = Value("E")
  val SOUTH = Value("S")
  val WEST = Value("O")

  def leftOf(direction: Direction.Value): Direction.Value = {
    direction match {
      case NORTH => WEST
      case EAST => NORTH
      case SOUTH => EAST
      case WEST => SOUTH
    }
  }

  def rightOf(direction: Direction.Value): Direction.Value = {
    direction match {
      case NORTH => EAST
      case EAST => SOUTH
      case SOUTH => WEST
      case WEST => NORTH
    }
  }
}
