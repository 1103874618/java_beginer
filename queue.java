class jQueue{
  char q[];//队列的本体就是一个数组
  int put_loc,get_loc;


  jQueue( int size){
    q = new char [size];//给队列分配内存
    put_loc = get_loc =0;
  }

  void put(char ch){
    if(put_loc == q.length){
      System.out.println(" - Queue is full");
      return;
    }
    q[put_loc++] = ch; //先赋值,后自加,所以0位并非是空的

  }

  char get (){
    if(get_loc == put_loc){
      System.out.println("- Queue is empty");
      return (char) 0;
    }

    return q[get_loc++];
  }
}

class queue{
  public static void main (String args[]){
    jQueue bigQ = new jQueue(100);
    jQueue smallQ = new jQueue(4);
    char ch;
    int i;

    System.out.println("Using bigQ to store the alphabet.");

    for(i =0 ;i <26;i++)
      bigQ.put((char) ('A' + i));

      System.out.print("Constents of bigQ: ");
      for(i = 0; i<26;i++){
        ch = bigQ.get();
        if(ch != (char) 0) System.out.print(ch);
      }

      System.out.println("\n");

      System.out.println("Using smallQ to generate erros.");

      for(i = 0; i <26;i++){//储存二十六个英文字母
         System.out.println("Attemping to store" + (char) ('Z' - i));

         smallQ.put((char) ('Z' - i));

         System.out.println();
      }

      System.out.println();

      System.out.print("Constents of smallQ: " );
      for(i = 0; i <26;i++){
        ch = smallQ.get();
        if (ch != (char) 0) System.out.print(ch);
      }
  }
}