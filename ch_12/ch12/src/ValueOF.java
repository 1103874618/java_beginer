public class ValueOF {
  public static void main(String[] arg){
    Transport tp;
    System.out.println("here are all transport constants");

    Transport allTransports[] = Transport.values();
    for (Transport t : allTransports)//t是用来接收alltransport里面的每个值的变量
      System.out.println(t);
    System.out.println();

    tp = Transport.valueOf(("AIRPLANE"));
    System.out.println("tp contains " + tp);

  }
}

enum Transport {
  CAR,TRUCK,AIRPLANE,TRAIN,BOAT
}