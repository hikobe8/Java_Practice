package data_structure.linkedlist.sortedList;

/**
 * Author : Ray
 * Created At : 2018-06-03 下午4:34
 * Email : ryu18356@gmail.com
 * Description :
 */
public class SortedLinkedListApp {

    public static void main(String[] args) {
        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        sortedLinkedList.insert(60);
        sortedLinkedList.insert(40);
        sortedLinkedList.insert(50);
        sortedLinkedList.displayList();
        sortedLinkedList.insert(100);
        sortedLinkedList.displayList();
    }

}
