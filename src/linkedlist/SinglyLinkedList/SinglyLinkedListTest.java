package linkedlist.SinglyLinkedList;

public class SinglyLinkedListTest {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            singlyLinkedList.insertFirst(i);
        }
        singlyLinkedList.displayList();
        singlyLinkedList.reverseList(); // 反转列表
        System.out.println("反转链表");
        singlyLinkedList.displayList();
        String result9 = singlyLinkedList.find(9) != null ? "是" : "否";
        System.out.println("查找链表中是否有包含9的节点 : " + result9);
        String result10 = singlyLinkedList.find(10) != null ? "是" : "否";
        System.out.println("查找链表中是否有包含10的节点 : " + result10);
        singlyLinkedList.delete(5);
        singlyLinkedList.delete(9);
        singlyLinkedList.delete(0);
        System.out.println("删除之后的链表");
        singlyLinkedList.displayList();
    }

}
