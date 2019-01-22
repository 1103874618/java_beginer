import static java.lang.System.out;
//import static org.graalvm.compiler.replacements.Log.println;

public class GenEx {
  public static void main(String arg[]){
    Gen<Integer> iob;
    iob = new Gen<Integer>(88);//这里用到了Interger
    iob.showType();
    int v = iob.getOb();
    out.println("value : " + v);
    out.println();

    Gen<String> strOb= new Gen<String>("generics test");
    strOb.showType();
    String str = strOb.getOb();
    out.println("value: "+str);
  }
}

class Gen<T>{
  T ob;//声明一个类型为T的对象
  Gen(T o){
    ob = o;
  }

  T getOb(){
    return ob;
  }

  void showType(){
    out.println("Type of T is "+ ob.getClass().getName());

  }
}