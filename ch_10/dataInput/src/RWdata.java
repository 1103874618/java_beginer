import java.io.*;

public class RWdata {
  public static void main(String[] args) {
    int i = 10;
    double d = 1023.56;
    boolean b = true;

    try (DataOutputStream dataOut =
                 new DataOutputStream(new FileOutputStream("testdata"))) {//这里的testdata是自己创建在根目录的
      //文件打开
      System.out.println("Wiriting " + i);
      dataOut.writeInt(i);
      System.out.println("Wiriting" + d);
      dataOut.writeDouble(d);
      System.out.println("Wiriting " + b);
      dataOut.writeBoolean(b);
      System.out.println("Wiriting " + 12.2 * 7.4);
      dataOut.writeDouble(12.2 * 7.4);
    } catch (IOException exc) {
      System.out.println("Write error");
      return;
    }

    System.out.println();

    //开始读取数据回来
    try (DataInputStream dataIn =
                 new DataInputStream(new FileInputStream("testdata"))) {
      //读取二进制数据
      i = dataIn.readInt();
      System.out.println("Reading" + i);
      d = dataIn.readDouble();
      System.out.println("reading" + d);
      b = dataIn.readBoolean();
      System.out.println("reading" + d);
      d = dataIn.readDouble();
      System.out.println("reading" + d);
    } catch (IOException exc) {
      System.out.println("read error");
    }
  }
}
