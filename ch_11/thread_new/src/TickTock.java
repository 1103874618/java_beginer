public class TickTock {
  String state;
  synchronized  void tick(boolean running){
    if(!running){
      state = "ticked";
      notify();//会唤醒tock的线程(唤醒在此对象监视器上等待的单个线程。
      return;//只要传入假,程序终止
    }

    System.out.print("tick  ");
    state = "ticked";
    notify();
    try {
      while (!state.equals("tocked"))//使用while循环检查此条件
        // 可防止虚假唤醒错误地重新启动线程
        // 。 如果wait（）返回时状态不等于“tocked”，
        // 则表示发生了虚假唤醒，而wait（）再次被调用
        wait();
    }catch (InterruptedException e){
      System.out.println("Thread interrupted");
    }
  }

  synchronized  void tock(boolean running ){
    if(!running ){
      state = "tocked";
      notify();
      return;
    }
    System.out.println( "tock");

    state = "tocked";

    notify();
    try {
      while (!state.equals("ticked"))
        wait();
    }catch (InterruptedException e){
      System.out.println("thread interrupted");
    }
  }
}

class MyThreadTT implements Runnable{
  Thread thrd;
  TickTock ttOb;
  MyThreadTT(String name,TickTock tt){
    thrd = new Thread(this,name);
    ttOb = tt;
    thrd.start();
  }

  public void run(){//run默认执行
    if (thrd.getName().compareTo("Tick") == 0){
      //当前运行线程为Tick时
//      System.out.println("if动了");
      //这里if其实只判断了一次,有点违反常理
      for (int i = 0;i<5;i++) ttOb.tick(true);//tick 五下
      ttOb.tick(false);
    }else {
      for (int i = 0;i<5;i++) ttOb.tock(true);//tock五下
      ttOb.tock(false);
    }
  }
}

class ThreadCom{
  public static void main(String args[]){
    TickTock tt = new TickTock();
    MyThreadTT mt1 = new MyThreadTT("Tick",tt);
    MyThreadTT mt2 = new MyThreadTT("Tock",tt);

    try{
      mt1.thrd.join();//新建线程
      mt2.thrd.join();
    }catch (InterruptedException e){
      System.out.println("Main thread interrupted.");
    }
  }
}
//主要就是两条线程分别执行tick和tock两个方法,两个线程交替唤醒,交替执行
//最后是两个线程两个run在交替执行