package data_structure.queue;

import java.util.Scanner;

public class QueueApp {

    public static void main(String[] args) {

        Queue queue = new Queue(3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("菜单");
            System.out.println("a: 插入队列");
            System.out.println("b: 查看队列");
            System.out.println("c: 出队");
            System.out.println("d: 查看队首");
            System.out.print("输入菜单选项: ");
            String next = scanner.nextLine();
            if (next.equals("a")) {
                while (true) {
                    System.out.print("请输入数字, 输入任意字符结束输入: ");
                    try {
                        int num = Integer.parseInt(scanner.nextLine());
                        if (queue.isFull()) {
                            System.out.println("队列已满!");
                            break;
                        }
                        queue.insert(num);
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
            } else if (next.equals("b")) {
                queue.display();
                System.out.println();
            } else if (next.equals("c")) {
                if (queue.isEmpty()) {
                    System.out.println("队列为空");
                    continue;
                }
                queue.remove();
            } else {
                System.out.println("队首: " + queue.peek());
            }
        }

    }

}
