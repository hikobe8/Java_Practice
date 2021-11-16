package algorithm.redbook.sort;

import java.util.Random;

public class SelectionSort extends SortParent {

    public static void sort(Comparable[] a) {
        //交换次数为N次
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            //每次交换完成后找到，最小的元素下标
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            //交换最小元素到当前最小下标处
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        boolean sorted = true;
        for (int i = 0; i < random.nextInt(10) + 5; i ++) {
            Integer[] a = new Integer[random.nextInt(10) + 5];
            for (int j = 0; j < a.length; j ++) {
                a[j] = random.nextInt(100);
            }
            sort(a);
            show(a);
            sorted = sorted && isSorted(a);
        }
        System.out.println("all sorted = " + sorted);

    }

}
