package data_structure.linkedlist.singlylinkedlist;

/**
 * 链表中的节点元素,为链表的最小组成单元
 */
public class LinkNode {

    public int mData;

    public LinkNode mNext;

    public LinkNode(int data) {
        mData = data;
    }

    public void display(){
        System.out.println(mData);
    }

}
