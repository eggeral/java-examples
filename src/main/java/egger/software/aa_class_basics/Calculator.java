package egger.software.aa_class_basics;

// 1. class
public class Calculator {
    // 3. field
    private int a;
    private int b;

    private int result;

    // 2. constructor
    public Calculator(int a, int b) {
        // 4. this
        this.a = a;
        this.b = b;
    }

    // 5. void method
    public void add() {
        result = a + b;
    }

    // 6. method with return value
    public int getResult() {
        return result;
    }

}
