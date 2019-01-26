import static myio.ioPack.printClass.*;

public class LamEx {
  public static void main(String af[]){
    MyValue myVal;
    myVal = () -> 98.6;//赋值时就已经创建了实例

    println("A constant value : "+ myVal.getValue());

    MyParamValue myPval = (n) -> 1.0/n;

    println("Reciprocal of 4 is "+ myPval.getValue(4.0));
    println("Reciprocal of 8 is "+ myPval.getValue(8.0));


  }
}

interface MyValue{
  double getValue();
}

interface MyParamValue{
  double getValue(double v);
}
