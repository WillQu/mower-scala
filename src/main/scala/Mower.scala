/**
  * Class representing a mower.
  * @param position the initial position of the mower.
  */
class Mower(private var position: LawnPosition) {
  def display: String = position.display

  def execute(values: Seq[Command.Value]): Unit = {
    position = (position /: values) (_.next(_))
  }
}

object Mower {
  def read(limitX: Int, limitY: Int, string: String): Mower = {
    val splittedString = string.replace('\n', ' ').split(' ')
    new Mower(LawnPosition(limitX.toInt, limitY, splittedString(0).toInt, splittedString(1).toInt, Direction.withName(splittedString(2))))
  }
}
