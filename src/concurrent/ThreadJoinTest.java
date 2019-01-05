package src.concurrent;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-12-25 15:29
 *  description : Thread.join方法的使用
 *  Join()方法，使调用此方法的线程wait()（在例子中是main线程）
 *  ,直到调用此方法的线程对象（在例子中是ChildThread对象）所在的线程（在例子中是子线程）执行完毕后被唤醒
 */
public class ThreadJoinTest {

    private static class CloseThread extends Thread{

        @Override
        public void run() {
            try {
                System.out.println("CloseThread: closing");
                Thread.sleep(1000); //模拟关闭操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CloseThread: closed");
        }

    }

    private static class StartThread extends Thread{

        private CloseThread mCloseThread;

        public StartThread(CloseThread closeThread) {
            mCloseThread = closeThread;
        }

        @Override
        public void run() {
            try {
                mCloseThread.join();
                System.out.println("StartThread: opening");
                Thread.sleep(1000); //模拟打开操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("StartThread: opened");
        }
    }
    public static void main(String[] args) {
        CloseThread closeThread = new CloseThread();
        Thread aChildThread = new StartThread(closeThread);
        aChildThread.start();
        closeThread.start();
    }

}
