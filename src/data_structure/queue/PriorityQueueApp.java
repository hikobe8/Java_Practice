package data_structure.queue;

/**
 * Author : Ray
 * Created At : 2018-06-20 下午11:25
 * Email : ryu18356@gmail.com
 * Description :
 */
public class PriorityQueueApp {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(30);
        priorityQueue.insert(12);
        priorityQueue.insert(34);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }

}
