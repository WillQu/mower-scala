object Main {

  def execute(input: String): String = {
    val lines = input.lines.toSeq
    lines match {
      case firstLine+:rest =>
        val (limitX, limitY) = readFirstLine(firstLine)
        executeLines(limitX, limitY, rest).mkString("\n")
      case _ => ""
    }
  }

  def readFirstLine(firstLine: String): (Int, Int) = firstLine.split(' ') match {
    case Array(pos1, pos2) => (pos1.toInt, pos2.toInt)
    case _ => throw new IllegalArgumentException(firstLine)
  }


  def executeLines(limitX: Int, limitY: Int, lines: Seq[String]): Seq[String] = {
    lines match {
      case mower+:commands+:rest => executeOne(limitX, limitY, mower, commands)+:executeLines(limitX, limitY, rest)
      case _ => Seq()
    }
  }

  def executeOne(limitX: Int, limitY: Int, mowerString: String, commandsString: String): String = {
    val mower = Mower.read(limitX, limitY, mowerString)
    val commands = commandsString.map(char => Command.withName(char.toString))
    mower.execute(commands)
    mower.display
  }
}
