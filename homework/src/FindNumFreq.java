import java.util.HashMap;
import java.util.Map;

//tmd 对象的成员在函数之外不能使用........
class FindNumFreq {
  Sort rand = new Sort();

  Map findFreq() {//统计数字出现次数
    int[] ran = rand.generateNum(50, 100);//生成50个随机数
    Map<Integer, Integer> numAndFreq = new HashMap();

    for (int i = 0; i < ran.length; i++) {//随机数全部储存到map的键中,值即为他们出现的次数
      if (numAndFreq.containsKey(ran[i])) {//之前已经出现过的键就直接更新他们的值
        int key = ran[i];
        int value = numAndFreq.get(key);
        numAndFreq.put(ran[i], value+1);
        continue;
      }
      numAndFreq.put(ran[i], 1);
    }
    return numAndFreq;
  }

  void outPutFraq(Map<Integer, Integer> num) {//输出各个数的出现次数
    //记得之前声明map的时候记得带上映射,否则后面会报类型错误(创建了一个没有泛型类型参数的ATest。在这种情况下，Java从类中移除所有通用信息，包括，正如你将看到的，从它里面的道具变量中移除< String，String >

    for (Map.Entry<Integer, Integer> entry : num.entrySet()) {
      System.out.println(entry.getKey() + "出现的次数为 : " + entry.getValue());
    }

  }
}

class NumFreqDemo {

  public static void main(String[] args) {
    FindNumFreq Demo = new FindNumFreq();
    Map num = Demo.findFreq();
    Demo.outPutFraq(num);

  }
}
