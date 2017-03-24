package com.my.week3.sheets

import com.my.week3._
object type_param {

  println("Hello")
  /*
  def nth[T](n: Int, list: ListTrait[T]): T = {
    if (n < 0)
      throw new IndexOutOfBoundsException("Negative index")

    var i = 0;
    var currList = list;
    for (i <- 0 to n) {
      if (currList.tail.isEmpty)
        throw new IndexOutOfBoundsException("Ran out of list")
      else
        currList = list.tail;
    }
    return currList.head;
  }
*/
  def nth2[T](n: Int, xs: ListTrait[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException("Negative index")
    if (n == 0) xs.head
    else nth2(n - 1, xs.tail)
  }
  var list = new Cons(1, new Cons(2, new Cons(3, new Nil)));
  println(nth2(-1, list));
  println(nth2(0, list));
  println(nth2(1, list));
  println(nth2(2, list));
  println(nth2(3, list));
  


}