public class StatusKeyWord {
  public static void main(String args[]){
    MyThreadSk ob1 = new MyThreadSk("my thread");
    try {
      Thread.sleep(1000);//促使ob1线程开始执行

      ob1.mysuspend();
    System.out.println("Suspending thread");
    Thread.sleep(1000);

    ob1.myresume();
    System.out.println("Resume thread");
    Thread.sleep(1000);

    ob1.mysuspend();
    System.out.println("Suspending thread");
    Thread.sleep(1000);

    ob1.myresume();
    System.out.println("Resume thread");
    Thread.sleep(1000);

    ob1.mysuspend();
    System.out.println("Stopping thread");
    Thread.sleep(1000);
    ob1.mystop();
  }catch (InterruptedException e){
    System.out.println("Main thread Interrupted");
  }

    try {
      ob1.thrd.join();
    }catch (InterruptedException e){
      System.out.println("Main thread Interrupted");
    }

    System.out.println("Main thread exiting");
  }
}
class MyThreadSk implements Runnable{
  Thread thrd;
  boolean suspended;
  boolean stoped;

  MyThreadSk(String name){
    thrd = new Thread(this,name);
    suspended = false;
    stoped = false;
    thrd.start();
  }

  public void run(){
    System.out.println(thrd.getName() + " staring.");
    try {
      for (int i = 1;i<1000;i++){
        System.out.print(i + " ");
        if ((i%10) == 0){
          System.out.println();
          Thread.sleep(250);
        }

        synchronized (this){//此同步块持续检查suspend和stop的值
          while(suspended){//睡眠250之后若suspend 为恢复则继续挂起
            wait();
          }
          if (stoped) break;//break就会导致整个程序完成
          //这个stop不是应该由java自己监控,一旦为真就立刻停止执行吗?
        }
      }
    }catch (InterruptedException e){
      System.out.print(thrd.getName() + "线程中断");
    }
    System.out.println(thrd.getName() + " exciting .");

  }

  synchronized void mystop(){
    stoped = true;

    suspended = false;
    notify();
  }

  synchronized  void mysuspend(){
    suspended = true;
  }

  synchronized void myresume(){
    suspended = false;
    notify();
  }
}
