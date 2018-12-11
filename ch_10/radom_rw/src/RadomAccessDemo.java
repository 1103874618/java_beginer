import java.io.IOException;
import java.io.RandomAccessFile;

public class RadomAccessDemo {
  public static  void main(String args[]){
    double[] data = {19.4,10.1,123.54,33.0,87.9,74.25};
    double d;

    try(RandomAccessFile raf = new RandomAccessFile("random.dat","rw")){//同样会自行创建文件
      //写入文件
      for (int i = 0;i<data.length;i++){
        raf.writeDouble(data[i]);
      }
      raf.seek(0);//定位到第一个double数
      d = raf.readDouble();
      System.out.println("first value is " + d);

      raf.seek(8);//定位到第二个double数(可以看出都是八个字节一个double数的
      d = raf.readDouble();
      System.out.println("second value is " + d);

      raf.seek(8*3);
      d = raf.readDouble();
      System.out.println("forth value is " + d);
      System.out.println();

      //读取其他数

      System.out.println("here is the other value: ");

      for (int i = 0;i<data.length;i+=1){
        raf.seek(8*i);//定位到第i个数
        d = raf.readDouble();
        System.out.print(d + " ");
      }
    }catch (IOException exc){
      System.out.println("I/O ERROR : " + exc);
    }
  }
}
