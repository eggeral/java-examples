package egger.software.ae_classes;

public class OuterClass {
    public static class NestedClass {

        public NestedClass() {

        }

        public void doSomething() {
            System.out.println("doSomething");
            staticTest();

            //can not access methods of the object
            //test();
        }

    }

    public static void staticTest() {}
    public void test() {}
}
