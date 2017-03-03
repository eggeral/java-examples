package egger.software.ah_generics;

public class GenericMethods {
    public static void main(String[] args) {
        GenericBox<String> box = new GenericBox<>("test");
        setContent(box, "test");
        //setContent(box, 1); does not compile
    }

    public static <TContent> void setContent(GenericBox<TContent> box, TContent content) {
        box.setContent(content);
    }
}
