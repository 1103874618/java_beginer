import java.awt.*;
import java.applet.*;

/*
<applet code = "Banner" width = 300 height = 50>
</applet>
 */
//实现runnable的原因是小程序会使用第二个线程来控制横幅移动
public class Banner extends Applet implements Runnable {
  String msg = "java rules the web";//横幅的内容
  Thread t;
  boolean stopFlag;

  public void init() {
    t = null;
  }

  public void start() {
    t = new Thread(this);
    stopFlag = false;
    t.start();//调用了thread的start方法 促使thread的run方法开始执行

  }

  public void run() {
    for (; ; ) {
      try {
        repaint();//无限重绘
        Thread.sleep(250);
        if (stopFlag)
          break;
      } catch (InterruptedException e) {
      }
    }
  }

  public void stop(){
    stopFlag=true;
    t=null;
  }

  public void paint(Graphics g){
    char ch ;
    ch = msg.charAt(0);
    msg.substring(1,msg.length());
    msg += ch;
    g.drawString(msg,50,30);

  }

  //当stopFlag为真时线程的run方法终止,同时t被指向null,因此线程不在被引用,会被自动回收掉
}
