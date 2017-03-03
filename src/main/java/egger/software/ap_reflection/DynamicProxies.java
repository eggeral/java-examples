package egger.software.ap_reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxies {
    public interface TestInterface {
        void aMethod(String arg);
        void andMethod(int arg);
    }

    public static void main(String[] args) {
        InvocationHandler handler = ( proxy,  method,  methodArgs) -> {
            if (method.getName().equals("aMethod"))
                System.out.println("aMethod called");
            if (method.getName().equals("andMethod"))
                System.out.println("andMethod called");
            return null;
        };



        TestInterface proxy = (TestInterface) Proxy.newProxyInstance(DynamicProxies.class.getClassLoader(), new Class[] { TestInterface.class }, handler);
        proxy.aMethod("hello world");
        proxy.andMethod(1);
    }

}
