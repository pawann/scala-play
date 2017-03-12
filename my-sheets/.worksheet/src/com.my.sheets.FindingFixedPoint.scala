package com.my.sheets

import math.abs

object FindingFixedPoint {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Finding fixed point");$skip(67); 

  //x is called fixed point if f(x) = x

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(82); 

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(266); 

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
    println("guess:" + guess);
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)

    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(31); val res$0 = 


fixedPoint( x => 1 + x/2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(147); 

// Using fixedPoint method to calculate sqrt.. we already used newton's method to calculate this
def sqrt(x: Double) = fixedPoint( y => x /y )(1);System.out.println("""sqrt: (x: Double)Double""");$skip(189); 

//sqrt(2)
// Above function will go in infinite loop because of oscillation of value between 1 & 2

//avrage out the values
def averageDamp( f: Double => Double)(x: Double) = (x + f(x))/2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(69); 

def sqrt_avgDamp( x: Double) = fixedPoint(averageDamp(y => x/y))(1);System.out.println("""sqrt_avgDamp: (x: Double)Double""");$skip(18); val res$1 = 


sqrt_avgDamp(2);System.out.println("""res1: Double = """ + $show(res$1))}
}
