package egger.software.am_examples;

public class IntLinkedList {
    private IntNode first;
    private int size;

    public void add(int value) {
        IntNode newNode = new IntNode();
        newNode.setValue(value);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public Integer get(int index) {

        if (index >= size || index < 0)
            return null;

        IntNode tmp = first;
        for (int idx = 0; idx < index; idx++) {
            tmp = tmp.getNext();
        }

        return tmp.getValue();

    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
            size--;
        }
    }

    public void remove(int value) {

        IntNode tmp = first;
        IntNode previous = null;

        while (tmp != null) {
            if (tmp.getValue() == value) {
                if (previous != null) {
                    previous.setNext(tmp.getNext());
                } else {
                    first = tmp.getNext();
                }
                size--;
                return;
            }
            previous = tmp;
            tmp = tmp.getNext();
        }

    }

    @Override
    public String toString() {
        IntNode tmp = first;
        StringBuilder builder = new StringBuilder();
        builder.append("IntLinkedList { ");
        builder.append("size: ");
        builder.append(size);
        builder.append("; [");
        boolean firstEntryWritten = false;
        while (tmp != null) {
            if (firstEntryWritten)
                builder.append(", ");
            else
                firstEntryWritten = true;
            builder.append(tmp.getValue());
            tmp = tmp.getNext();
        }
        builder.append("]}");
        return builder.toString();
    }

    public int getSize() {
        return size;
    }
}
