import java.io.FileInputStream;
import java.io.IOException;

public class CompFile {
  public static void main(String[] args) {
    int i = 0, j = 0;

    if (args.length != 2) {
      System.out.println("Usage : CompFIles f1,f2");
      return;
    }
    try (FileInputStream f1 = new FileInputStream(args[0]);
         FileInputStream f2 = new FileInputStream(args[1])) {

      do {
        i = f1.read();
        j = f2.read();
        if (i != j) break;//逐位比较,这是最精确的比较
      } while (i != -1 && j != -1);

      if (i != j)
        System.out.println("Files differ.");
      else
        System.out.println("File are the same");
    } catch (IOException exc) {
      System.out.println("I/O Error " + exc);
    }
  }
}
//todo 尝试进行忽略大小写的比较,并且能够自动显示出不同的地方
