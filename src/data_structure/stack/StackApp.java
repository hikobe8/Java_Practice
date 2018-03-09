package data_structure.stack;


public class StackApp {

    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push(80);
        stackX.push(50);
        stackX.push(30);
        stackX.push(100);
        while (!stackX.isEmpty()) {
            System.out.println(stackX.pop());
        }
    }

}
