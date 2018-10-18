package src.concurrent.basis;

import java.util.concurrent.atomic.AtomicInteger;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-10-18 18:07
 *  description : 
 */
public class AtomIntegerDemo {

    private static class NumberGenerator{

        private AtomicInteger mAtomicInteger = new AtomicInteger(0);

        public int getNumber(){
            return mAtomicInteger.getAndIncrement();
        }

    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " : " + numberGenerator.getNumber());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.setName("first Thread");
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.setName("second Thread");
        t2.start();
    }

}
