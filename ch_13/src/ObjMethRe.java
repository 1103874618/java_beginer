import static myio.ioPack.printClass.*;

public class ObjMethRe {
  public static void main(String args[]) {
    boolean result;

    MyIntNum myNum = new MyIntNum(12);
    MyIntNum myNum2 = new MyIntNum(16);

    IntPredicate2 ip = myNum::isFactor;//类似拉姆达的赋值

    result = ip.test(3);

    if (result)
      println("3 is a factor of " + myNum.getNum());
    ip = myNum2::isFactor;
    result = ip.test(3);
    if (!result) println("3 is not factor of" + myNum2.getNum());
  }
}

interface IntPredicate2 {
  boolean test(int n);
}

class MyIntNum {//同样是普通类储存多个实现
  private int v;

  MyIntNum(int x) {
    v = x;
  }

  int getNum() {
    return v;
  }

  boolean isFactor(int n) {
    return (v % n) == 0;
  }
}