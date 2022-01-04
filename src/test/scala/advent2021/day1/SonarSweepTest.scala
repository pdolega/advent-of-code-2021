package advent2021.day1

import advent2021.DataUtils
import org.scalatest.flatspec.AnyFlatSpec

class SonarSweepTest extends AnyFlatSpec {
  "Sonar Sweep" should "work correctly with 1 reading" in {
    assert(new SonarSweep().part1(LazyList(1)) == 0)
  }

  // actual exercise
  "Sonar Sweep" should "work for test input" in {
    val result = new SonarSweep().part1(DataUtils.getDataInts(getClass))
    println(s"Exercise result: ${result}")
    assert(result == 1215)
  }

  "Sonar Sweep" should "work for 3-measurements with sample reading" in {
    assert(new SonarSweep().part2(LazyList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)) == 5)
  }

  // actual exercise
  "Sonar Sweep" should "work for 3-measurements test input" in {
    val result = new SonarSweep().part2(DataUtils.getDataInts(getClass))
    assert(result == 1150)
    println(s"Exercise result: ${result}")
  }
}
