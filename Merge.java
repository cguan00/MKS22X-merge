public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){
    int lo = 0;
    int hi = data.length - 1;
    mergesort(data, lo, hi);//call to helper method
  }

  public static void mergesort(int[] data, int lo, int hi){
    if(lo >= hi){
      return;//void method, so don't return anything
    }
    int mid = data.length / 2;//middle index of data array

    //create left array
    int[] left = new int[mid];//temporary array to store left half of array
    for(int i = 0; i < left.length; i++){
      left[i] = data[i];//copying over values from data array to left array
    }
    mergesort(left, 0, left.length - 1);// mergesort left side

    //create right array
    int[] right = new int[data.length - mid];//temporary array to store right half of data array
    for(int i = 0; i < right.length; i++){
      right[i] = data[mid + i];//copying over values from data array to left array
    }
    mergesort(right, 0, right.length - 1);// mergesort right side

    merge(data, left, right);
  }


  public static void merge(int[] data, int[] left, int[] right){
    int l = 0;
    int r = 0;

  }

  public static String printArray(int[] data){
    String output = "";
    for(int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    return output;
  }


}
