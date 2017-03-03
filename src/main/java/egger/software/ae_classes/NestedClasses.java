package egger.software.ae_classes;

public class NestedClasses {

    String msg;

    public NestedClasses(String msg) {
        this.msg = msg;
    }

    public class NonStaticNestedClass {

        public void doSomething() {
            //can access fields of the enclosing object
            System.out.println("Message: " + msg);
            //can access methods of the enclosing object
            outerDoSomething();
            //can access methods of the enclosing class
            outerDoSomethingElse();
        }
    }

    private void outerDoSomething() { System.out.println("outerDoSomething"); }

    private static void outerDoSomethingElse() { System.out.println("outerDoSomethingElse"); }

    public void showNonStaticUse() {

        NonStaticNestedClass obj1 = new NonStaticNestedClass();

        obj1.doSomething();

    }

}
