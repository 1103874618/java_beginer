import static myio.ioPack.printClass.*;

public class GenFunInter {
  public static void main(String args[]) {
    SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;

    if (isFactor.test(10, 2))
      println("2 is factor of 10");
    println();

    SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
    if (isFactorD.test(212.0, 4.0))
      println("4.0 is a factor of 212.0");
    println();

    SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
    //以上是三种数据类型的处理方式
    String str = "Generic Functional Interface";

    println("Testing String : " + str);
    if (isIn.test(str, "face"))
      println("'face' is found ");
    else
      println("'face' is not found ");


  }
}

interface SomeTest<T> {
  boolean test(T n, T m);
}