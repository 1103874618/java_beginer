import java.io.IOException;
//初次使用bytestream
public class ByteInputStream {
  public static void main(String[] args) throws IOException {
    byte data[] = new byte[10];
    System.out.println("enter some characters");
    System.in.read(data);//将字节数据读取到data数组中
    System.out.print("you enter : ");
    for (int i = 0; i < data.length; i++)
      System.out.print((char) data[i]);//由结果可以得出一个字符(包括空格)占据一个数组位,而每一个数组为只存一个字节
  }

}
