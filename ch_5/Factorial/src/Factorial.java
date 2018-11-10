public class Factorial {//n阶乘方法

  int factR(int n){//递归实现
    int result;
    if(n == 1) return  1;
    result = factR(n-1) * n;
    return  result;
  }

  int factI(int n){//遍历实现
    int t ,result;
    result = 1;
    for (t = 1; t<= n; t++) result *= t;
    return result;
  }
}

class Recursion{
  public static void main (String[] args){
    Factorial f = new Factorial();
    System.out.println("Factorials using recursive method. ");
    System.out.println("Factorials of 3 is " + f.factR(3));
    System.out.println("Factorials of 4 is " + f.factR(4));
    System.out.println("Factorials of 100 is " + f.factR(100));
    System.out.println();

    System.out.println("Factorials using iterative method. ");
    System.out.println("Factorials of 3 is " + f.factI(3));
    System.out.println("Factorials of 4 is " + f.factI(4));
    System.out.println();
  }
}
