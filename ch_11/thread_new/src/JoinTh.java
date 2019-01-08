public class JoinTh {
  public static void main(String args[]){
    System.out.println("Main thread starting .");
    MytheadIm mt1 = new MytheadIm(("Child_1"));
    MytheadIm mt2 = new MytheadIm(("Child_2"));
    MytheadIm mt3 = new MytheadIm(("Child_3"));
//这里对象一创建就可以执行线程

      System.out.print(".");
      try {
        mt1.thrd.join();//加入join后主线程会等待直到子线程结束
        System.out.println(mt1.thrd.getName()+ "Join .");

        mt2.thrd.join();
        System.out.println(mt2.thrd.getName()+ "Join .");

        mt2.thrd.join();
        System.out.println(mt2.thrd.getName()+ "Join .");
      }catch (InterruptedException e){
        System.out.println("main thread interruptiuted");
      }
//    }while (mt1.thrd.isAlive() ||
//            mt2.thrd.isAlive() ||
//            mt3.thrd.isAlive());//利用isAlive来判断主线程是否需要结束

    System.out.println("Main thread ending");
  }
}
