package data_structure.stack;

public class StackX {

    private int mMaxSize;
    private long[] mStackArray;
    private int mTop;

    public StackX( int maxSize) {
        mMaxSize = maxSize;
        mStackArray = new long[maxSize];
        mTop = -1;
    }

    public void push(long value){
        mStackArray[++mTop] = value;
    }

    public long pop(){
        return mStackArray[mTop--];
    }

    public long peek(){
        return mStackArray[mTop];
    }

    public boolean isEmpty(){
        return  mTop == -1;
    }

    public boolean isFull(){
        return  mTop == mMaxSize - 1;
    }

}
