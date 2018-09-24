object Main {

  /**
    * Compute the text output from the text input.
    *
    * No validation or error handling is currently implemented. If the input is invalid, behavior is unspecified.
    *
    * @param input input of the program, must be valid.
    * @return the text output of the program.
    */
  def execute(input: String): String = {
    val lines = input.lines.toSeq
    lines match {
      case firstLine+:rest =>
        val (limitX, limitY) = readFirstLine(firstLine)
        executeLines(limitX, limitY, rest).mkString("\n")
      case _ => ""
    }
  }

  private def readFirstLine(firstLine: String): (Int, Int) = firstLine.split(' ') match {
    case Array(pos1, pos2) => (pos1.toInt, pos2.toInt)
    case _ => throw new IllegalArgumentException(firstLine)
  }


  private def executeLines(limitX: Int, limitY: Int, lines: Seq[String]): Seq[String] = {
    lines match {
      case mower+:commands+:rest => executeOne(limitX, limitY, mower, commands)+:executeLines(limitX, limitY, rest)
      case _ => Seq()
    }
  }

  private def executeOne(limitX: Int, limitY: Int, mowerString: String, commandsString: String): String = {
    val mower = Mower.read(limitX, limitY, mowerString)
    val commands = commandsString.map(char => Command.withName(char.toString))
    mower.execute(commands)
    mower.display
  }
}
