package advent2021.day1

class SonarSweep {

  def part1(measurements: LazyList[Int]): Int = {
    case class Accumulator(result: Int, previous: Option[Int])

    val result = measurements.foldLeft(Accumulator(0, None)) { (acc, current) =>
      val increase = acc.previous.map { prev =>
        if(prev > current) 0
        else 1
      }.getOrElse(0)

      Accumulator(acc.result + increase, Option(current))
    }

    result.result
  }

  def part2(measurements: LazyList[Int]): Int = {
    case class Accumulator(result: Int, previousSum: Option[Int])

    measurements.sliding(3).foldLeft(Accumulator(0, None)) { (acc, current) =>
      acc.previousSum match {
        case Some(prevSum) if prevSum < current.sum => Accumulator(acc.result + 1, Option(current.sum))
        case _ => Accumulator(acc.result, Option(current.sum))
      }
    }.result
  }
}
