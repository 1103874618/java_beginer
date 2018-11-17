import java.io.*;

public class Division {
  int input()throws IOException{
    BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
    String str = input.readLine();
    int num = Integer.parseInt(str) ;
    return  num;
  }
}
class Demo{

  public static void main(String[] args)throws IOException{
    Division demo = new Division();
    int num1,num2;
    System.out.println("请输入第一个数字");
    num1 = demo.input();
    System.out.println("请输入第二个数字");
    num2 = demo.input();

    try{
      int div;
      div = num1/num2;
      System.out.println(num1+"与"+num2+"的商为"+div);
    }
    catch (){
        //学校的机器上已经写完...到时再复制过来吧
    }
  }
}
