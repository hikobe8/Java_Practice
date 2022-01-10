package src.algorithm;

import java.util.Arrays;

/**
 * Author : Ray
 * Created At : 2018-03-13 下午8:41
 * Email : ryu18356@gmail.com
 * Description : 递归实现二分查找的实例程序
 */
public class RecursionBinarySearchDemo {

    /**
     * 递归实现 二分查找key值对应的下标
     * @param source 输入的源数组 ，请保证为一个有序数组
     * @param key 需要查找的值
     * @return 正数为查找到的坐标，-1表示没有查到
     */
    public static int binarySearchByRecursion(int[] source, int key, int low, int high) {
        if (low <= high) {
            int mid = ( low + high ) >>> 1; //使用位移运算法高效地获取折中下标，这里不考虑符号，所以使用>>>
            int midVal = source[mid];
            if ( midVal < key ) {
                low = mid + 1;
                return binarySearchByRecursion(source, key, low, high);
            } else if ( midVal > key ) {
                high = mid - 1;
                return binarySearchByRecursion(source, key, low, high);
            }  else
                return  mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] source = new int[]{12,213,232,343,123,-1,123,232424,1253,56,456,234,-2342};
        //保证数组为有序数组
        Arrays.sort(source);
        //打印排序后的数组元素
        System.out.print("Sorted Source : ");
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
        int search = binarySearchByRecursion(source, 232, 0, source.length);
        if (search != -1) {
            System.out.println("该数在数组中的下标为:"+search);
        } else {
            System.out.println("没有找到该数!");
        }
    }

}
