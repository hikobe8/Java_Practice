package data_structure.linkedlist.firstlastlist;

/**
 * Author : Ray
 * Created At : 2018-05-25 下午11:48
 * Email : ryu18356@gmail.com
 * Description : 双链表，注意与双向链表区别
 */
public class FirstLastLinkedList {

    class Link {
        public int mData;
        public Link mNext;

        public Link(int data) {
            this.mData = data;
        }

        public void display() {
            System.out.print( this.mData + " ");
        }
    }

    private Link mFirst;
    private Link mLast;

    public boolean isEmpty() {
        return mFirst == null;
    }
    public void insertFirst(int data){
        Link newLink = new Link(data);
        if (isEmpty())
            mLast = newLink;
        newLink.mNext = mFirst;
        mFirst = newLink;
    }

    public void insertLast(int data){
        Link newLink = new Link(data);
        if (isEmpty()) {
            mFirst = newLink;
        } else {
            mLast.mNext = newLink;
        }
        mLast = newLink;
    }

    public Link deleteFirst(){
        if (isEmpty()) {
            return null;
        }
        if (mFirst.mNext == null) {
            //链表只有一个元素的时候, 把尾部指针也置为空
            mLast = null;
        }
        Link delete = mFirst;
        mFirst = mFirst.mNext;
        return delete;
    }

    public void displayList() {
        if (!isEmpty()) {
            System.out.print(" List (first -> last) : ");
            Link current = mFirst;
            while (current != null) {
                current.display();
                current = current.mNext;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        FirstLastLinkedList firstLastLinkedList = new FirstLastLinkedList();
        firstLastLinkedList.insertFirst(100);
        firstLastLinkedList.insertFirst(20);
        firstLastLinkedList.insertFirst(50);
        firstLastLinkedList.insertFirst(30);
        firstLastLinkedList.insertFirst(40);
        firstLastLinkedList.displayList();
        firstLastLinkedList.deleteFirst();
        firstLastLinkedList.displayList();
        firstLastLinkedList.insertLast(-20);
        firstLastLinkedList.insertLast(-30);
        firstLastLinkedList.insertLast(-40);
        firstLastLinkedList.displayList();

    }

}
