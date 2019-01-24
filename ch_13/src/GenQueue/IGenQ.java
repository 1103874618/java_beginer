package GenQueue;

public interface IGenQ<T> {//描述队列的两个操作,put 和get
  void put (T ch) throws QueueFullException;
  T get() throws QueueEmptyException;
}
