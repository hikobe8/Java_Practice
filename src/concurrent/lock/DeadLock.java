package concurrent.lock;

/**
 * 相互持有锁，产生死锁
 * 解决方案：信号量 {@link DeadLockResolvedBySemaphore}
 */
public class DeadLock {

    public static void main(String[] args) {
        new MyThread2().start();
        new MyThread1().start();
    }

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    static class MyThread1 extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("线程A启动");
                while (true) {
                    synchronized (lockA) {
                        System.out.println("线程A持有锁A");
                        synchronized (lockB) {
                            System.out.println("线程A持有锁B");
                            System.out.println("线程A开始搞事");
                            Thread.sleep(1000L);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("线程B启动");
                while (true) {
                    synchronized (lockB) {
                        System.out.println("线程B持有锁B");
                        synchronized (lockA) {
                            System.out.println("线程B持有锁A");
                            System.out.println("线程B开始搞事");
                            Thread.sleep(1000L);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
