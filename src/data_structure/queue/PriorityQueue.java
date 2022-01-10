package data_structure.queue;

/**
 * Author : Ray
 * Created At : 2018-06-20 下午11:03
 * Email : ryu18356@gmail.com
 * Description : 优先级队列
 */
public class PriorityQueue {

    private long[] mData;
    private int mItems;
    private int mSize;

    public PriorityQueue(int size) {

        mData = new long[size];
        mItems = 0;
        mSize = size;
    }

    public void insert(int data) {

        if (mItems == 0) {
            mData[mItems++] = data;
        } else {
            int i = mItems - 1;
            for (; i >= 0; i--) {
                if (data > mData[i]) {
                    mData[i + 1] = mData[i];
                } else {
                    break;
                }
            }
            mData[i + 1] = data;
            mItems ++;
        }

    }

    public boolean isEmpty() {
        return mItems == 0;
    }

    public boolean isFull() {
        return mItems == mSize;
    }

    public long peek() {
        return mData[mItems - 1];
    }

    public long remove() {
        return mData[--mItems];
    }

}
