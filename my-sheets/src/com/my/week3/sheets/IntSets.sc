package com.my.week3.sheets

object IntSets {

  val t1 = new NonEmpty(3, Empty, Empty);         //> t1  : com.my.week3.sheets.NonEmpty = {.3.}
  val t2 = t1 incl 4;                             //> t2  : com.my.week3.sheets.IntSet = {.3{.4.}}

}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  //execercise
  def union(other: IntSet): IntSet
}

// Single global instance
object Empty extends IntSet {
  //class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet) = other

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet) =
    ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}