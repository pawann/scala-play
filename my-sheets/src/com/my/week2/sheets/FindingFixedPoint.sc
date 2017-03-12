package com.my.sheets

import math.abs

object FindingFixedPoint {
  println("Finding fixed point")                  //> Finding fixed point

  //x is called fixed point if f(x) = x

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
    println("guess:" + guess);
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)

    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double


fixedPoint( x => 1 + x/2)(1)                      //> guess:1.0
                                                  //| guess:1.5
                                                  //| guess:1.75
                                                  //| guess:1.875
                                                  //| guess:1.9375
                                                  //| guess:1.96875
                                                  //| guess:1.984375
                                                  //| guess:1.9921875
                                                  //| guess:1.99609375
                                                  //| guess:1.998046875
                                                  //| guess:1.9990234375
                                                  //| guess:1.99951171875
                                                  //| res0: Double = 1.999755859375

// Using fixedPoint method to calculate sqrt.. we already used newton's method to calculate this
def sqrt(x: Double) = fixedPoint( y => x /y )(1)  //> sqrt: (x: Double)Double

//sqrt(2)
// Above function will go in infinite loop because of oscillation of value between 1 & 2

//avrage out the values
def averageDamp( f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double

def sqrt_avgDamp( x: Double) = fixedPoint(averageDamp(y => x/y))(1)
                                                  //> sqrt_avgDamp: (x: Double)Double


sqrt_avgDamp(2)                                   //> guess:1.0
                                                  //| guess:1.5
                                                  //| guess:1.4166666666666665
                                                  //| guess:1.4142156862745097
                                                  //| res1: Double = 1.4142135623746899
}