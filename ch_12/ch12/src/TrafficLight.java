public class TrafficLight {
  public static void main(String ar[]){
    TraficLightSimulator t1 = new TraficLightSimulator((TrafficLightColor.GREEN));
    for (int i = 0;i<9;i++){
      System.out.println(t1.getColor());
      t1.waitForChange();
    }
    t1.cancel();
  }
}
enum TrafficLightColor{//使用枚举确保只有这些值有效，从而防止意外误用
  RED,GREEN,YELLOW
}

class TraficLightSimulator implements Runnable{//每个交通灯都占据一个独立的线程
  private Thread TraTh;
  private TrafficLightColor tlc;
  boolean stop = false;
  boolean changed = false;
  TraficLightSimulator(TrafficLightColor init){
    tlc = init;
    TraTh = new Thread(this);//把该对象放到一个新建线程上.
    TraTh.start();
  }
  TraficLightSimulator(){
    tlc = TrafficLightColor.RED;
    TraTh = new Thread((this));
    TraTh.start();
  }

  public void run(){
    while(!stop){//用来监控灯等待的行为
      try {//主要分为两个动作,等待,变
        switch (tlc){
          case GREEN:
          Thread.sleep(10000);
          break;
          case YELLOW:
          Thread.sleep(2000);
          case RED:
            Thread.sleep(12000);
            break;
        }
      }catch (InterruptedException er){
        System.out.println(er);
      }
      changeColor();
    }
  }
  synchronized void changeColor(){//控制灯的颜色转换
    switch (tlc){
      case RED:
        tlc = TrafficLightColor.GREEN;
        break;
      case GREEN:
        tlc = TrafficLightColor.YELLOW;
        break;
      case YELLOW:
        tlc=TrafficLightColor.RED;
        break;
    }

    changed = true;
    notify();//这是必要的，因为它调用notify ( )来发出颜色变化已经发生的信号
    //回想一下，notify ( )只能从同步上下文中调用。
  }

  synchronized void waitForChange(){
    try {
      while(!changed)
        wait();//只有changeColor中的notify()才能唤醒
      changed = false;
    }catch (InterruptedException e){
      System.out.println(e);
    }
  }

  synchronized TrafficLightColor getColor(){
    return tlc;
  }

  synchronized void cancel(){
    stop = true;
  }
}