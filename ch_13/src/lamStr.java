import static myio.ioPack.printClass.*;

public class lamStr {
  public static void main(String args[]){
    StringTest isIn = (a,b)->a.indexOf(b) != -1;

    String str = "This is a test";
    println("testing string : "+str);

    if (isIn.test(str,"is a"))
      println("'is a' found." );
    else
      println("'is a ' not found");

    if (isIn.test(str,"xyz"))
      println("'xyz' found ");
    else
      println("'xyz' not found ");
  }
}

interface StringTest{
  boolean test(String aStr,String bStr);
}

































