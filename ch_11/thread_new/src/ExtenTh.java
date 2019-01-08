
//当一个类扩展Thread时，它必须覆盖run（）方法，
// 该方法是新线程的入口点。
// 它还必须调用start（）来开始执行新线程。
// 可以覆盖其他Thread方法，但不需要这样做
public class ExtenTh {
  public static void main(String args[]){
    System.out.println("Main thread starting .");
    myThreadEx mt = new myThreadEx(("Child_1"));
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

class myThreadEx extends Thread{
  myThreadEx(String name){
    super(name);
    //调用原来thread的构造函数
    start();
  }
  public void run() {
    System.out.println(getName() + " staring . ");
    try {
      for (int count = 0; count < 10; count++) {
        Thread.sleep(400);//400毫秒计数一次
        System.out.println(" In " + getName() + ", count is " + count);
      }
    } catch (InterruptedException e) {
      System.out.println(getName() + "  interrupted");
    }
    System.out.println(getName() + " terminating .");
  }
  //run中直接调用getname,更加灵活了
}