package advent2021.day1

class SonarSweep {

  case class Accumulator(result: Int, previous: Option[Int])

  def findNumberOfIncreases(measurments: LazyList[Int]): Int = {
    val result = measurments.foldLeft(Accumulator(0, None)) { (acc, current) =>
      val increase = acc.previous.map { prev =>
        if(prev > current) 0
        else 1
      }.getOrElse(0)

      Accumulator(acc.result + increase, Option(current))
    }

    result.result
  }
}
