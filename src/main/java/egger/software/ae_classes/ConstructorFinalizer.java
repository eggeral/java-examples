package egger.software.ae_classes;


public class ConstructorFinalizer {

    String value;

    public ConstructorFinalizer(String value) {
        System.out.println("construct: " + value);
        this.value = value;
    }

    public void finalize() {
        System.out.println("finalize: " + value);
    }

}
