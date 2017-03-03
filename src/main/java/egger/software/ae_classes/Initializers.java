package egger.software.ae_classes;

public class Initializers {

    static {
        System.out.println("Static initializer");
    }

    {
        System.out.println("Object initializer");
    }

}
