package data_structure.linkedlist.queue;

import data_structure.linkedlist.firstlastlist.FirstLastLinkedList;

/**
 * Author : Ray
 * Created At : 2018-06-02 下午11:48
 * Email : ryu18356@gmail.com
 * Description : 链表实现的队列
 */
public class LinkedQueue {

    private FirstLastLinkedList mLinkedList;

    public LinkedQueue() {
        mLinkedList = new FirstLastLinkedList();
    }

    public void insert(int data) {
        mLinkedList.insertLast(data);
    }

    public int remove() {
        return mLinkedList.deleteFirst().mData;
    }

    public void displayQueue() {
        System.out.print(" Queue head->last : ");
        mLinkedList.displayList();
    }

}
