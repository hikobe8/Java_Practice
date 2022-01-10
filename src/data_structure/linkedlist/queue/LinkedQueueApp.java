package data_structure.linkedlist.queue;

/**
 * Author : Ray
 * Created At : 2018-06-02 下午11:58
 * Email : ryu18356@gmail.com
 * Description :
 */
public class LinkedQueueApp {

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.insert(20);
        linkedQueue.insert(30);
        linkedQueue.insert(40);
        linkedQueue.insert(50);
        linkedQueue.insert(60);
        linkedQueue.displayQueue();
        linkedQueue.remove();
        linkedQueue.displayQueue();
    }

}
