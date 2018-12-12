import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class FileWrite {
  public static  void  main(String[] a){
    String str;
    BufferedReader br =
            new BufferedReader(
                    new InputStreamReader(System.in)
            );
    System.out.println("Enter text ('stop' to quit)");

    try (FileWriter fw = new FileWriter("test.txt")){//创建一个新文件
      do {
        System.out.print(" : ");
        str = br.readLine();//文本暂存在这里

        if (str.compareTo("stop") == 0) break;

        str = str + "\r\n";//这里可以看出我们虽然是在控制台一行一行地输入,但回车是要自己加的
        fw.write(str);//写入
      }while (str.compareTo("stop") != 0);
    }catch (IOException exc){
      System.out.println("io错误" + exc);
    }
  }
}
