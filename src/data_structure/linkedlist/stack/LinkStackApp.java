package data_structure.linkedlist.stack;

/**
 * Author : Ray
 * Created At : 2018-05-27 下午11:24
 * Email : ryu18356@gmail.com
 * Description :
 */
public class LinkStackApp {

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(20);
        linkedStack.push(30);
        linkedStack.push(40);
        linkedStack.push(50);
        linkedStack.push(10);
        linkedStack.push(90);
        linkedStack.display();
    }

}
