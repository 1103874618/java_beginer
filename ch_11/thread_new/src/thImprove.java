class MytheadIm implements Runnable {//实现了runnable接口以后就
  // 获得了在独立线程上运行的能力
  Thread thrd;

  MytheadIm(String name) {//接受线程名
    thrd = new Thread(this,name);
    thrd.start();
  }

  public void run() {
    System.out.println(thrd.getName() + " staring . ");
    try {
      for (int count = 0; count < 10; count++) {
        Thread.sleep(400);//400毫秒计数一次
        System.out.println(" In " + thrd.getName() + ", count is " + count);
      }
    } catch (InterruptedException e) {
      System.out.println(thrd.getName() + "  interrupted");
    }
    System.out.println(thrd.getName() + " terminating .");
  }
}
public class thImprove{
  public static void main(String args[]){
    System.out.println("Main thread starting .");
    MytheadIm mt = new MytheadIm(("Child_1"));
//这里对象一创建就可以执行线程
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
