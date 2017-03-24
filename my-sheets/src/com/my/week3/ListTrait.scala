package com.my.week3

/* T is Type Parameter like java genrics*/

trait ListTrait[T] {
  def isEmpty: Boolean
  def head: T;
  def tail: ListTrait[T]
}

class Cons[T](val head: T, val tail: ListTrait[T]) extends ListTrait[T] {

  def isEmpty = false

}

class Nil[T] extends ListTrait[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head");
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object MainObj {

}