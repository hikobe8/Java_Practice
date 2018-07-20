package data_structure.linkedlist.doublelist;

/**
 * Author : Ray
 * Created At : 2018-07-20 下午3:07
 * Email : ryu18356@gmail.com
 * Description :
 */
public class DoublyApp {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(2);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertLast(4);
        doublyLinkedList.insetAfter(3, 10);
        doublyLinkedList.insetAfter(10, 5);
        doublyLinkedList.insetAfter(2, 8);
        doublyLinkedList.display();
        System.out.println(doublyLinkedList.deleteFirst());
        doublyLinkedList.display();
        System.out.println(doublyLinkedList.deleteLast());
        doublyLinkedList.display();
        doublyLinkedList.delete(10);
        doublyLinkedList.display();
    }

}
