package queue;

public class Queue {

    private int front;
    private int rear;
    private long[] queueArray;
    private int maxSize;
    private int size;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void insert(long value){
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
        size ++;
    }

    public long remove(){
        long value = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        size --;
        return value;
    }

    public long peek(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == maxSize;
    }

    public int size(){
        return size;
    }

}
