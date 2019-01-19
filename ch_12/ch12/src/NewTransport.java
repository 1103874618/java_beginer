public class NewTransport {
  public static void main(String[] arg) {
    Transport tp;

    System.out.println("Typcial speed for an airplane is " +
            NTransport.AIRPLANE.getSpeed() +
            "mile per hour.\n");

    System.out.println("all transport speeds: ");
    for (NTransport t : NTransport.values())
      System.out.println(t + " typical speed is " +
              t.getSpeed() +
              "mile per hour.");
  }
}

enum NTransport {
  CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);

  private int speed;

  NTransport(int s) {//上面的每个常量都有一个NTransport构造函数
    speed = s;
  }

  int getSpeed() {
    return speed;
  }
}

