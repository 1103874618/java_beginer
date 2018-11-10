class QuickSort {//此版本仅适用于字符数组,排序是按照字母表顺序从小到大排的

  static void qsort(char[] items) {
    qs(items, 0, items.length - 1);
  }

  private static void qs(char[] items, int left, int right) {
    int i, j;//代表左右边界
    char x, y;
    i = left;
    j = right;
    x = items[(left + right) / 2];//代表中点

    do {
      while ((items[i] < x) && (i < right)) i++;//数比中点大却在中点左边
      while ((x < items[j]) && (j > left)) j--;//数比中点小却在在中点右边

      if (i <= j) {//左右边界所指的数互换
        y = items[i];
        items[i] = items[j];
        items[j] = y;
        i++;//边界同时缩小
        j--;
      }
    } while (i <= j);//直到边界缩小成一个点(中点)

    if (left < j) qs(items, left, j);//但此时两个边界点仍未到达尽头,而是分为了左半部和右半部
    if (i < right) qs(items, i, right);//因此两部分分别再次执行
  }

}

class QSDemo {
  public static void main(String[] args) {
    char[] a = {'d', 'x', 'a', 'r', 'p', 'j', 'i'};
    int i;

    System.out.print("Original array : ");
    for (i = 0; i < a.length; i++)
      System.out.print(a[i]);
    System.out.println();

    QuickSort.qsort(a);

    System.out.print("Sorted array : ");
    for (i = 0; i < a.length; i++)
      System.out.print(a[i]);
  }
}
