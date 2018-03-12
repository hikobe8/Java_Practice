package algorithm.prime_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ray
 * Created At : 18-3-12 下午3:18
 * Email : ryu18356@gmail.com
 */
public class PrimeNumberChecker {

    /**
     * 检测一个数是否为素数
     * @param number 被检测的数
     * @return true为素数,反之.
     */
    public static boolean isPrimeNumber(long number){
        if (number == 1) return false;
        long midNumber = (long) Math.sqrt(number);
        for (long i = 2; i <= midNumber ; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 获取制定范围内的所有素数
     * @param startNum 数值区间的起点
     * @param endNum 数值区间的终点
     * @return 返回当前区间的所有素数
     */
    public static List<Long> getAllPrimeNumber(long startNum, long endNum){
        List<Long> resultList = new ArrayList<>();
        for (long i = startNum; i <= endNum; i++) {
            if (isPrimeNumber(i)) {
                resultList.add(i);
                System.out.println("found Prime Number : " + i);
            }
        }
        return resultList;
    }

}
