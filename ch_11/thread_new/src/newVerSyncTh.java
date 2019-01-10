public class newVerSyncTh {
  public static void main(String[] args){
    int a[] = {1,2,3,4,5};
    NewMySyncTh tm1=new NewMySyncTh("child_1",a);
    NewMySyncTh tm2=new NewMySyncTh("child_2",a);

    try {
      tm1.thrd.join();
      tm2.thrd.join();
    }catch (InterruptedException e){
      System.out.println("Main thread interrupted");
    }
  }
}

class NewSumArray {
  private int sum;

 int sumArray(int nums[]) {
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
class NewMySyncTh implements Runnable{
  Thread thrd;
  static NewSumArray sa = new NewSumArray();//因为他是静态的,所以可以被所有线程共享
  int a[];
  int answer;

  NewMySyncTh(String name, int nums[]) {
    thrd = new Thread(this, name);
    a = nums;
    thrd.start();
  }
  public void run() {
    int sum;
    System.out.println(thrd.getName() + " staring .");

    synchronized (sa){//使用同步块以后,一个时段只能有一个对象调用该方法
      answer = sa.sumArray(a);
    }

    System.out.println("Sum for" + thrd.getName() + " is " + answer);
    System.out.println(thrd.getName() + " terminating ");

  }
}

