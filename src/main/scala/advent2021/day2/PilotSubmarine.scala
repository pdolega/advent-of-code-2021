package advent2021.day2

class PilotSubmarine {

  case class Position(horizontal: Int, depth: Int, aim: Int)

  def calculateMultlication(commands: LazyList[String]): Int = {
    val command = raw"(forward|down|up) (\d)".r

    val result = commands.foldLeft(Position(0, 0, 0)) { (prevPosition, move) =>
      move match {
        case command("forward", length) => Position(prevPosition.horizontal + length.toInt, prevPosition.depth + prevPosition.aim * length.toInt, prevPosition.aim)
        case command("up", aim) => prevPosition.copy(aim = prevPosition.aim - aim.toInt)
        case command("down", aim) => prevPosition.copy(aim = prevPosition.aim + aim.toInt)
        case x => throw new Error(s"Incorrect input: ${x}")
      }
    }

    result.horizontal * result.depth
  }
}
