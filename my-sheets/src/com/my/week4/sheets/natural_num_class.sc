package com.my.week4.sheets

object natural_num_class {
  println("Welcome to the Scala worksheet")
  var n: Nat = zero;
  //n.successor.successor;
  n.isZero
}

//Peano numbers
abstract class Nat {
def isZero: Boolean
def predecesor: Nat
def successor: Nat = new Succ(this)
def +(that: Nat): Nat
def -(that: Nat): Nat
}

object zero extends Nat {
def isZero: Boolean = true
def predecesor: Nat = throw new Error("No predecessor to zero")
//def successor: Nat = one
def +(that: Nat): Nat = that
def -(that: Nat): Nat = if(that.isZero) this else throw new Error("Cant substract from to zero")

}

class Succ(n: Nat) extends Nat {
def isZero: Boolean = false
def predecesor: Nat = n
//def successor: Nat = n + one
def +(that: Nat): Nat = new Succ( n + that )
def -(that: Nat): Nat = if(that.isZero) this else n - that.predecesor
}
/*
object one extends Nat {
def isZero: Boolean = false
def predecesor: Nat = zero
//def successor: Nat = new Succ( one + one )
def +(that: Nat): Nat = one + that
def -(that: Nat): Nat = one + that
}
*/