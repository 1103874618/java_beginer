import static myio.ioPack.printClass.*;

public class ConRe {
  public static void main(String arg[]) {
    MyFunc myClassCons = Myclass::new;//就是把类Myclass的构造函数赋上去了
   //因为接口中的func参数是string,
    // 所以对应的构造函数也是参数为string的构造函数,
    // 而不是那个没参数的默认构造函数
    Myclass mc = myClassCons.func("testing");
    println("str in mc is " + mc.gerStr());
  }

}

class Myclass {
  private String str;

  Myclass(String s) {
    str = s;
  }

  Myclass() {
    str = "";
  }

  String gerStr() {
    return str;
  }
}

interface MyFunc {
  Myclass func(String s);
}