import static myio.ioPack.printClass.*;

public class CompArray {

}

class GenMethod {
  static <T extends Comparable<T>, V extends T> boolean
  arraysEqual(T[] x, V[] y) {//声明为静态是为了方便其他类独立调用
    if (x.length != y.length) return false;//先比较长度

    for (int i = 0;i< x.length;i++){
      if (!x[i].equals(y[i])) return false;
    }
    return  true;
  }

  public static void main(String[] args){
    Integer num[] = {1,2,3,4,5};
    Integer num2[] = {1,2,3,4,5};
    Integer num3[] = {1,2,7,4,5};
    Integer num4[] = {1,2,7,4,5,6};

    if (arraysEqual(num,num))
      println("num equals num");
    if (arraysEqual(num,num2))
      println("num equeals num2");
    if (arraysEqual(num,num3))
      println("num equeals num3");
    if (arraysEqual(num,num4))
      println("num equeals num4");

   // Double dvals[] = {1.1,2.2,3.3,4.4,5.5};
    //不同数据类型的数组是不能比较的
  }
}