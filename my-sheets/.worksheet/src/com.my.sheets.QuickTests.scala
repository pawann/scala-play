package com.my.sheets

object QuickTests {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(134); 

def sum( f: Int => Int, a: Int, b: Int) : Int = {
 if(a>b) 0
 else f(a) + sum(f, a+1, b)
};System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(47); val res$0 = 

// Anonymous function
(x: Float) => x * x * x;System.out.println("""res0: Float => Float = """ + $show(res$0));$skip(22); val res$1 = 
(x: Int) => x * x * x;System.out.println("""res1: Int => Int = """ + $show(res$1));$skip(24); val res$2 = 
(a: Int, b: Int) => a*b;System.out.println("""res2: (Int, Int) => Int = """ + $show(res$2));$skip(50); 

def sumInts(a: Int, b: Int) = sum(x => x, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(57); ;
def sumCube(a: Int, b: Int) = sum(x => x * x * x, a, b);System.out.println("""sumCube: (a: Int, b: Int)Int""");$skip(17); val res$3 = ;


sumCube(5, 6);;System.out.println("""res3: Int = """ + $show(res$3))}



}
