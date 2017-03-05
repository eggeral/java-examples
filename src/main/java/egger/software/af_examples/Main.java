package egger.software.af_examples;

public class Main {
    public static void main(String[] args) {
        System.out.println("== IntLinkedList ==");
        testLinkedList();
        System.out.println();
        System.out.println("== IntStack ==");
        testIntStack();
    }

    private static void testLinkedList() {
        IntLinkedList list = new IntLinkedList();
        System.out.println("Empty list: " + list);
        list.add(1);
        System.out.println("Added 1: " + list);
        list.add(2);
        System.out.println("Added 2: " + list);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Added 3, 4, 5: " + list);

        System.out.println("Get idx 0: " + list.get(0));
        System.out.println("Get idx 2: " + list.get(2));
        System.out.println("Get idx 3: " + list.get(3));
        System.out.println("Get idx -1: " + list.get(-1));
        System.out.println("Get idx 4: " + list.get(4));
        System.out.println("Get idx 5: " + list.get(5));


        list.removeFirst();
        System.out.println("Removed first: " + list);
        list.remove(4);
        System.out.println("Removed 4: " + list);
        list.remove(4);
        System.out.println("Removed 4 (again): " + list);
        list.remove(2);
        System.out.println("Removed 2: " + list);
        list.remove(1);
        list.remove(3);
        System.out.println("Removed 1,3: " + list);
        list.remove(1);
        System.out.println("Removed 1 from empty list: " + list);
        list.removeFirst();
        System.out.println("Removed first from empty list: " + list);
    }

    public static void testIntStack() {

        IntStack stack = new IntStack();
        System.out.println("Empty stack: " + stack);
        stack.push(1);
        System.out.println("Pushed 1: " + stack);
        System.out.println("Top is: " + stack.top());
        int result = stack.pop();
        System.out.println("Pop called: " + stack.top());
        System.out.println("Result of pop is: " + result);
        System.out.println("Trying to pop from empty stack throws exception");
        result = stack.pop(); // ups!

    }
}
