package egger.software.ah_generics;

public class TypeErasure {
    public static void main(String[] args) {
        GenericBox<String> stringBox = new GenericBox<>("test");

        GenericBox objectBox = stringBox;

        objectBox.setContent(10);

        int number = (int)objectBox.getContent();

        objectBox.setContent("test2");

        String string = stringBox.getContent();

        avoidTypeErasure();
    }

    public static void avoidTypeErasure() {
        CheckedGenericBox<String> stringBox = new CheckedGenericBox<String>("test") {};
        CheckedGenericBox objectBox = stringBox;
        objectBox.setContent(10); //should throw an exception!
    }
}
