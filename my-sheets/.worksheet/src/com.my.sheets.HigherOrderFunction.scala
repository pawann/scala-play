package com.my.sheets

object HigherOrderFunction {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(176); 

// Coursera question
def sum2(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1, f(a)+acc)
  }
  loop(a, 0)
};System.out.println("""sum2: (f: Int => Int, a: Int, b: Int)Int""");$skip(18); val res$0 = 


sum2(x=>x, 1,3);System.out.println("""res0: Int = """ + $show(res$0))}



}
