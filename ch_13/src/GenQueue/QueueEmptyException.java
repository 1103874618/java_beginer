package GenQueue;
//异常类都无需泛型化,应为数据类型对他们的处理不影响
public class QueueEmptyException extends Exception{
  public String toString(){
    return "\nQueue is empty.";
  }
}
