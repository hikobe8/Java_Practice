package data_structure.linkedlist.stack;

import data_structure.linkedlist.firstlastlist.FirstLastLinkedList;

/**
 * Author : Ray
 * Created At : 2018-05-27 下午11:18
 * Email : ryu18356@gmail.com
 * Description : 链表实现的栈
 */
public class LinkedStack {

    private FirstLastLinkedList mLinkedList;

    public LinkedStack() {
        mLinkedList = new FirstLastLinkedList();
    }

    public void push( int data ) {
        mLinkedList.insertFirst(data);
    }

    public int pop() {
        FirstLastLinkedList.Link link = mLinkedList.deleteFirst();
        return link.mData;
    }

    public void display() {
        System.out.print( " LinkedStack  top->bottom : " );
        mLinkedList.displayList();
    }

}
