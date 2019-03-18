public class Driver{
  public static void main(String[] args) {
    int[] data1 = {20, 30, 15, 10, 0, 50};
    System.out.println(Merge.printArray(data1));
    Merge.mergesort(data1);
    System.out.println(Merge.printArray(data1));
  }
}
