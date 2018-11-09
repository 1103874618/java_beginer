class Show_bit{
  int numbit;   //����ת����ı���ֵ

  Show_bit(int n){
    numbit = n;
  }

  void show(long val){
    long mask = 1;
    mask <<= numbit-1;
    //�ȼ�һ����λ,���Ը�ֵ,��ʾ��mask��ֵ���Ƽ�λ,��λ������7λ,��Ϊ�Լ�ռһλ,

    int spacer = 0;
    for(;mask!=0;mask>>>=1){
      if((val & mask) != 0) System.out.print("1");
      else System.out.print("0");
      spacer++;
      if((spacer % 8)==0){
        System.out.print(" ");//ÿ��8λ֮��show ( )���һ���ո���ʹ�ö�ȡ��λģʽ�Ķ�����ֵ��ø����� 
        spacer = 0;
      }
    }
    System.out.println();
  }

}

class Show_bit_demo{
  

public static void main (){//java �Ա������޸�ֻ�ܷ��ڷ�����!!!
Show_bit b= new Show_bit(8);
  Show_bit i = new Show_bit(32);
  Show_bit li = new Show_bit(64);
  System.out.println("123 in binary: ");
  b.show(123);

  System.out.println("\n87987 in binary: ");
  i.show(87987);

  System.out.println("\n237658768 in binary: ");
  li.show(237658768);

  System.out.println("\nlow order 8 bits of 87987 in binary: ");//��˼����ֻ��ʾ�����ǰ˸�����������
  b.show(87987);
}

}