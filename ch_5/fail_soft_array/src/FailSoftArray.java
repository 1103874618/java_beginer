public class FailSoftArray {
  private int[] a;
  private int errval;//失败返回数据
  public int length;

  public FailSoftArray(int size, int errv) {
    a = new int[size];//数组赋值
    errval = errv;
    length = size;

  }

  public int get(int index) {//取得数组的值
    if (indexOK(index)) return a[index];
    return errval;//获取失败会返回错误码-1
  }

  public boolean put(int index, int val) {//数字推入数组
    if (indexOK(index)) {
      a[index] = val;
      return true;
    }
    return false;//检测到超出范围时自动返回失败,防止报错
  }

  private boolean indexOK(int index) {//判断数组长度是否适合
    if (index >= 0 & index < length) return true;
    return false;
  }
}



class FSDemo {
  public static void main(String args[]) {
    FailSoftArray fs = new FailSoftArray(5, -1);
    int x;

    System.out.println("Fail quietly . ");
    for (int i = 0; i < (fs.length * 2); i++)
      fs.put(i, i * 10);//故意超范围推入数据

    for (int i = 0; i < (fs.length * 2); i++) {//超范围读取数据
      x = fs.get(i);
      if (x != -1) System.out.print(x + " ");
    }

    System.out.println("");

    //下面捕捉错误
    System.out.println("\nFail with error reports.");
    for (int i = 0; i < (fs.length * 2); i++)
      if (!fs.put(i, i * 10))
        System.out.println("index " + i + " out-of-bounds");

    for (int i = 0; i < (fs.length * 2); i++) {
      x = fs.get(i);
      if (x != -1) System.out.print(x + " ");
      else
        System.out.println("index " + i + " out-of-bounds");
    }

  }
}
