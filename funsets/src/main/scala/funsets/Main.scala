package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1));
  println(contains(union(singletonSet(5), singletonSet(6)), 6))
  
}
