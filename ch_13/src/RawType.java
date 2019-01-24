import static myio.ioPack.printClass.*;

public class RawType {
  public static void main(String args[]) {
    RGen<Integer> iOb = new RGen<Integer>(88);

    RGen<String> strOb = new RGen<String>("Generics");

    RGen raw = new RGen(new Double(98.6));//不加上尖括号类型的话
    //一个raw(原始) 类型就会生成

    double d = (Double) raw.getOb();
    println("value: " + d);

    // int i = (Integer) raw.getOb();此用法会报错
    //raw包含Double值而不是整数值的问题。 但是，在编译时无法检测到这种情况，
    // 因为原始类型未知。 因此，此语句在运行时失败

    //可以为原始类型的变量分配对任何类型Gen对象的引用
    strOb = raw;//ok,但是没有类型安全,所以安全是暂时的(强类型特征被削弱)
    raw = iOb;//ok,但是没有类型安全

    //如果strOb再get其中的值,立马就会报错,
    // 因为他本来是容纳string的对象,结果却被塞了一个来路不明的double进来

    //而raw接受了一个泛型对象,也一样有问题,如果执行下面代码
    // d = (Double) raw.getob(); 会出现runnrtime--error,原因差不多
    //因此对于ok,但有类型危险的代码,java会产生一个unchecked warning
    //例如不带尖括号的泛型类会产生一个unchecked warning
    //原始类型赋值给泛型类会出现一个unchecked warning
    //但raw = iOb; 不会有warning 因为单纯的赋值不会进一步产生安全性损失,
    // 损失早在raw创建的时候就已经造成了
  }
}

class RGen<T> {
  T ob;

  RGen(T o) {
    ob = o;
  }

  T getOb() {
    return ob;
  }
}

