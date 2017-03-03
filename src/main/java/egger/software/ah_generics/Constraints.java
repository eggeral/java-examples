package egger.software.ah_generics;

public class Constraints {
    public static void main(String[] args) {
        ConstraintBox<Integer> box = new ConstraintBox<>(10);
        //ConstraintBox<String> box1 = new ConstraintBox<>("test");

        //this never works! Primitive types not allowed
        //ConstraintBox<int> box1 = new ConstraintBox<>(10);
    }
}
