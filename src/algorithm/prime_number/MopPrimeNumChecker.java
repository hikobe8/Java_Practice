package algorithm.prime_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ray
 * Created At : 2018/03/12 下午3:34
 * Email : ryu18356@gmail.com
 */
public class MopPrimeNumChecker {

    /**
     * 递归实现判断是否为猫扑数
     * 例如2,23, 233, 2333, 23333,即2后面跟若干个3为猫扑数
     * @param number 输入数
     * @return true为猫扑数,反之.
     */
    public static boolean isMopNumber( long number ){
        if (number < 0) return false;
        if (number < 10) {
            return number == 2;
        }
        return number % 10 == 3 && isMopNumber( number / 10 );
    }

    /**
     * 判断一个数是否为猫扑素数
     * @param number 输入数
     * @return true为猫扑素数,反之.
     */
    public static boolean isMopPrimeNumber( long number ) {
        return isMopNumber(number) && PrimeNumberChecker.isPrimeNumber(number);
    }

    /**
     * 获取指定范围内所有的猫扑素数
     * @param startNum 数值区间的起点数
     * @param endNum 数值区间的终点数
     * @return 指定范围内的所有猫扑素数
     */
    public static List<Long> getAllMopPrimeNumber( long startNum, long endNum ) {
        if (startNum < 0 || endNum < 0) {
            return null;
        }
        List<Long> resultList = new ArrayList<>();
        startNum = startNum < 2 ? 2 : startNum;
        for (long i = startNum; i <= endNum; i ++ ) {
            if (isMopPrimeNumber(i)) {
                resultList.add(i);
                System.out.println("found Mop Prime Number : " + i);
            }
        }
        return resultList;
    }

}
