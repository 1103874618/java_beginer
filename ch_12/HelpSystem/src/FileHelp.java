import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class FileHelp {
  public static void main(String args[]){
    Help hlp = new Help("helpfile.txt");
    String topic;
    System.out.println("try the help system ." + "Enter stop to end ");
    do{
      topic  = hlp.getSelection();

      if (!hlp.helpOn(topic)){//这里吧helpOn的执行蕴含在条件中,
        // 这里可以看出返回false更方便后面进行条件判断
        System.out.println("Topic not found . \n");
      }
    }while (topic.compareTo("stop") != 0);
  }
}

class Help {
  String helpfile;

  Help(String fname) {//文件名作为构造函数的参数,因此可以传入
    // 不同的文件实现不同的帮助
    helpfile = fname;
  }

  boolean helpOn(String what) {
    int ch;
    String topic,info;
    try(BufferedReader helpRdr =
            new BufferedReader((new FileReader(helpfile))))
    {
      do {
        //读取字符直到#出现
        ch = helpRdr.read();

        if (ch == '#'){//ch的作用是接受检测内容
          topic = helpRdr.readLine();//接受主题
          if (what.compareTo(topic) == 0){//what应该是需要检索的主题名
            do{
              info = helpRdr.readLine();
              if (info != null){
                System.out.println(info);
              }
            }while ((info != null)&&
                    (info.compareTo("") != 0));//通过与无字符比较来判断是否读完
            return  true;
          }
        }
      }while (ch != -1);
    }catch (IOException e){
      System.out.println("Error accessing help file.");
      return false;
    }
    return false;
  }

  //帮助类还提供了一个名为getSelection（）的方法。 它会提示用户输入主题并返回用户输入的主题字符串
  String getSelection(){
    String topic = "";

    BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    System.out.print("Enter topic: ");
    try {
      topic = br.readLine();
    }catch(IOException e){
      System.out.println("error reading console .");
    }
    return topic;
  }
}

//这程序有一个美中不足之处就是最后输入stop时依然会出现not found
 //字样,不过改正也很简单