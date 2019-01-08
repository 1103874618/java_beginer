public class moreTh {
  public static void main(String args[]){
    System.out.println("Main thread starting .");
    MytheadIm mt1 = new MytheadIm(("Child_1"));
    MytheadIm mt2 = new MytheadIm(("Child_1"));
    MytheadIm mt3 = new MytheadIm(("Child_1"));
//这里对象一创建就可以执行线程
    do{
      System.out.print(".");
      try {
        Thread.sleep(100);//每100毫秒打一个点
      }catch (InterruptedException e){
        System.out.println("main thread interruptiuted");
      }
    }while (mt1.thrd.isAlive() ||
            mt2.thrd.isAlive() ||
            mt3.thrd.isAlive());//利用isAlive来判断主线程是否需要结束

    System.out.println("Main thread ending");
  }
}
