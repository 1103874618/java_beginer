import java.io.*;

public class WordStatistic {//获取文章并统计单词出现的字数

  void wordRead() throws IOException { //从文件中读取文章
    String filePath = "src\\file.txt";
    //File file = new File(filePath);

    FileReader fr = new FileReader(filePath);//文件内容转换成字节流
    BufferedReader word = new BufferedReader(fr);//

    char c[] = new char[20];
    if (word.markSupported()) {
      System.out.println("mark() method is supported");
      word.mark(1000);
    }

    if (word.ready()) {
      System.out.println(word.readLine());
      word.reset();
      word.read(c);//不停读取直到数组被填满或字符读取完毕
      for (int i = 0; i < 20; i++) {
        System.out.print((char) c[i]);
      }
      System.out.println();

      word.reset();
      for (int i = 0; i < 8; i++) {
        System.out.print((char) word.read());
      }
    }
  }

  String wordInput()throws IOException {//接受用户输入
    BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));
    String tx = input.readLine();//必须加上这个readline才能进行输入
    return tx;

  }

  void wordRead(BufferedReader word) throws IOException {
    char c[] = new char[20];
    if (word.markSupported()) {
      System.out.println("mark() method is supported");
      word.mark(1000);
    }

    if (word.ready()) {
      System.out.println(word.readLine());
      word.reset();
      word.read(c);//不停读取直到数组被填满或字符读取完毕
      for (int i = 0; i < 20; i++) {
        System.out.print((char) c[i]);
      }
      System.out.println();

      word.reset();
      for (int i = 0; i < 8; i++) {
        System.out.print((char) word.read());
      }
    }
  }


}

class ReadDemo {
  public static void main(String[] args) throws IOException {
    try {

      WordStatistic word = new WordStatistic();
//      word.wordRead();
      System.out.println("请输入文章: ");
      String inputWord = word.wordInput();
      word.wordRead(inputWord);

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
