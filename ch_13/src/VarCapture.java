import static myio.ioPack.printClass.*;
public class VarCapture {
  public static void main(String args[]){
    int num = 10;

    Myfunc myLam = (n)->{
      int v = num + n;//这种不修改原变量的用法是可以的
      //num++; 这种就不行
      return  v;
    };

    println(myLam.func(8));
    //num = 9;
    //这也会产生错误,因为它移除了num的有效最终状态
  }
}

interface Myfunc{
  int func (int n);
}

