package data_structure.linkedlist.doublelist;

/**
 * Author : Ray
 * Created At : 2018-07-20 下午1:55
 * Email : ryu18356@gmail.com
 * Description : 双向链表的数据节点
 */
public class Link {

    public Link mPrevious;
    public Link mNext;
    public int mData;

    public Link(int data) {
        mData = data;
    }

    public void display() {
        System.out.print(mData + " ");
    }
}
