package com.my.week4.sheets

object boolean_class {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var a: MyBoolean = mytrue                       //> a  : com.my.week4.sheets.MyBoolean = true
  val b: MyBoolean = myfalse                      //> b  : com.my.week4.sheets.MyBoolean = false
  
  mytrue < myfalse                                //> res0: com.my.week4.sheets.MyBoolean = false
  myfalse < mytrue                                //> res1: com.my.week4.sheets.MyBoolean = true
  myfalse < myfalse                               //> res2: com.my.week4.sheets.MyBoolean = false
  mytrue < mytrue                                 //> res3: com.my.week4.sheets.MyBoolean = false
  mytrue > myfalse                                //> res4: com.my.week4.sheets.MyBoolean = true
  
  val ax: Int = 5                                 //> ax  : Int = 5
}

abstract class MyBoolean {

def ifThenElse[T](t: => T, e: => T): T

def && (x: => MyBoolean): MyBoolean = ifThenElse(x, myfalse)
def || (x: => MyBoolean): MyBoolean = ifThenElse(mytrue, myfalse)
def unary_! : MyBoolean = ifThenElse(myfalse, mytrue)
def == (x: MyBoolean): MyBoolean = ifThenElse(x, x.unary_!)
def != (x: MyBoolean): MyBoolean = ifThenElse(x.unary_!, x)

// boolean false<true
def < (x: => MyBoolean): MyBoolean = ifThenElse(myfalse, x)
def > (x: => MyBoolean): MyBoolean = ifThenElse(mytrue, x.unary_!)


}

object mytrue extends MyBoolean {
def ifThenElse[T](t: => T, e: => T) = t

override def toString = "true"
}

object myfalse extends MyBoolean {
def ifThenElse[T]( t: => T, e: => T) = e
override def toString = "false"
}