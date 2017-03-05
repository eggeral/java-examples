package egger.software.am_examples;

public class IntNode {
    private int value;
    private IntNode next;

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public IntNode getNext() {
        return next;
    }
}
