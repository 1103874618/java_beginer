import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnShowFile {
  public static void main(String[] args) {
    int i;
    FileInputStream fin = null;//先初始化为null

    if (args.length != 1) {
      System.out.println("Usage : ShowFile FIle");
      return;
    }

    try {
      fin = new FileInputStream(args[0]);
      do {
        i = fin.read();
        if (i != -1) System.out.print((char) i);
      } while (i != -1);
    } catch (FileNotFoundException exc) {
      System.out.println("Error reading  file");
    } catch (IOException exc) {
      System.out.println("An I/o Error Occurred");
    } finally {
      try {
        if (fin != null)
          fin.close();
      } catch (IOException exc) {
        System.out.println("Error Closing File");
      }
    }
  }
  //在这种方法中，请注意fin被初始化为null。然后，在最后的块中，
  // 只有当fin不为空时，文件才会关闭。这很有效，因为只有成功打开文件，fin才会非空。
  // 因此，如果打开文件时出现异常，将不调用close ( )

  //而且因为FileNotFoundException是IOException的一个子类，
  // 所以不需要单独捕获它。例如，这个catch子句可以用来捕获这两个异常，
  // 而不需要单独捕获FileNotFoundException。在这种情况下，
  // 将显示描述错误的标准异常消息,也就错误描述不会那么精确
}
