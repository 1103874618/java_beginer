public class Sort {
  private int randomNum(int range) {//一定范围内随机数生成
    int num = (int) Math.floor(range * Math.random());
    return num;
  }

  int[] generateNum(int n, int range) {//生成n个随机数
    int[] ranNum = new int[n];
    for (int i = 1; i <= n; i++) {
      ranNum[i - 1] = randomNum(range);
    }
    return ranNum;
  }

  int[] findMaxMin(int[] num) {//找出最大最小值
    int[] maxMin = new int[2];
    int max, min;
    min = max = num[0];
    for (int i = 1; i < num.length; i++) {
      if (num[i] < min) min = num[i];
      if (num[i] > max) max = num[i];
    }
    maxMin[0] = max;
    maxMin[1] = min;
    return maxMin;
  }

  int[] findFifty(int[] num) {//找出大于50的数
    int[] fifty = new int[50];
    int n = 0;
    for (int i = 0; i < num.length; i++) {
      if (num[i] > 50) {
        fifty[n] = num[i];
        n++;
      }
    }
    return fifty;
  }
}

class SortDemo {
  public static void main(String[] args) {
    Sort s = new Sort();
    int[] random = s.generateNum(100, 99);
    int[] maxMin = s.findMaxMin(random);
    int[] fifty = s.findFifty(random);


    System.out.println("最大值为 : " + maxMin[0] + "  最小值为 : " + maxMin[1]);
    System.out.print("比50大的整数有: " );
    for(int i = 0;i<50;i++){
      if(fifty[i] == 0 ) continue;
      System.out.print(fifty[i]+"  ");
    }

  }
}
