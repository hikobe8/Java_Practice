package data_structure.linkedlist.SinglyLinkedList;

/**
 * 单向链表实现
 */
public class SinglyLinkedList {

    /**
     * 始终指向链表的第一个元素节点
     */
    private LinkNode mHead;

    public boolean isEmpty(){
        return mHead == null;
    }

    public void insertFirst(int data) {
        LinkNode node = new LinkNode(data);
        node.mNext = mHead;
        mHead = node;
    }

    public void displayList(){
        if (isEmpty()) return;
        LinkNode node = mHead;
        while (node != null) {
            node.display();
            node = node.mNext;
        }
    }

    public LinkNode find(int data) {
        LinkNode curNode = mHead;
        while (curNode.mData != data) {
            if (curNode.mNext == null) {
                return null; //没有找到
            }
            curNode = curNode.mNext;
        }
        return curNode;
    }

    public LinkNode delete(int data) {
        if (isEmpty()) return null;
        LinkNode preNode = mHead;
        LinkNode curNode = mHead;
        while (curNode.mData != data) {
            if (curNode.mNext == null) {
                System.out.println("can't find node = " + data);
                return null;
            }
            preNode = curNode;
            curNode = curNode.mNext;
        }
        if (curNode == mHead) { // 特别注意,更改头部元素mHead引用为下一个元素完成删除第一个元素节点
            mHead = mHead.mNext;
        }
        preNode.mNext = curNode.mNext;
        return curNode;
    }

    /**
     * 单向链表的反转
     */
    public void reverseList(){
        if (isEmpty()) return;
        LinkNode preNode = mHead; // 代表当前节点的前一个节点元素
        LinkNode curNode = mHead.mNext; //当前节点元素
        LinkNode nextNode; //代表当前节点的后一个元素节点
        while (curNode != null) { // 循环条件为当前节点不为空
            nextNode = curNode.mNext; // 先获取当前节点的后一个节点,并且使用这个引用暂存起来
            curNode.mNext = preNode; //更改当前节点的下一个节点引用为前一个节点,使节点逆序
            preNode = curNode; //这两步就是步进引用为后一个元素,分别赋值引用前后元素
            curNode = nextNode;
        }
        mHead.mNext = null;
        //重置链表的头部引用
        mHead = preNode;
    }


}
