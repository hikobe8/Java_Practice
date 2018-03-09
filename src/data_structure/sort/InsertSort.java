package data_structure.sort;

import data_structure.util.Utils;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,-2,5,6,8,7,10,15};
        Utils.printArray(arr);
        System.out.println("");
        insertSort(arr, true);
        Utils.printArray(arr);
        System.out.println("");
        insertSort(arr, false);
        Utils.printArray(arr);
    }

    private static void insertSort(int arr[], boolean decrease) {
        if (arr.length == 0)
            return;
        for (int out = 1 ; out < arr.length; out ++) {
            int in = out;
            int tmp = arr[out];
            while (in > 0 && (decrease ? arr[in - 1] < tmp : arr[in - 1] > tmp)) {
                arr[in] = arr[in -1];
                -- in;
            }
            arr[in] = tmp;
        }
    }

}
