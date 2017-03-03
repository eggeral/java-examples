package egger.software.ae_classes;


public class Parent extends Node {

    private Node child;

    //constructors are not inherited
    public Parent(int x, int y, Node child) {
        super(x, y);
        this.child = child;
    }

    @Override //mark as override!
    public void move(int distance) {
        y += distance;
    }

    //@Override can not override static methods
    //public static void setHGap(Node node, int width) {
    //    node.y += width;
    //}

}
