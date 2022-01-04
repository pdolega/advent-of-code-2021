package advent2021.day2

import advent2021.DataUtils
import org.scalatest.flatspec.AnyFlatSpec

class PilotSubmarineTest extends AnyFlatSpec {
  // actual exercise
  "Pilot submarine" should "work for test input - part 1" in {
    val result = new PilotSubmarine().part1(DataUtils.getDataLines(getClass))
    println(s"Exercise result: ${result}")
  }

  "Pilot submarine" should "work correctly with 0 commands" in {
    assert(new PilotSubmarine().part2(LazyList()) == 0)
  }

  "Pilot submarine" should "work correctly with 1 commands" in {
    assert(new PilotSubmarine().part2(LazyList("forward 5")) == 0)
  }

  "Pilot submarine" should "work correctly with horizontal and depth command" in {
    assert(new PilotSubmarine().part2(LazyList("forward 5", "up 3", "down 5")) == 0)
  }

  "Pilot submarine" should "work correctly with aim changed initially" in {
    assert(new PilotSubmarine().part2(LazyList("up 3", "forward 5", "down 5", "forward 5")) == -50)
  }

  "Pilot submarine" should "fail when unknown command provided" in {
    assertThrows[Error](new PilotSubmarine().part2(LazyList("xxx 5")))
  }

  // actual exercise
  "Pilot submarine" should "work for test input" in {
    val result = new PilotSubmarine().part2(DataUtils.getDataLines(getClass))
    println(s"Exercise result: ${result}")
  }
}
