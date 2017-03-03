package egger.software.ap_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static class Container {
        private int value;

        public void printValue() {
            System.out.println(value);
        }
    }

    public static class SubContainer extends Container {
        public int anotherValue;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            NoSuchFieldException {

        // dynamically create objects and invoke methods.
        Class<?> stringClass = Class.forName("java.lang.String");
        Object stringInstance = stringClass.getConstructor(String.class).newInstance("TEST");
        Method charAt = stringClass.getMethod("charAt", int.class);
        System.out.println(charAt.invoke(stringInstance, 2));

        // access members (even private ones)
        Container container = new Container();
        // Field valueField = Container.class.getField("value") //ony gets public fields!
        Field valueField = Container.class.getDeclaredField("value");
        valueField.setAccessible(true);
        valueField.setInt(container, 10);
        container.printValue();

        // access inherited members
        SubContainer subContainer = new SubContainer();
        Field anotherValueField = SubContainer.class.getDeclaredField("anotherValue");
        valueField.set(subContainer, 20);
        anotherValueField.set(subContainer, 30);
        subContainer.printValue();
        System.out.println(subContainer.anotherValue);

    }

}
