package data_structure.sort;

import data_structure.util.Utils;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,-2,5,6,8,7,10,15};
        Utils.printArray(arr);
        System.out.println("");
        selectionSort(arr, true);
        Utils.printArray(arr);
    }

    private static void selectionSort(int [] arr, boolean decrease){
        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                if (decrease) {
                    if (arr[i] < arr[j]) {
                        Utils.swap(arr, i, j);
                    }
                } else {
                    if (arr[i] > arr[j]) {
                        Utils.swap(arr, i, j);
                    }
                }
            }
        }
    }

}

