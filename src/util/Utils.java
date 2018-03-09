package util;

public class Utils {

    public static void swap(int [] arr, int indexA, int indexB){
        int tmp;
        tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void printArray(int [] arr){
        for (int i : arr ) {
            System.out.print(i + " ");
        }
    }

}
