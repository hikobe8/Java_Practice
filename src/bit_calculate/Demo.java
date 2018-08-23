package bit_calculate;

/**
 * Author : Ray
 * Created At : 2018-08-22 下午6:04
 * Email : ryu18356@gmail.com
 * Description :
 */
public class Demo {

    public static void main(String[] args) {
        int a = 15, b = -15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(a >> 2);
        System.out.println(b >> 2);
        System.out.println(isOdd(3));
        System.out.println(isOdd(4));
        swap(2, 3);
    }

    /**
     * 位运算求奇偶
     * @param num
     * @return true 奇数
     */
    private static boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    /**
     * 位运算交换两数，不借助额外变量
     * @param a
     * @param b
     */
    private static void swap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a = " + a + " b = " + b);
    }

}
