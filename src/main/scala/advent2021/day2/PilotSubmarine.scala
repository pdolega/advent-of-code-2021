package advent2021.day2

class PilotSubmarine {

  def part1(commands: LazyList[String]): Int = {
    case class Position(horizontal: Int, depth: Int)

    val command = raw"(forward|down|up) (\d)".r

    val result = commands.foldLeft(Position(0, 0)) { (prevPosition, move) =>
      move match {
        case command("forward", length) => prevPosition.copy(horizontal = prevPosition.horizontal + length.toInt)
        case command("up", length) => prevPosition.copy(depth = prevPosition.depth - length.toInt)
        case command("down", length) => prevPosition.copy(depth = prevPosition.depth + length.toInt)
        case x => throw new Error(s"Incorrect input: ${x}")
      }
    }

    result.horizontal * result.depth
  }

  def part2(commands: LazyList[String]): Int = {
    case class Position(horizontal: Int, depth: Int, aim: Int)

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
