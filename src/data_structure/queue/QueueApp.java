package data_structure.queue;

public class QueueApp {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        for (int i = 0; i < 10; i++) {
            queue.insert(i*10);
        }

        queue.remove();
        queue.insert(35);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }

}
