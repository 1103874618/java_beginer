import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
  public static void main(String[] args) throws IOException {
    int i;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    if (args.length != 2) {
      System.out.println("Usage :　Copy File from to ");
      return;
    }

    try {
      fin = new FileInputStream(args[0]);//文件打开
      fout = new FileOutputStream(args[1]);
      do {
        i = fin.read();
        if (i != -1) fout.write(i);//字符逐个扫描,逐个写入
      } while (i != -1);
    } catch (IOException exc) {
      System.out.println("I/O Error : " + exc);
    } finally {
      try {
        if (fin != null) fin.close();
      } catch (IOException exc) {
        System.out.println("Error Closing Output File");
      }
    }
  }
}
