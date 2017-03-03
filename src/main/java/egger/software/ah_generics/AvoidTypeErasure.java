package egger.software.ah_generics;

public class AvoidTypeErasure {
    public static void main(String[] args) {
        CheckedGenericBox<String> stringBox = new CheckedGenericBox<String>("test") {};
        CheckedGenericBox objectBox = stringBox;
        objectBox.setContent(10); //should throw an exception!
    }
}
