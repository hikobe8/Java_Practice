package data_structure.queue;

import java.util.Scanner;

/**
 * 数组实现环形队列
 */
public class CircleArrayQueue {

    private int mMaxSize;
    private int mArraySize;
    private int mFront; //指向头部
    private int mRear;  //指向尾部的下一个位置
    private int[] mDataArray;

    public CircleArrayQueue(int mMaxSize) {
        this.mMaxSize = mMaxSize;
        mArraySize = mMaxSize + 1;
        mDataArray = new int[mArraySize]; //存储元素的数组比最大容量多一个，方便实现环形队列
        mFront = 0;
        mRear = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("ArrayQueue is Full!");
        }
        mDataArray[mRear++] = data;
        mRear = mRear % (mArraySize);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ArrayQueue is Empty!");
        }
        int dequeue = mDataArray[mFront++];
        mFront = mFront % (mArraySize);
        return dequeue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("ArrayQueue is Empty!");
        }
        return mDataArray[mFront];
    }

    public boolean isEmpty() {
        return mFront == mRear;
    }

    public boolean isFull() {
        return (mRear + 1) % mArraySize == mFront;
    }

    public void print() {
        if (isEmpty())
            return;
        int size = size();
        for (int i = mFront; i < mFront + size; i++) {
            System.out.printf("a[%d] = %d\t", i % mArraySize, mDataArray[i % mArraySize]);
        }
        System.out.println();
    }

    public int size() {
        return (mRear + mArraySize - mFront) % mArraySize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入队列的容量：");
        int maxSize = scanner.nextInt();
        CircleArrayQueue queue = new CircleArrayQueue(maxSize);
        while (true) {
            System.out.println("a.入队");
            System.out.println("b.出队");
            System.out.println("c.打印队首");
            System.out.println("d.打印所有数据");
            System.out.println("e.显示数量");
            System.out.println("输入任意非菜单字符退出程序");
            String option = scanner.next();
            try {
                switch (option) {
                    case "b":
                        System.out.println(queue.dequeue());
                        break;
                    case "c":
                        System.out.printf("a[%d] = %d \n", queue.mFront, queue.peek());
                        break;
                    case "d":
                        queue.print();
                        break;
                    case "e":
                        System.out.println(queue.size());
                        break;
                    case "a":
                        while (true) {
                            System.out.println("请输入入队数字：(-1退出入队)");
                            int num = scanner.nextInt();
                            if (num == -1) {
                                break;
                            }
                            queue.enqueue(num);
                        }
                        break;
                    default:
                        System.exit(0);
                        break;
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

}
