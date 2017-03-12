package com.my.sheets

object Currying {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  //A function returns  function
  
  def sum(f: Int => Int): (Int, Int) => Int = {
  
     def sumInternalFunction(a:Int, b: Int): Int =
         if(a>b) 0
         else f(a) + sumInternalFunction(a+1, b)
         //return internal function
         sumInternalFunction
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int



  def sumInts = sum( x=>x )                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x*x*x)                  //> sumCubes: => (Int, Int) => Int

  sumCubes(1,3)                                   //> res0: Int = 36
  // We can avoid these middle men subCube, sumSquare
  def cube(x:Int) = x*x*x                         //> cube: (x: Int)Int
  sum(cube)(1,3)                                  //> res1: Int = 36
  sum( x=>x*x ) (1,3)                             //> res2: Int = 14
  
  // Function associates to the left
  var a_func = sum( cube)                         //> a_func  : (Int, Int) => Int = <function2>
  a_func(1,3)                                     //> res3: Int = 36
  
  
  
  //--- Excercise
  def product( f: Int => Int ) ( a: Int,b: Int ) : Int = {
    def internalFunc( a: Int, b: Int) : Int = {
     if( a > b ) 1
     else f(a) * internalFunc(a+1, b);
     }
     internalFunc(a, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  
  def factorial( n: Int ) : Int = {
    if( n == 0 )
      0;
    
    product(x=>x)(1, n );
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res4: Int = 24
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b: Int): Int =
    if( a>b ) zero
    else combine( f(a), mapReduce( f, combine, zero ) ( a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int


def product2( f: Int => Int ) ( a: Int, b: Int ) : Int = mapReduce(f, (x, y) => x*y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
product2( x => x ) (1,3);                         //> res5: Int = 6

}



//product