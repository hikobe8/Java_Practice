package data_structure.linkedlist.doublelist;

/**
 * Author : Ray
 * Created At : 2018-07-20 下午2:18
 * Email : ryu18356@gmail.com
 * Description :
 */
public class DoublyLinkedList {

    private Link mFirst;
    private Link mLast;

    public boolean isEmpty() {
        return  mFirst == null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            mLast = newLink;
        } else {
            mFirst.mPrevious = newLink;
            newLink.mNext = mFirst;
        }
        mFirst = newLink;
    }

    public void insertLast(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            mFirst = newLink;
        } else {
            mLast.mNext = newLink;
            newLink.mPrevious = mLast;
        }
        mLast = newLink;
    }

    public void display(){
        if (!isEmpty()) {
            Link current = mFirst;
            while (current != null) {
                current.display();
                current = current.mNext;
            }
            System.out.println();
        }
    }

    public void displayReverse() {
        if (!isEmpty()) {
            Link current = mLast;
            while (current != null) {
                current.display();
                current = current.mPrevious;
            }
            System.out.println();
        }
    }

    public boolean insetAfter(int key, int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            mFirst = newLink;
            mLast = newLink;
            return true;
        } else {
            Link current = mFirst;
            while (current.mData != key) {
                current = current.mNext;
                if (current == null)
                    return false;
            }
            if (current == mLast) {
                //插入为最后一个
                mLast = newLink;
            } else {
                current.mNext.mPrevious = newLink;
                newLink.mNext = current.mNext;
            }
            newLink.mPrevious = current;
            current.mNext = newLink;
        }
        return false;
    }

    public int deleteFirst(){
        if (!isEmpty()) {
            int tmp = mFirst.mData;
            if (mFirst.mNext == null) {
                mLast = null;
            } else {
                mFirst.mNext.mPrevious = null;
            }
            mFirst = mFirst.mNext;
            return tmp;
        }
        return -1;
    }

    public int deleteLast(){
        if (!isEmpty()) {
            int tmp = mLast.mData;
            if (mLast.mPrevious == null) {
                mFirst = null;
            } else {
                mLast.mPrevious.mNext = null;
            }
            mLast = mLast.mPrevious;
            return tmp;
        }
        return -1;
    }

    /**
     * 删除指定数据的节点
     * @param data
     * @return true 成功, otherwise
     */
    public boolean delete(int data) {
        if (!isEmpty()) {
            Link current = mFirst;
            while (current.mData != data) {
                current = current.mNext;
                if (current == null)
                    return false;
            }
            if (current == mFirst) {
                mFirst = current.mNext;
            } else {
                current.mPrevious.mNext = current.mNext;
            }
            if (current == mLast) {
               mLast = current.mPrevious;
            } else {
                current.mNext.mPrevious = current.mPrevious;
            }
            return true;
        }
        return false;
    }

}
