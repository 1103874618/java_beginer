public class Annotion {
  public static void main(String na){
    Myclass myObj = new Myclass("test");

    System.out.println(myObj.getMas());
  }
}
@Deprecated//意思就是这个类已经被废弃了
class Myclass{
  private String mas;
  Myclass(String m){
    mas = m;
  }

  @Deprecated//该方法已被废弃
  String getMas(){
    return mas;
  }
}

//结果是这程序运行不起来
