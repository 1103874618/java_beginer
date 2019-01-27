import java.util.stream.Stream;

import static myio.ioPack.printClass.*;

//lambda表达式可用于提供目标类型的任何上下文中。
// 前面的例子使用的目标上下文是赋值和初始化。
//另一种情况是当一个拉姆达表达式作为参数传递时。
// 事实上，传递lambda表达式作为参数是lambda的常见用法
//这是一个非常强大的用途，
// 因为它为您提供了一种将可执行代码作为方法参数传递的方法。
// 这大大增强了Java的表现力。

//主要功能,三个函数
// 反转字符串，反转字符串中字母的大小写，并用字母替换空格。
public class LamArg {
  static String ChangeStr(StringFunc sf,String s){
    return sf.func(s);
  }

  public static void main(String args[]){
    String inStr = "Lambda Expressions Expand Java";
    String outStr;

    println("Here is input string : "+inStr);

    StringFunc reverse = (str) -> {//反转字符串
      String result = "";
      for (int i= str.length()-1;i>=0;i--)//可以看出字符串的长度是字符总数,所以要-1
        result += str.charAt(i);
      return result;
    };

    outStr = ChangeStr(reverse,inStr);
    println("The string reversed: "+ outStr);

    outStr = ChangeStr((str) ->{//反转大小写
      String result = "";
      char ch;

      for (int i= 0;i<str.length();i++){
        ch = str.charAt(i);
        if (Character.isUpperCase(ch))
          result += Character.toLowerCase(ch);
        else
          result +=Character.toUpperCase(ch);
        //字母一个个转换完在一个个塞进result里面
      }
      return result;
    },inStr);//整个拉姆达块都塞进参数括号里,很难看
    println("The string in rversed case : "+ outStr);

    //小杠替换空格
    outStr = ChangeStr((str) -> str.replace(' ','-'),inStr);
    println("The string with spaces replaced: "+outStr);

  }


}

interface  StringFunc {
  String func(String str);
}



















//拉姆达表达式作为参数传递