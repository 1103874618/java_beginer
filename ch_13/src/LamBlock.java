import static myio.ioPack.printClass.*;
//找到int值的最小正因子


public class LamBlock {
  public static void main(String args[]) {
    NumericFunc smallestF = (n) -> {
      int result = 1;

      n = n < 0 ? -n : n;//简单条件判断

      for (int i = 2; i <= n / i; i++)//找最小因子的核心
        if ((n % i) == 0) {
          result = i;
          break;
        }
      return result;
    };//记得带这个分号

    println("Smallest factor of 12 is " + smallestF.func(12));
    println("Smallest factor of 11 is " + smallestF.func(11));

  }
}

interface NumericFunc {
  int func(int n);
}

