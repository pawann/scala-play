package com.my.week2.sheets

object CallByName {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(122); 

def something() = {
  println("calling something")
  1 // return value
};System.out.println("""something: ()Int""");$skip(81); 

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  };System.out.println("""callByValue: (x: Int)Unit""");$skip(83); 

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  };System.out.println("""callByName: (x: => Int)Unit""");$skip(26); 

callByValue(something());$skip(24); 
callByName(something())}

}
