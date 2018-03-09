package sort;

import util.Utils;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,-2,5,6,8,7,10,15};
        Utils.printArray(arr);
        System.out.println("");
        bubbleSort(arr, false);
        Utils.printArray(arr);
    }

    /**
     *
     * @param arr original arrays
     * @param decrease sort type true = increase, false = decrease
     */
    private static void bubbleSort(int [] arr, boolean decrease){
        for (int out = arr.length - 1; out > 1; out --) {
            for (int i = 0; i < out; i ++) {
                if (decrease) {
                    if (arr[i] < arr[i + 1]) {
                        Utils.swap(arr, i, i + 1);
                    }
                } else {
                    if (arr[i] > arr[i + 1]) {
                        Utils.swap(arr, i, i + 1);
                    }
                }
            }
        }
    }

}
