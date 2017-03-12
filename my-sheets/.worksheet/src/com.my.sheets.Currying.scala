package com.my.sheets

object Currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(281); 
  
  
  //A function returns  function
  
  def sum(f: Int => Int): (Int, Int) => Int = {
  
     def sumInternalFunction(a:Int, b: Int): Int =
         if(a>b) 0
         else f(a) + sumInternalFunction(a+1, b)
         //return internal function
         sumInternalFunction
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(31); 



  def sumInts = sum( x=>x );System.out.println("""sumInts: => (Int, Int) => Int""");$skip(33); 
  def sumCubes = sum(x => x*x*x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(17); val res$0 = 

  sumCubes(1,3);System.out.println("""res0: Int = """ + $show(res$0));$skip(80); 
  // We can avoid these middle men subCube, sumSquare
  def cube(x:Int) = x*x*x;System.out.println("""cube: (x: Int)Int""");$skip(17); val res$1 = 
  sum(cube)(1,3);System.out.println("""res1: Int = """ + $show(res$1));$skip(22); val res$2 = 
  sum( x=>x*x ) (1,3);System.out.println("""res2: Int = """ + $show(res$2));$skip(66); 
  
  // Function associates to the left
  var a_func = sum( cube);System.out.println("""a_func  : (Int, Int) => Int = """ + $show(a_func ));$skip(14); val res$3 = 
  a_func(1,3);System.out.println("""res3: Int = """ + $show(res$3));$skip(227); 
  
  
  
  //--- Excercise
  def product( f: Int => Int ) ( a: Int,b: Int ) : Int = {
    def internalFunc( a: Int, b: Int) : Int = {
     if( a > b ) 1
     else f(a) * internalFunc(a+1, b);
     }
     internalFunc(a, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(103); 
  
  
  def factorial( n: Int ) : Int = {
    if( n == 0 )
      0;
    
    product(x=>x)(1, n );
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$4 = 
  
  factorial(4);System.out.println("""res4: Int = """ + $show(res$4));$skip(181); 
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b: Int): Int =
    if( a>b ) zero
    else combine( f(a), mapReduce( f, combine, zero ) ( a+1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(96); 


def product2( f: Int => Int ) ( a: Int, b: Int ) : Int = mapReduce(f, (x, y) => x*y, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$5 = 
product2( x => x ) (1,3);;System.out.println("""res5: Int = """ + $show(res$5))}

}



//product
