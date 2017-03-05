package egger.software.am_examples;

public class IntStack {

    private IntLinkedList list = new IntLinkedList();

    public void push(int value) {
        list.add(value);
    }

    public int top() {
        return list.get(0);
    }

    public int pop() {
        int result = list.get(0);
        list.removeFirst();
        return result;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack { ");
        builder.append("size: ");
        builder.append(list.getSize());
        builder.append("; [");
        for (int idx = 0; idx < list.getSize(); idx++) {
            if (idx != 0)
                builder.append(", ");
            builder.append(list.get(idx));
        }
        builder.append("]}");
        return builder.toString();

    }
}
