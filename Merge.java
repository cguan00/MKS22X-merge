public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){
    int lo = 0;//start at index 0
    int hi = data.length - 1;//end at last index
    int mid = data.length / 2;//middle index of data array
    mergesort(data, lo, hi);//call helper method on whole array
    if(lo >= hi){
      return;//void method, so don't return anything
    }
    mergesort(data, 0, mid - 1);// mergesort left side
    mergesort(data, mid + 1, hi);// mergesort right side
    // merge
  }

  public static void mergesort(int[] data, int lo, int hi){

  }

}
