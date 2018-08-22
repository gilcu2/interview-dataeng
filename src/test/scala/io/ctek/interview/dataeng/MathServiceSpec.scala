package io.ctek.interview.dataeng

import org.specs2.Specification
import org.specs2.specification.core.SpecStructure

import scala.util.Success

class MathServiceSpec extends Specification {
  def is: SpecStructure = sequential ^
    s2"""
      MathService
      =============

      gcd
        should return error no value  $noValue
        should return correct result for one value $singleValue
        should return error any value of zero $anyValueZero
        should return correct result for two value $twoValue
        should return correct result for five value $fiveValues
    """

  val mathService = new MathService

  def noValue = {
    val dataEnv = DataEnvironment(Set())
    mathService.gcd.run(dataEnv) must beEqualTo(
      Success(Left("gcd of nothing is undefined"))
    )
  }

  def singleValue = {
    val dataEnv = DataEnvironment(Set(24))
    mathService.gcd.run(dataEnv) must beEqualTo(
      Success(Right(24))
    )
  }

  def anyValueZero = {
    val dataEnv = DataEnvironment(Set(0,1))
    mathService.gcd.run(dataEnv) must beEqualTo(
      Success(Left("gcd of 0 is undefined"))
    )
  }

  def twoValue = {
    val dataEnv = DataEnvironment(Set(14, 7))
    mathService.gcd.run(dataEnv) must beEqualTo(
      Success(Right(7))
    )
  }

  def fiveValues = {
    val dataEnv = DataEnvironment(Set(25, 35, 75, 145, 90))
    mathService.gcd.run(dataEnv) must beEqualTo(
      Success(Right(5))
    )
  }
}
