package advent2021.day3

import advent2021.DataUtils
import org.scalatest.flatspec.AnyFlatSpec

class BinaryDiagnosticTest extends AnyFlatSpec {
  "Binary diagnostic" should "work correctly with 0 commands" in {
    assert(new BinaryDiagnostic().part1(LazyList()) == 0)
  }

  "Binary diagnostic" should "with odd number of entries" in {
    assert(new BinaryDiagnostic().part1(LazyList("101", "011", "100")) == 10) // 101 x 010 = 5 x 2 = 10
  }

  // actual exercise
  "Binary diagnostic" should "work for test input" in {
    val result = new BinaryDiagnostic().part1(DataUtils.getDataLines(getClass))
    println(s"Exercise result (part 1): ${result}")
    assert(result == 3633500)
  }

  "Binary rating" should "work with simple data" in {
    val diagnostics = new BinaryDiagnostic()
    assert(diagnostics.part2(LazyList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")) == 230)
  }

  "Binary rating" should "work for test input" in {
    val input = DataUtils.getDataLines(getClass)
    val result = new BinaryDiagnostic().part2(input)
    println(s"Exercise result (part 2): ${result}")

    assert(result == 4550283)
  }
}
