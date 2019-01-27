import static myio.ioPack.printClass.*;

public class StaMethRe {
  static boolean numTest(IntPredicate p,int v){//接口实例化
      return p.test(v);
  }

  public static void main(String args[]){
    boolean result;

    result = numTest(MyIntPredicates::isPrime,17);
    //这里就是把函数表达式赋值了,类似于拉姆达的赋值
    if (result)
      println("17 is prime");
    result = numTest(MyIntPredicates::isEven,12);
    if (result) println("12 is even");
    result = numTest(MyIntPredicates::isPositive,11);
    if (result) println("11 is positive");

  }
}

interface IntPredicate {
  boolean test(int n);
}

class MyIntPredicates {//普通接口
  static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i <= n / i; i++) {
      if ((n % i) == 0)
        return false;
    }
    return true;
  }

  static boolean isEven(int n) {
    return (n % 2) == 0;
  }

  static boolean isPositive(int n) {
    return n > 0;
  }
}
//大体就是一个接口充当源头,另一个接口负责储存多个实现,
// 通过静态方法引用就方便实现了一个引用多种实现,而且不会后面覆盖前面