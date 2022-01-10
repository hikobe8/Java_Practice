package src.concurrent;

import java.util.Random;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-08-10 10:00
 *  description : 生产者消费者模型 Java实现
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        GoodRepository goodRepository = new GoodRepository();
        new Thread(new ProducerRunnable(goodRepository)).start();
        new Thread(new ConsumerRunnable(goodRepository)).start();
    }

    static class ProducerRunnable implements Runnable {

        private GoodRepository mGoodRepository;

        public ProducerRunnable(GoodRepository goodRepository) {
            mGoodRepository = goodRepository;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int i = new Random().nextInt(10);
                    mGoodRepository.put(new Random().nextInt(10));
                    Thread.sleep(1000);
                    System.out.println("produce good : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerRunnable implements Runnable {

        private GoodRepository mGoodRepository;

        public ConsumerRunnable(GoodRepository goodRepository) {
            mGoodRepository = goodRepository;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int i = mGoodRepository.get();
                    Thread.sleep(1000);
                    System.out.println("consume good : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class GoodRepository {

        private boolean isEmpty = true;
        private int mGood;

        public synchronized void put(int good) throws InterruptedException {
            while (!isEmpty) {
                wait();
            }
            mGood = good;
            isEmpty = false;
            notifyAll();
        }

        public synchronized int get() throws InterruptedException {
            while (isEmpty) {
                wait();
            }
            isEmpty = true;
            notifyAll();
            return mGood;
        }

    }

}
