import static java.lang.System.out;
import static myio.ioPack.printClass.*;//自封装输出方法包


public class GenTwo {
  public static void main(String args[]) {
    TwoGen<Integer, String> tgObj =
            new TwoGen<Integer, String>(88, "Generics");
    tgObj.showTypes();

    int v = tgObj.getOb1();
    out.println("value: " + v);

    String str = tgObj.getOb2();
    out.println("value: "+ str);

    println("dfd");

  }
}

class TwoGen<T, V> {
  T ob1;
  V ob2;

  TwoGen(T o1, V o2) {
    ob1 = o1;
    ob2 = o2;
  }

  void showTypes() {
    out.println("Type of T is " +
            ob1.getClass().getName());
    out.println("Type of V is " +
            ob2.getClass().getName());
  }

  T getOb1() {
    return ob1;
  }

  V getOb2() {
    return ob2;
  }
}