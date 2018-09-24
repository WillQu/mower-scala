/**
  * A position in a lawn (coordinates + direction).
  *
  * Note: limitX and limitY are currently ignored.
  */
case class LawnPosition(limitX: Int, limitY: Int, x: Int, y: Int, direction: Direction.Value) {

  /**
    * Compute the next position after executing the specified command.
    * @param command the command to execute.
    * @return the position after executing the command.
    */
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

  /**
    *
    * @return display this position in the required format.
    */
  def display: String = x + " " + y + " " + direction
}
