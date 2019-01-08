class Mythead implements Runnable {//实现了runnable接口以后就
  // 获得了在独立线程上运行的能力
  String thrdName;

  Mythead(String name) {//接受线程名
    thrdName = name;
  }

  public void run() {
    System.out.println(thrdName + " staring . ");
    try {
      for (int count = 0; count < 10; count++) {
        Thread.sleep(400);//400毫秒计数一次
        System.out.println(" In " + thrdName + ", count is " + count);
      }
    } catch (InterruptedException e) {
      System.out.println(thrdName + "  interrupted");
    }
    System.out.println(thrdName + " terminating .");
  }
}
public class NewTh{
  public static void main(String args[]){
    System.out.println("Main thread starting .");
    Mythead mt = new Mythead(("Child_1"));//继承runnable接口的对象实现
    Thread newThr = new Thread(mt);//线程对象实现
    newThr.start();

    for (int i = 0;i<50;i++){
      System.out.print(".");
      try {
        Thread.sleep(100);//每100毫秒打一个点
      }catch (InterruptedException e){
        System.out.println("main thread interruptiuted");
      }
    }
    System.out.println("Main thread ending");
  }

}
