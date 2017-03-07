package egger.software.ah_generics;

public class CoContra {
    public static class Box<TElement> {
        private TElement value;

        public TElement getValue() {
            return value;
        }

        public void setValue(TElement value) {
            this.value = value;
        }

    }

    public static class A {
        int a;
    }

    public static class B extends A {
        int b;
    }

    public static class C extends B {
        int c;
    }

    public static void main(String[] args) throws Exception {

        Box<A> aBox = new Box<>();
        aBox.setValue(new A());
        aBox.setValue(new B());
        aBox.setValue(new C());
        A a = aBox.getValue();
        //B b = aBox.getValue();
        //C c = aBox.getValue();

        Box<B> bBox = new Box<>();
        //bBox.setValue(new A());
        bBox.setValue(new B());
        bBox.setValue(new C());

        a = bBox.getValue();
        B b = bBox.getValue();
        //C c = bBox.getValue();

        Box<C> cBox = new Box<>();
        // aBox = cBox // does not compile
        Box<? extends A> extendsABox = cBox; //co variant
        //extendsABox.setValue(new A()); // does not compile
        //extendsABox.setValue(new B());
        //extendsABox.setValue(new C());
        //C c = extendsABox.getValue();
        //b = extendsABox.getValue();
        a = extendsABox.getValue();

        Box<? super C> superCBox = aBox;
        //superCBox.setValue(new A());
        //superCBox.setValue(new B());
        superCBox.setValue(new C());
//        C c = superCBox.getValue();
//        b = superCBox.getValue();
//        a = superCBox.getValue();
    }
}
