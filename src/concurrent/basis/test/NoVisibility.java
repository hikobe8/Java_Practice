package src.concurrent.basis.test;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-10-19 18:02
 *  description : 多线程的变量可见性测试
 */
public class NoVisibility {

    private static int mValue;
    private static boolean mReady;

    private static class DisplayThread extends Thread{
        @Override
        public void run() {
            while (!mReady)
                Thread.yield();
            System.out.println(mValue);
        }
    }


    /*
        打印 0?100?
     */
    public static void main(String[] args) {
        new DisplayThread().start();
        mValue = 100;
        mReady = true;
    }

}
