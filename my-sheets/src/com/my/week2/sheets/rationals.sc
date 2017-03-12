package com.my.week2.sheets

object rationals {
  val r = new Rational(1, 2)                      //> r  : com.my.week2.sheets.Rational = 1/2
  r.numer                                         //> res0: Int = 1
  r.denom                                         //> res1: Int = 2

  val x = new Rational(1, 3)                      //> x  : com.my.week2.sheets.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : com.my.week2.sheets.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : com.my.week2.sheets.Rational = 3/2

  x.sub(y).sub(z)                                 //> res2: com.my.week2.sheets.Rational = -79/42
  y.add(y)                                        //> res3: com.my.week2.sheets.Rational = 10/7

  x.less(y)                                       //> res4: Boolean = true
  
  //val strange = new Rational(1, 0);
  //strange.add(strange);
  
  val r2 = new Rational(5)                        //> r2  : com.my.week2.sheets.Rational = 5/1
 // functions as infix operator
 x add y                                          //> res5: com.my.week2.sheets.Rational = 22/21
 x + y                                            //> res6: com.my.week2.sheets.Rational = 22/21
 x sub y                                          //> res7: com.my.week2.sheets.Rational = 8/-21
 -x                                               //> res8: com.my.week2.sheets.Rational = 1/-3
 
//Precedence of operators is determined by a table - lowest to highest priority
// (all letters) | ^ & < > = ! : + - * / % (all other special chars)

//so expression  a + b ^? c ?^ d less a ==> b | c
// (((a + b) ^? (c ?^ d)) less (a ==> b) | c)
}

class Rational(x: Int, y: Int) {
  // Predefined function, assert is another
  require( y!= 0, "denominator cannot be zero" )
  
  
  //Second constructor
  def this(x: Int) = this(x, 1)
  
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b )
  private val g = gcd(x, y)
  
  def numer = x
  def denom = y

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)

  //Making this neg a unary - symbol - notice space between - and :
  def unary_- : Rational = neg
  
  override def toString = (numer/g) + "/" + (denom/g)
  
  //DRY principle - dont repeat yourself guideline
  def sub( that: Rational) = add(that.neg)
  
  
  def less( that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this
  
  // Scala can use symbols as function names
  def +(that: Rational) = add(that)
}