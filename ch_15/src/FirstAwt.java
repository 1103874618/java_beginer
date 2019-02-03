import java.awt.*;
import java.applet.*;
/*
  <applet code = "simpleApplet" width=200 height = 60>
  </applet>
*/
public class FirstAwt extends Applet {//每个基于awt的小程序必须继承applet


  public void paint(Graphics g) {
    g.drawString("java makes applet easy.", 20, 20);
    //这会输出一个窗
  }
}

//由于applet已经被弃用所以这个程序是运行不了的
