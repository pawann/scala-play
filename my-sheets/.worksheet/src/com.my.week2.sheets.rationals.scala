package com.my.week2.sheets

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  val r = new Rational(1, 2);System.out.println("""r  : com.my.week2.sheets.Rational = """ + $show(r ));$skip(10); val res$0 = 
  r.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  r.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(30); 

  val x = new Rational(1, 3);System.out.println("""x  : com.my.week2.sheets.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : com.my.week2.sheets.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : com.my.week2.sheets.Rational = """ + $show(z ));$skip(19); val res$2 = 

  x.sub(y).sub(z);System.out.println("""res2: com.my.week2.sheets.Rational = """ + $show(res$2));$skip(11); val res$3 = 
  y.add(y);System.out.println("""res3: com.my.week2.sheets.Rational = """ + $show(res$3));$skip(13); val res$4 = 

  x.less(y);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(97); 
  
  //val strange = new Rational(1, 0);
  //strange.add(strange);
  
  val r2 = new Rational(5);System.out.println("""r2  : com.my.week2.sheets.Rational = """ + $show(r2 ));$skip(41); val res$5 = 
 // functions as infix operator
 x add y;System.out.println("""res5: com.my.week2.sheets.Rational = """ + $show(res$5));$skip(7); val res$6 = 
 x + y;System.out.println("""res6: com.my.week2.sheets.Rational = """ + $show(res$6));$skip(9); val res$7 = 
 x sub y;System.out.println("""res7: com.my.week2.sheets.Rational = """ + $show(res$7));$skip(4); val res$8 = 
 -x;System.out.println("""res8: com.my.week2.sheets.Rational = """ + $show(res$8))}
 
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
