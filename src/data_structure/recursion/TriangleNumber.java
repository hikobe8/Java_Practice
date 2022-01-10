package data_structure.recursion;

/**
 * Author : Ray
 * Created At : 2018-09-24 上午12:13
 * Email : ryu18356@gmail.com
 * Description :
 */
public class TriangleNumber {

    public static void main(String[] args) {
        System.out.println("triangle number 3 = " + getTriangleNumber(3));
        System.out.println("triangle number 10 = " + getTriangleNumber(10));
        System.out.println("triangle number 100 = " + getTriangleNumber(100));
        System.out.println("triangle number 1000 = " + getTriangleNumber(1000));
    }

    private static int getTriangleNumber(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + getTriangleNumber(n - 1);
    }

}
