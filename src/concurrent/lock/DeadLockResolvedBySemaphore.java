package concurrent.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 使用信号量解决死锁问题
 * 死锁产生的场景 {@link DeadLock}
 */
public class DeadLockResolvedBySemaphore {

    public static void main(String[] args) {
        new MyThread1().start();
        new MyThread2().start();
    }

    private static final Semaphore s1 = new Semaphore(1);
    private static final Semaphore s2 = new Semaphore(1);

    static class MyThread1 extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("线程A启动");
                while (true) {
                    if (s1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println("线程A持有锁A");
                        if (s2.tryAcquire(1, TimeUnit.SECONDS)) {
                            System.out.println("线程A持有锁B");
                            System.out.println("线程A开始搞事");
                            Thread.sleep(1000L);
                        } else {
                            System.out.println("线程A获取s2锁失败");
                        }
                    } else {
                        System.out.println("线程A获取s1锁失败");
                    }
                    s1.release();
                    s2.release();
                    Thread.sleep(1000L);
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
                    if (s2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println("线程B持有锁B");
                        if (s1.tryAcquire(1, TimeUnit.SECONDS)) {
                            System.out.println("线程B持有锁A");
                            System.out.println("线程B开始搞事");
                            Thread.sleep(1000L);
                        } else {
                            System.out.println("线程B获取s1锁失败");
                        }
                    } else {
                        System.out.println("线程B获取s2锁失败");
                    }
                    s1.release();
                    s2.release();
                    Thread.sleep(2000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
