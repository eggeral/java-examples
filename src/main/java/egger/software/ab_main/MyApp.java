package egger.software.ab_main;

public class MyApp {

    // 1. static
    public static void main(String[] args) {
        // 2. simple Hello World
        System.out.println("Hello World");

        // 3. create an object
        Calculator calc = new Calculator(1, 2);

        // 4. call a method
        calc.add();
        int result = calc.getResult();

        // 5. output the result. Note the String concat with + (operator overloading)
        System.out.println("The result is: " + result);
    }

}
