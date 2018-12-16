package src.concurrent.basis.test;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-10-19 14:53
 *  description : 测试内置锁可重入性
 */
public class ReentrantSynchronizedDemo {

    private static class Widget{
        public synchronized void doSomething(){
            System.out.println("doSomething in Widget");
        }
    }

    private static class LoadWidget extends Widget{
        @Override
        public synchronized void doSomething() {
            //synchronized关键字为可重入锁，如果设计为不可重入锁的话调用super.doSomething会发生死锁
            System.out.println("doSomething in LoadWidget");
            super.doSomething();
        }
    }

    public static void main(String[] args) {
        new LoadWidget().doSomething();
    }

}

