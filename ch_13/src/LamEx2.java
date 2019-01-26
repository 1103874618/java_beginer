import static myio.ioPack.printClass.*;

public class LamEx2 {
  public static void main(String age[]) {
    NumbericTest isFactor = (n, d) -> (n % d) == 0;//检查整除
    if (isFactor.test(10, 2))
      println("2 is a factor of 10");
    if (!isFactor.test(10, 3))
      println("3 is not a factor of 10");
    println();

    NumbericTest lessThan = (n,m)->(n<m);//测试大小
    if (lessThan.test(2,10))
      println("2 is less than 10");
    if (!lessThan.test(10,2))
      println("10 is not less than 2");
    println();

    //绝对值相等
    NumbericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
    if (absEqual.test(4,-4))
      println("absoule values of 4 and -4 are equal.");

    if (!lessThan.test(4,-5))
      println("absoule values of 4 and -5 are not equal.");
    println();
  }
}

interface NumbericTest {
  boolean test(int n, int m);
}

//同一个接口可以有多种实现形式