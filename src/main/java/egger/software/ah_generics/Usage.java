package egger.software.ah_generics;

public class Usage {

    public static void main(String[] args) {
        Box box = new Box("test");
        String content = (String) box.getContent(); //ugly

        GenericBox genericBox =
                new GenericBox("test2");
        content = (String)genericBox.getContent();

        GenericBox<String> stringGenericBox =
                new GenericBox<String>("test3");
        content = stringGenericBox.getContent();

        GenericBox<String> stringGenericBox2 =
                new GenericBox<>("test4"); //diamond operator
        content = stringGenericBox2.getContent();

        Integer intContent = (Integer) box.getContent();

    }
}
