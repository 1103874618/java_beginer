public class ValueOF {
  public static void main(String[] arg){
    Transport tp;
    System.out.println("here are all transport constants");

    Transport allTransports[] = Transport.values();
    for (Transport t : allTransports)//t是用来接收alltransport里面的每个值的变量
      System.out.println(t);
    //这里其实不需要alltransport这个中间变量,
    // 直接for (Transport t : transport.value())就行了
    System.out.println();

    tp = Transport.valueOf(("AIRPLANE"));
    //如上所述，valueOf（）返回与作为字符串表示的常量名称关联的枚举值
    System.out.println("tp contains " + tp);

  }
}

enum Transport {
  CAR,TRUCK,AIRPLANE,TRAIN,BOAT
}