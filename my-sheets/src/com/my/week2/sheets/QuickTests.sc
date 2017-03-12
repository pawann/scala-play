package com.my.sheets

object QuickTests {

def sum( f: Int => Int, a: Int, b: Int) : Int = {
 if(a>b) 0
 else f(a) + sum(f, a+1, b)
}

// Anonymous function
(x: Float) => x * x * x
(x: Int) => x * x * x
(a: Int, b: Int) => a*b

def sumInts(a: Int, b: Int) = sum(x => x, a, b);
def sumCube(a: Int, b: Int) = sum(x => x * x * x, a, b);


sumCube(5, 6);



}