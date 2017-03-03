package egger.software.ab_main;

public class Calculator {
    private int a;
    private int b;

    private int result;

    public Calculator(int a, int b) {
        // 4. this
        this.a = a;
        this.b = b;
    }

    public void add() {
        result = a + b;
    }

    public int getResult() {
        return result;
    }

}
