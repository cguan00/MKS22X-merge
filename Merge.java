import java.util.Arrays;

public class Merge{
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;

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
    // System.out.println(printArray(left));
    mergesort(left, 0, left.length - 1);//mergesort left side

    //create right array
    int[] right = new int[data.length - mid];//temporary array to store right half of data array
    for(int i = 0; i < right.length; i++){
      right[i] = data[mid + i];//copying over values from data array to right array
    }
    // System.out.println(printArray(right));
    mergesort(right, 0, right.length - 1);//mergesort right side

    merge(data, left, right);//merge left and right sides together
  }

  // public static void mergesort(int[] data, int lo, int hi){
  //   if(lo >= hi){
  //     return;//void method, so don't return anything
  //   }
  //   int mid = (data.length + 1) / 2;//middle index of data array and half of data length
  //   // System.out.println(mid);
  //
  //   //create left array
  //   int[] left = new int[mid];//temporary array to store left half of array
  //   for(int i = 0; i < left.length; i++){
  //     left[i] = data[lo + i];//copying over values from data array to left array
  //   }
  //   // System.out.println(printArray(left));
  //   mergesort(left, 0, left.length - 1);//mergesort left side
  //
  //   //create right array
  //   int[] right = new int[data.length - mid];//temporary array to store right half of data array
  //   for(int i = 0; i < right.length; i++){
  //     right[i] = data[mid + i];//copying over values from data array to right array
  //   }
  //   // System.out.println(printArray(right));
  //   mergesort(right, 0, right.length - 1);//mergesort right side
  //
  //   merge(data, left, right);//merge left and right sides together
  // }


  public static void merge(int[] data, int[] left, int[] right){
    int i = 0;//index of data
    int l = 0;//index of left array
    int r = 0;//index of right array

    while(l < left.length && r < right.length){//while still looping through both left and right arrays
      if (left[l] <= right[r]){//if item in left array is smaller than item in right array
        data[i] = left[l];//copy over item
        l++;//increase left index
      }
      else{//if item in right array is smaller than item in left array
        data[i] = right[r];//copy over item
        r++;//increase right index
      }
      i++;//increase data index
    }

    //added all elements from right array already, but not done with left array
    while(l < left.length){
      data[i] = left[l];//copy over item
      i++;//increase data index
      l++;//increase left index
    }

    //added all elements from left array already, but not done with right array
    while(r < right.length){
      data[i] = right[r];//copy over item
      i++;//increase merge index
      r++;//increase right index
    }
  }

  public static String printArray(int[] data){
    String output = "";
    for(int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    return output;
  }

  public static void insertionsort(int[] data, int lo, int hi){
    for(int i = lo + 1; i <= hi; i++){//loop through data, starting at index of lo + 1
      int temp = data[i];//temporarily store the item you are looking at
      int past = i;
      while(past > lo && temp < data[past - 1]){
        data[past] = data[past - 1];
        past--;
      }
      data[past] = temp;
    }
  }

  private static String name(int i){
    if(i==INCREASE)return "Increassing";
    if(i==DECREASE)return "Decreassing";
    if(i==STANDARD)return "Normal Random";
    if(i==SMALL_RANGE)return "Random with Few Values";
    return "Error categorizing array";
  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    else if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    else if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    else if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    else{
      ans = new int[0];//empty is default
    }
    return ans;
  }

  public static void main(String[]args){
     if(args.length < 2)return;

     int size =  Integer.parseInt(args[0]);
     int type =   Integer.parseInt(args[1]);

     int [] start = makeArray(size,type);
     int [] result = Arrays.copyOf(start,start.length);
     Arrays.sort(result);

     long startTime = System.currentTimeMillis();
     /*
      * Test your sort here //yoursort(start);
      * Add code to switch which sort is tested by changing one of the args!
      */
     long elapsedTime = System.currentTimeMillis() - startTime;
     if(Arrays.equals(start,result)){
       System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
     }else{
       System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
     }
   }




}
