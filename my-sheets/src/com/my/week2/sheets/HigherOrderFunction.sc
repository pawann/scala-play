package com.my.sheets

object HigherOrderFunction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

// Coursera question
def sum2(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1, f(a)+acc)
  }
  loop(a, 0)
}                                                 //> sum2: (f: Int => Int, a: Int, b: Int)Int


sum2(x=>x, 1,3)                                   //> res0: Int = 6



}