package stack;

public class BracketStackX {
        private int mMaxSize;
        private char[] mStackArray;
        private int mTop;

        public BracketStackX( int maxSize) {
            mMaxSize = maxSize;
            mStackArray = new char[maxSize];
            mTop = -1;
        }

        public void push(char value){
            mStackArray[++mTop] = value;
        }

        public char pop(){
            return mStackArray[mTop--];
        }

        public char peek(){
            return mStackArray[mTop];
        }

        public boolean isEmpty(){
            return  mTop == -1;
        }

        public boolean isFull(){
            return  mTop == mMaxSize - 1;
        }
}
