public class SyncTh {
  public static void main(String[] args){
    int a[] = {1,2,3,4,5};
    MySyncTh tm1=new MySyncTh("child_1",a);
    MySyncTh tm2=new MySyncTh("child_2",a);

    try {
      tm1.thrd.join();
      tm2.thrd.join();
    }catch (InterruptedException e){
      System.out.println("Main thread interrupted");
    }
  }
}

class SumArray {
  private int sum;

  synchronized int sumArray(int nums[]) {
    sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      System.out.println("Running total for " +
              Thread.currentThread().getName() +
              " is " + sum);

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        System.out.println("thread interrupted ");
      }

//对12345求和,等待10毫秒,over
      //同步会导致先创建的线程先执行,后创建的线程后执行
    }
    return sum;
  }
}

class MySyncTh implements Runnable{
  Thread thrd;
  static SumArray sa = new SumArray();
  int a[];
  int answer;

  MySyncTh(String name, int nums[]) {
    thrd = new Thread(this, name);
    a = nums;
    thrd.start();
  }

  public void run() {
    int sum;
    System.out.println(thrd.getName() + " staring .");

    answer = sa.sumArray(a);
    System.out.println("Sum for" + thrd.getName() + " is " + answer);
    System.out.println(thrd.getName() + " terminating ");

  }
}