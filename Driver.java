public class Driver{
  public static void main(String[] args) {
    // int[] data1 = {20, 30, 15, 10, 0, 50};
    // System.out.println(Merge.printArray(data1));
    // Merge.mergesort(data1);
    // System.out.println(Merge.printArray(data1));

    // int[] data2 = {38, 27, 43, 3, 9, 82, 10};
    // System.out.println(Merge.printArray(data2));
    // Merge.mergesort(data2);
    // System.out.println(Merge.printArray(data2));

    int[] data3 = {10, 50, 20, 70, 40};
    System.out.println(Merge.printArray(data3));
    Merge.insertionsort(data3, 0, data3.length - 1);
    System.out.println(Merge.printArray(data3));
  }
}
