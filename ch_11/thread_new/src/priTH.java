import javax.print.attribute.standard.PrinterURI;

public class priTH {
  public static void main(String[] args) {
    Priority mt1 = new Priority("High");
    Priority mt2 = new Priority("low");

    mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
    mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);

    mt1.thrd.start();
    mt2.thrd.start();

    try {
      mt1.thrd.join();
      mt2.thrd.join();
    } catch (InterruptedException e) {
      System.out.println("main thread interruption");
    }
    System.out.println("high count to" + mt1.count);
    System.out.println("low count to" + mt2.count);

  }
}

class Priority implements Runnable {
  int count;
  Thread thrd;

  static boolean stop = false;
  static String currentName;

  Priority(String name) {
    thrd = new Thread(this, name);
    count = 0;//每个线程都有自己的count
    currentName = name;
  }

  public void run() {
    System.out.println(thrd.getName() + " staring.");
    do {
      count++;

      if (currentName.compareTo(thrd.getName()) != 0) {
        currentName = thrd.getName();
        System.out.println("In " + currentName);
      }
    } while (stop == false && count < 10000000);
    stop = true;
  }
}
