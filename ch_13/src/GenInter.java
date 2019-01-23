import static myio.ioPack.printClass.*;


public class GenInter {
  public static void main(String[] at) {
    Integer x[] = {1, 2, 3};
    MyClass<Integer> ob = new MyClass<Integer>(x);//整数类型的判断
    if (ob.contains(2))
      println("2 is in ob");
    else
      println("2 is NOT in ob");

    if (ob.contains(5))
      println("5 is in ob");
    else
      println("5 is NOT in ob");
  }
}

interface Containment<T> {
  boolean contains(T o);
}

class MyClass<T> implements Containment<T> {
  T[] arrayRef;

  MyClass(T[] o) {
    arrayRef = o;
  }

  public boolean contains(T o) {
    for (T x : arrayRef)
      if (x.equals(o)) return true;
    return false;
  }
}
