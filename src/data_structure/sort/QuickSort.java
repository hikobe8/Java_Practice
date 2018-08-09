package data_structure.sort;

/**
 * Author : Ray
 * Created At : 2018-08-09 下午11:27
 * Email : ryu18356@gmail.com
 * Description : 快速排序（递归实现）
 */
public class QuickSort {

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
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                System.out.println();
                for (int anArr : arr) {
                    System.out.print(anArr + " ");
                }
            }
        }
        arr[left] = arr[i];
        arr[i] = standard;
        System.out.println();
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 1, 7, 8, 0};
        System.out.print("source array : ");
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.print("sorted array : ");
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

}
