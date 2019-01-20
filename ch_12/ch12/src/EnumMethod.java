public class EnumMethod {
  public static void main(String[] ar) {
    Transport tp, tp2, tp3;
    System.out.println("here are all transport constants" +
            "and their oridinal values: ");
    for (Transport t : Transport.values())
      System.out.println(t + " " + t.ordinal());//逐个输出排序码

    tp = Transport.AIRPLANE;
    tp2 = Transport.TRAIN;
    tp3 = Transport.AIRPLANE;
    System.out.println();

    if (tp.compareTo(tp2) < 0)
      System.out.println(tp + " come before " + tp2);
    if (tp.compareTo(tp2) > 0)
      System.out.println(tp2 + " come before " + tp);
    if (tp.compareTo(tp3) == 0)
      System.out.println(tp + " equals " + tp3);

  }
}
