package com.my.week3.sheets

object classes {

  def error(msg: String) = throw new Error(msg)

  //error("Oye teri!!");

  val x = null
  val y: String = x;

  //null has a type Null - below wont work on primitives
  //val z: Int = null;

  if (true) 1 else null

  val zStr: String = null;

}