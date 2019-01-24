package GenQueue;

public class GenQueue<T> implements IGenQ<T> {
  private T q[];//本体是数组
  private int putloc, getloc;//放入取出指针

  public GenQueue(T[] aRef) {//本体数组需要先在外面创建再带入进来
    q = aRef;
    putloc = getloc = 0;
  }

  public void put(T obj)
          throws QueueFullException {
    if (putloc == q.length)
      throw new QueueFullException(q.length);
    q[putloc] = obj;
    putloc = putloc + 1;
  }

  public T get()
          throws QueueEmptyException {
    if (getloc == putloc)
      throw new QueueEmptyException();
    T temp;
    temp = q[getloc];
    getloc = getloc + 1;
    return temp;
  }
}
