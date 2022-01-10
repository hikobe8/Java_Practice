package data_structure.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/**
 * Author : Ray
 * Created At : 2018-08-09 下午11:27
 * Email : ryu18356@gmail.com
 * Description : 快速排序
 */
public class QuickSort {

    /**
     * 递归实现
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int i, j, standard;
        standard = arr[left];
        i = left;
        j = right;
        while (i != j) {
            while (arr[j] >= standard && i < j) {
                j--;
            }
            while (arr[i] <= standard && i < j) {
                i++;
            }
            if (i < j) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
        arr[left] = arr[i];
        arr[i] = standard;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 迭代实现
     * 借助两个栈来存取起始坐标完成迭代
     *
     * @param arr
     */
    private static void quickSortIteration(int[] arr) {
        Stack<Integer> startIndexStack = new Stack<>();
        Stack<Integer> endIndexStack = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        startIndexStack.push(left);
        endIndexStack.push(right);
        while (!startIndexStack.isEmpty() && !endIndexStack.isEmpty()) {
            int start = startIndexStack.pop();
            int end = endIndexStack.pop();
            int i = start + 1;
            int j = end;
            if (start >= end || start < 0) {
                continue;
            }
            while (true) {
                int standard = arr[start];
                while (arr[j] <= standard && i < j) {
                    j--;
                }
                while (arr[i] >= standard && i < j) {
                    i++;
                }
                if (i < j) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                } else
                    break;
            }

            arr[i] = arr[i] ^ arr[start];
            arr[left] = arr[i] ^ arr[start];
            arr[i] = arr[i] ^ arr[start];

            startIndexStack.push(start);
            endIndexStack.push(i - 1);
            startIndexStack.push(i + 1);
            endIndexStack.push(end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(100) - 50;
        }
//        arr = new int[]{-5,4,3,-2,2,1,0};
        System.out.print("source array : ");
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        for (int anArr : arr1) {
            System.out.print(anArr + " ");
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.print("recursion sorted array : ");
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        quickSortIteration(arr1);
        System.out.println();
        System.out.print("iteration sorted array : ");
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }


    /**
     * 从数组两端根据数据第一个元素进行划分
     *
     * @param arr
     */
    private static void partitionIt(int arr[], int left, int right) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("arr is empty!");
        } else {
            int leftPtr = left;
            int rightPtr = right;
            int pivot = arr[left];
            while (true) {
                while (leftPtr < right && arr[leftPtr] < pivot) {
                    leftPtr++;
                }
                while (rightPtr > left && arr[rightPtr] > pivot) {
                    rightPtr--;
                }
                if (leftPtr < rightPtr) {
                    swap(arr, leftPtr, rightPtr);
                } else {
                    break;
                }
            }

        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }


}
