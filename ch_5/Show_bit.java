class Show_bit{
  int numbit;   //储存转化后的比特值

  Show_bit(int n){
    numbit = n;
  }

  void show(long val){
    long mask = 1;
    mask <<= numbit-1;
    //先减一后移位,再自赋值,表示将mask的值左移几位,八位就左移7位,因为自己占一位,

    int spacer = 0;
    for(;mask!=0;mask>>>=1){
      if((val & mask) != 0) System.out.print("1");
      else System.out.print("0");
      spacer++;
      if((spacer % 8)==0){
        System.out.print(" ");//每组8位之后，show ( )输出一个空格。这使得读取长位模式的二进制值变得更容易 
        spacer = 0;
      }
    }
    System.out.println();
  }

}

class Show_bit_demo{
  

public static void main (){//java 对变量的修改只能放在方法中!!!
Show_bit b= new Show_bit(8);
  Show_bit i = new Show_bit(32);
  Show_bit li = new Show_bit(64);
  System.out.println("123 in binary: ");
  b.show(123);

  System.out.println("\n87987 in binary: ");
  i.show(87987);

  System.out.println("\n237658768 in binary: ");
  li.show(237658768);

  System.out.println("\nlow order 8 bits of 87987 in binary: ");//意思就是只显示最后的那八个二进制数字
  b.show(87987);
}

}