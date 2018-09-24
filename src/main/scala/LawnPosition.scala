/**
  * A position in a lawn
  */
case class LawnPosition(limitX: Int, limitY: Int, x: Int, y: Int, direction: Direction.Value) {

  def next(command: Command.Value): LawnPosition = {
    command match {
      case Command.LEFT => copy(direction = Direction.leftOf(direction))
      case Command.RIGHT => copy(direction = Direction.rightOf(direction))
      case _ => forward
    }
  }

  private def forward: LawnPosition = {
    direction match {
      case Direction.NORTH => copy(y = y + 1)
      case Direction.SOUTH => copy(y = y - 1)
      case Direction.EAST => copy(x = x + 1)
      case Direction.WEST => copy(x = x - 1)
    }
  }

  def display: String = x + " " + y + " " + direction
}
