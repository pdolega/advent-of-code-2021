package advent2021.day1

import advent2021.DataUtils
import org.scalatest.flatspec.AnyFlatSpec

class SonarSweepTest extends AnyFlatSpec {
  "Sonar Sweep" should "work correctly with 1 reading" in {
    assert(new SonarSweep().findNumberOfIncreases(LazyList(1)) == 0)
  }

  // actual exercise
  "Sonar Sweep" should "work for test input" in {
    val result = new SonarSweep().findNumberOfIncreases(DataUtils.getDataInts(getClass))
    println(s"Exercise result: ${result}")
  }
}
