package egger.software.ae_classes;

public class Node {
    protected int x;
    protected int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int distance) {
        this.x += distance;
    }

    public static void setHGap(Node node, int width) {
        node.x += width;
    }

    public int getX() {
        return x;
    }

}
