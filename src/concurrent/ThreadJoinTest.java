package src.concurrent;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-12-25 15:29
 *  description : Thread.join方法的使用
 *  Join()方法，使调用此方法的线程wait()（在例子中是main线程）
 *  ,直到调用此方法的线程对象（在例子中是ChildThread对象）所在的线程（在例子中是子线程）执行完毕后被唤醒
 */
public class ThreadJoinTest {

    private static class ChildThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child thread exit");
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ChildThread childThread = new ChildThread();
            childThread.start();
            try {
                childThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main thread print");
        }
    }

}
