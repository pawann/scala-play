package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
    
    
    println(balance(")(".toList));
    println(countChange(4, List(1,2)));
    println(countChange(100, List(1, 5,10,25,50, 100)));

  }
  

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def recBalance(openCount: Int, chars: List[Char]): Boolean = {
      //println(openCount + " --> " + chars.mkString)

      if (openCount < 0)// If paranthesis are correctly place this would never be negative
        false
      else if (chars.isEmpty)
        if (openCount == 0)
          true
        else
          false
      else if (chars.head == '(')
        recBalance(openCount + 1, chars.tail)
      else if (chars.head == ')')
        recBalance(openCount - 1, chars.tail)
      else
        // Any other character
        recBalance(openCount, chars.tail)
    }

    recBalance(0, chars);
  } //> balance: (chars: List[Char])Boolean

  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
    def recCount(money: Int, coins: List[Int], count: Int): Int = {
      //println(money+" --> "+coins.toString+" -->"+count)
      if (money < 0 || coins.isEmpty)
        count;
      else if(money == 0){
        count + 1
        }
      else
        recCount(money - coins.head, coins, count) +
          recCount(money, coins.tail, count)
    }

    recCount(money, coins, 0);

  }

}
