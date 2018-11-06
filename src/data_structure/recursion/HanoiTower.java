package data_structure.recursion;

/**
 * Author : Ray
 * Created At : 2018-11-06 下午10:57
 * Email : ryu18356@gmail.com
 * Description : 汉诺塔 java实现
 */
public class HanoiTower {

    public static void main(String[] args) {
        moveDish(3, "a", "b", "c");
    }

    private static void moveDish(int count, String srcIndex, String bufferIndex, String dstIndex){
        if (count == 1) {
            System.out.println("move :" + srcIndex + " to " + dstIndex);
            return;
        }
        moveDish(count - 1, srcIndex, dstIndex, bufferIndex);
        moveDish(1, srcIndex, bufferIndex, dstIndex);
        moveDish(count - 1, bufferIndex, srcIndex, dstIndex);
    }

}
