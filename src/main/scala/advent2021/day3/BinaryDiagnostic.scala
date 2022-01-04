package advent2021.day3

import scala.annotation.tailrec

class BinaryDiagnostic {

  case class OnesOccurrences(
                             totalCount: Int = 0,  // total number of measurements
                             countOfOnes: Array[Int] = Array.empty // number of 1s in each positions
                           )

  case class Coefficients(gamma: String, epsilon: String)

  def part1(measurements: LazyList[String]): Int = {
    val Coefficients(gamma, epsilon) = calculateDiagnosticCoefficients(measurements)
    if(gamma.isEmpty || epsilon.isEmpty)
      0
    else
      Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
  }

  def part2(measurements: LazyList[String]): Int = {
    val oxygen = calculateRating(measurements, 0, Ox)
    val co2 = calculateRating (measurements, 0, Co2)

    Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)
  }

  private def calculateDiagnosticCoefficients(measurements: LazyList[String]): Coefficients = {
    val results = calculateOccurrences(measurements)

    val gamma = results.countOfOnes.map(x => if(x > results.totalCount / 2) "1" else "0").mkString
    val epsilon = results.countOfOnes.map(x => if(x <= results.totalCount / 2) "1" else "0").mkString

    Coefficients(gamma, epsilon)
  }

  private def calculateOccurrences(measurements: LazyList[String]) = {
    measurements.foldLeft(OnesOccurrences()) { (acc, current) =>
      if (acc.countOfOnes.isEmpty) {
        OnesOccurrences(totalCount = 1, countOfOnes = current.map(_.toString.toInt).toArray)
      } else {
        OnesOccurrences(
          totalCount = acc.totalCount + 1,
          countOfOnes = acc.countOfOnes.zip(current).map { case (count, chr) =>
            count + chr.toString.toInt
          }.toArray
        )
      }
    }
  }

  sealed trait Rating
  object Ox extends Rating
  object Co2 extends Rating

  @tailrec
  private def calculateRating(measurements: Seq[String], index: Int, rating: Rating): String = {
    if(measurements.size == 1) {
      return measurements.head
    }

    calculateOnesZeroes(measurements, index) match {
      case (noOnes, noZeroes) if noOnes >= noZeroes =>
        calculateRating(
          filter(measurements, index, if(rating == Ox) '1' else '0'),
          index + 1,
          rating
        )

      case _ =>
        calculateRating(
          filter(measurements, index, if(rating == Ox) '0' else '1'),
          index + 1,
          rating
        )
    }
  }

  private def calculateOnesZeroes(measurements: Seq[String], index: Int) = {
    if(measurements.isEmpty) {
      throw new IllegalArgumentException(s"Impossible to filter, no more measurements")
    }

    measurements.foldLeft((0, 0)) { case ((noZeroes, noOnes), measure) =>
      if (index >= measure.length) {
        throw new IllegalArgumentException(s"Index higher than lenght of the measurement string: ${index} -> ${measure}")
      }

      val digit = measure(index)

      if (digit == '1') (noZeroes + 1, noOnes)
      else (noZeroes, noOnes + 1)
    }
  }

  private def filter(measurements: Seq[String], index: Int, value: Char): Seq[String] = {
    measurements.filter { measurement =>
      measurement(index) == value
    }
  }
}
