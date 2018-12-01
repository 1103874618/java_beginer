import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
  public static void main(String[] args) {
    int i;
    FileInputStream fin;

    if (args.length != 1) {//这是用来确保是否有一个文件已经被指定
      System.out.println("Usage : ShowFile FIle");
      return;
    }

    try {
      fin = new FileInputStream(args[0]);//打开文件,这里args中的数据是通过命令行参数传入的,自己编辑配置
    } catch (FileNotFoundException exc) {
      System.out.println("File Not Found");
      return;
    }

    try {
      do {
        i = fin.read();
        if (i != -1) System.out.print((char) i);
      } while (i != -1);
    } catch (IOException exc) {
      System.out.println("Error reading  file");
    }

//    try {
//      fin.close();
//    } catch (IOException exc) {
//      System.out.println("Error closing file.");
//    }

    //前面的示例在读取文件的try块完成后关闭文件流。尽管这种方法有时很有用，
    // 但Java支持一种经常是更好的选择的变体。
    // 变化是调用finally块中的close ( )。在
    // 这种方法中，访问文件的所有方法都包含在一个try块中，
    // 最后一个块用于关闭文件。这样，无论try块如何终止，文件都会关闭。
    finally {
      try{
        fin.close();
      }catch (IOException exc){
        System.out.println("Error Closing File");
      }
    }
    //一般来说，这种方法的一个优点是，
    // 如果访问文件的代码由于一些与I / O无关的异常而终止，文件仍然会被最后的块关闭
    //有时，将打开文件并访问文件的程序部分打包在一个try块内(而不是将两者分开)，然后使用finally块关闭文件会更容易。
    // 例如，AnShowFile里面是编写showFile程序的另一种方法

  }
}
