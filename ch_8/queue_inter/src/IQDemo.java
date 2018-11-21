import java.awt.*;
import java.lang.management.PlatformLoggingMXBean;

class FixedQueue implements QueueInter {
  private char q[];
  private int putloc, getloc;

  public FixedQueue(int size) {
    q = new char[size];
    putloc = getloc = 0;
  }

  public void put(char ch) {
    if (putloc == q.length) {
      System.out.println(" -  Queue is full");
      return;
    }

    //q[putloc++] = ch --这种傻逼++代码最好少用
    q[putloc] = ch;
    putloc = putloc + 1;


  }

  public char get() {
    if (getloc == putloc) {
      System.out.println(" - Queue is empty.");
      return (char) 0;
    }
    return q[getloc++];//这里没有办法,必须用++来实现简写,因为return无法容纳多个语句
  }
}

class CircularQueue implements QueueInter {
  private char[] q;
  private int putloc, getloc;

  public CircularQueue(int size) {//初始化队列长度
    q = new char[size + 1];//为什么数组的长度要故意加长一位?
    putloc = getloc = 0;
  }

  public void put(char ch) {
    if (putloc + 1 == getloc | ((putloc == q.length - 1) & (getloc == 0))) {//判满条件就与固定数组有些不一样,不是要等到跑到数组尾端就算判满,而是下一个字符插入时会导致有一个未检索的字符被覆盖时才算满
      System.out.println(" - Queue is full.");
      return;
    }
    q[putloc] = ch;
    putloc = putloc + 1;//终于知道为什么数组要故意加长一位了.是因为这里都要加一,为了保持算法的一致性
    if (putloc == q.length) putloc = 0;//输入引用归零
  }


  public char get() {
    if (getloc == putloc) {
      System.out.println(" - Queue is empty");
      return (char) 0;
    }
    char ch = q[getloc++];
    if (getloc == q.length) getloc = 0;
    return ch;
  }
}

//动态队列实现(非循环)
class DynQueue implements QueueInter {
  private char q[];
  private int putloc, getloc;

  public DynQueue(int size) {
    q = new char[size];
    putloc = getloc = 0;
  }

  public void put(char ch) {
    if (putloc == q.length) { //插入引用到达数组尾部,还不用判满,因为他永远都不会满
      char[] t = new char[q.length * 2];//新建一个两倍长的数组

      for (int i = 0; i < q.length; i++) {//数据转移
        t[i] = q[i];
      }
      q = t;//代替之前的数组,这里在打代码的时候不小心出现了一个错误,这一行不小心写到上面的for里面去了,导致输出异常
      //可以反思一下为什么放到for里就会输出异常,数据每转移一次,t就交由q引用,这是问题所在,t本是空的,赋值第一个空位后,q立刻变成t,第二次
      // 执行时,q的第二个位置已经是空的了,再把空赋值给t,如此循环,而数组输出空时就会出现口口口口口口口字样.
    }

    q[putloc] = ch;
    putloc = putloc + 1;
  }

  public char get() {
    if (getloc == putloc) {
      System.out.println(" - Queue is empty.");
      return (char) 0;
    }
    return q[getloc++];
  }
}

public class IQDemo {
  public static void main(String[] args) {
    FixedQueue qF = new FixedQueue(10);
    DynQueue qD = new DynQueue(5);
    CircularQueue qC = new CircularQueue(10);

    QueueInter iQ;

    char ch;
    int i;

    iQ = qF;
    for (i = 0; i < 10; i++)
      iQ.put((char) ('A' + i));
    System.out.print("Contents of fixed queue: ");
    for (i = 0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }
    System.out.println();

    iQ = qD;//接着对动态队列进行操作
    for (i = 0; i < 30; i++)
      iQ.put((char) ('Z' - i));

    System.out.print("Content of dynamic queue: ");
    for (i = 0; i < 30; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }
    System.out.println();

    iQ = qC;
    for (i = 0; i < 10; i++)
      iQ.put((char) ('A' + i));
    System.out.print("Contents of circular queue : ");
    for (i = 0; i < 10; i++) {
      ch = iQ.get();
      System.out.print(ch);
    }


  }
}

//由此看来接口的作用就是保留最基本的,最直接需要的功能方法,其他不需要的东西屏蔽掉,让类的使用过程更加简洁明确

//练习:可以试一下创建DynQueue的循环版本。 向ICharQ添加reset（）方法，重置队列。 然后创建一个静态方法，将一种类型的队列的内容复制到另一种队列中