public class Constr {
  int a;
  int b;

  Constr(int al, int bl) { //这是一个有参数的构造函数
    a = al;
    b = bl;
  }

}

class cc extends Constr {
  int c;

  cc(int a, int b) {
    super(a, b);//如果没有指定super,相当于默认调用了super(),这里会报错显示父类没有默认构造函数
  }
}
