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
