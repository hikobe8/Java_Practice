package data_structure.linkedlist.sortedList;

/**
 * Author : Ray
 * Created At : 2018-06-03 下午4:13
 * Email : ryu18356@gmail.com
 * Description : 有序链表
 */
public class SortedLinkedList {

    class Link {
        public int mData;
        public Link mNext;

        public Link(int data) {
            mData = data;
        }

        public void display() {
            System.out.print( mData + " " );
        }

    }

    private Link mFirst;

    public boolean isEmpty() {
        return mFirst == null;
    }

    public void insert(int data) {

        Link previous = null;
        Link current = mFirst;
        Link newLink = new Link(data);
        while (current != null && data > current.mData) {
            previous = current;
            current = current.mNext;
        }

        if (previous == null) {
            //insert at first
            mFirst = newLink;
        } else {
            previous.mNext = newLink;
        }
        newLink.mNext = current;

    }

    public int remove() {
        Link temp = mFirst;
        mFirst = mFirst.mNext;
        return temp.mData;
    }


    public void displayList() {

        if (!isEmpty()) {

            System.out.print("SortedLinkedList : ");
            Link link = mFirst;
            while (link != null) {
                link.display();
                link = link.mNext;
            }
            System.out.println();
        }
    }

}
