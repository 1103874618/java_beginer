public class UseMain {
//要访问主线程，必须获取引用它的thread对象。
// 您可以通过调用currentThread ( )方法来实现这一点，
// 该方法是Thread的静态成员。这里展示了它的一般形式
//static Thread currentThread( )
//这个方法返回当前被调用的线程,所以在主线程执行时,
// 你在其中调用currentThread()就可以获得主线程的引用,
// 一旦你获取了引用你就可以像控制其他线程一样控制主线程

  public static void main(String args[]) {
    Thread thrd;

    thrd = Thread.currentThread();//获取主线程

    System.out.println("Main thread is called : " + thrd.getName());
    System.out.println("Priority: " + thrd.getPriority());

    System.out.println();

    System.out.println("Setting name and priority.\n");
    thrd.setName("Thread_1");
    thrd.setPriority(Thread.NORM_PRIORITY + 3);

    System.out.println("Main thread is now called : " + thrd.getName());
    System.out.println("Priority is now  " + thrd.getPriority());

  }
}
//对主线程的一切操作都要十分小心