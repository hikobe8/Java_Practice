package data_structure.queue;

import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

/**
 * 数组实现队列
 * todo 使用取模操作实现循环队列
 */
public class ArrayQueue {

    private int mMaxSize;
    private int mFront; //指向头部
    private int mRear;  //指向尾部
    private int[] mDataArray;

    public ArrayQueue(int mMaxSize) {
        this.mMaxSize = mMaxSize;
        mDataArray = new int[mMaxSize];
        mFront = 0;
        mRear = -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("ArrayQueue is Full!");
        }
        mDataArray[++mRear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ArrayQueue is Empty!");
        }
        return mDataArray[mFront++];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("ArrayQueue is Empty!");
        }
        return mDataArray[mFront];
    }

    public boolean isEmpty() {
        return mFront - 1 == mRear;
    }

    public boolean isFull() {
        return mRear == mMaxSize - 1;
    }

    public void print() {
        if (isEmpty())
            return;
        for (int i = mFront; i <= mRear; i++) {
            System.out.print(mDataArray[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入队列的容量：");
        int maxSize = scanner.nextInt();
        ArrayQueue queue = new ArrayQueue(maxSize);
        while (true) {
            System.out.println("1.入队");
            System.out.println("2.出队");
            System.out.println("3.打印队首");
            System.out.println("4.打印所有数据");
            int option = scanner.nextInt();
            try {
                switch (option) {
                    case 2:
                        System.out.println(queue.dequeue());
                        break;
                    case 3:
                        System.out.println(queue.peek());
                        break;
                    case 4:
                        queue.print();
                        break;
                    default:
                        while (true) {
                            System.out.println("请输入入队数字：(-1退出入队)");
                            int num = scanner.nextInt();
                            if (num == -1) {
                                break;
                            }
                            queue.enqueue(num);
                        }
                        break;
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

}
