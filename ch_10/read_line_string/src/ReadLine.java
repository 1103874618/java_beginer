import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadLine {
  public static void main(String[] a)
          throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    System.out.println("Enter lines of texts");
    System.out.println("enter 'stop' to quit");
    do {
      str = br.readLine();
      System.out.println(str);
    } while (!str.equals("stops"));//只有当单独一行输入stops时才会停止
  }
}
