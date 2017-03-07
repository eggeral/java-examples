package egger.software.ae_classes;

public class Main {
/*

            | Class | Package | Subclass | Subclass | World
            |       |         |(same pkg)|(diff pkg)|
————————————+———————+—————————+——————————+——————————+————————
public      |   +   |    +    |    +     |     +    |   +
————————————+———————+—————————+——————————+——————————+————————
protected   |   +   |    +    |    +     |     +    |   o
————————————+———————+—————————+——————————+——————————+————————
no modifier |   +   |    +    |    +     |     o    |   o
————————————+———————+—————————+——————————+——————————+————————
private     |   +   |    o    |    o     |     o    |   o

+ : accessible
o : not accessible

*/

    public static void main(String[] args) throws InterruptedException {
        showAClass();
        packageAndImport();
        constructorFinalizer();
        initializers();
        staticNestedClasses();
        nestedClasses();
        localClasses();
        interfaces();
        anonymousClasses();
        simpleEnum();
        complexEnum();
        simpleInheritance();
        inheritance();
        javaBeans();
        showToString();
    }

    private static void showToString() {
        class AClass {
            int value;

            @Override
            public String toString() {
                return "AClass{" +
                        "value=" + value +
                        '}';
            }
        }

        AClass obj = new AClass();
        System.out.println(obj.toString());
        System.out.println(obj);
    }

    private static void javaBeans() {
        JavaBean bean = new JavaBean();
        bean.setExampleProperty(25);
        System.out.println(bean.getExampleProperty());
        bean.setBoolProperty(true);
        System.out.println(bean.isBoolProperty());
    }

    public static void packageAndImport() {
        System.out.println(PackageAndImport.absTest);
    }

    public static void simpleInheritance() {
        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        Circle circle = new Circle();
        circle.draw();

        Shape shape = new Shape() {
            @Override
            public void draw() {
                System.out.println("Draw shape");
            }
        };
        shape.draw();
    }

    public static void inheritance() {
        Node child = new Node(40, 50);
        Parent parent = new Parent(10, 20, child);

        child.move(100);
        parent.move(100);
        System.out.println(child.getX());
        System.out.println(parent.getX());

        Node.setHGap(parent, 100);
        Parent.setHGap(parent, 100); // can access a static method of a super class

    }

    public static void complexEnum() {
        Planet planet = Planet.mars;
        System.out.println(planet.distanceTo(Planet.venus));
    }

    public static void simpleEnum() {
        Color color = Color.green;
        System.out.println(color);
        System.out.println(color.name());
        System.out.println(color.ordinal());
        for (Color c : Color.values()) {
            System.out.println(c);
        }
        Color red = Color.valueOf("red");
        System.out.println(red);
    }

    public static void anonymousClasses() {
        final String msg = "Hello World";

        Command command = new Command() {
            @Override
            public void execute() {
                System.out.println(msg);
            }
        };

        command.execute();

    }

    public static void interfaces() {
        Command command = new PrintCommand();

        command.execute();
        command.printConstantAndExecute();

        Command.printConstant();

        System.out.println(Command.constant);
    }

    public static void localClasses() {
        class LocalClass {
            int test;
        }

        LocalClass local = new LocalClass();
        local.test = 1;

    }

    public static void staticNestedClasses() {
        OuterClass.NestedClass target = new OuterClass.NestedClass();
        target.doSomething();
    }

    public static void nestedClasses() {
        NestedClasses target = new NestedClasses("test1");
        NestedClasses.NonStaticNestedClass nested1 = target.new NonStaticNestedClass();
        nested1.doSomething();

        target.showNonStaticUse();
    }

    public static void initializers() {
        Initializers target = new Initializers();
    }

    public static void constructorFinalizer() throws InterruptedException {
        ConstructorFinalizer target = new ConstructorFinalizer("test");
        target = null;
        System.gc();
        Thread.sleep(1000);
    }

    public static void showAClass() {
        System.out.println(AClass.staticField);
        AClass.staticMethod();

        AClass instance = new AClass();
        System.out.println(instance.fieldOfAnInstance);
        instance.methodOfAnInstance();

        instance.staticMethod(); // Not a good idea
    }

}
