package GenQueue;

import static myio.ioPack.printClass.*;

public class GenQDemo {
  public static void main(String args[]) {
    Integer iStore[] = new Integer[10];
    GenQueue<Integer> q = new GenQueue<Integer>(iStore);

    Integer iVal;
    println("Demostate a queue of Intergers");

    try {
      for (int i = 0; i < 5; i++) {
        println("adding " + i + " to q.");
        q.put(i);
      }
    } catch (QueueFullException exc) {
      println(exc);
    }
    println();

    try {
      for (int i = 0; i < 5; i++) {
        println("Getting next Integer from q: ");
        iVal = q.get();
        println(iVal);
      }
    } catch (QueueEmptyException exc) {
      println(exc);
    }
    println();

    Double dStore[] = new Double[10];//double型队列
    GenQueue<Double> q2 = new GenQueue<Double>(dStore);
    Double dVal;//用于接收取出来的数据

    println("Demostate a queue of Doubles");

    try {
      for (int i = 0; i < 5; i++) {
        println("adding " + (double) i / 2 + " to q2.");
        q2.put((double) i / 2);
      }
    } catch (QueueFullException exc) {
      println(exc);
    }
    println();

    try {
      for (int i = 0; i < 5; i++) {
        println("Getting next Double from q: ");
        dVal = q2.get();
        println(dVal);
      }
    } catch (QueueEmptyException exc) {
      println(exc);
    }


  }
}
