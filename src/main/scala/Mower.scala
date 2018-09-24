/**
  * Class representing a mower (mutable).
  * @param position the initial position of the mower.
  */
class Mower(private var position: LawnPosition) {
  /**
    *
    * @return the current position of this mower.
    */
  def display: String = position.display

  /**
    * Execute the specified command. Changes the current position of this mower.
    * @param values a sequence of command to execute in order.
    */
  def execute(values: Seq[Command.Value]): Unit = {
    position = (position /: values) (_.next(_))
  }
}

object Mower {
  /**
    *
    * @param limitX x limit of the lawn (currently ignored)
    * @param limitY y limit of the lawn (currently ignored)
    * @param string a text description of the current mower position.
    * @return
    */
  def read(limitX: Int, limitY: Int, string: String): Mower = {
    val splittedString = string.replace('\n', ' ').split(' ')
    new Mower(LawnPosition(limitX.toInt, limitY, splittedString(0).toInt, splittedString(1).toInt, Direction.withName(splittedString(2))))
  }
}
