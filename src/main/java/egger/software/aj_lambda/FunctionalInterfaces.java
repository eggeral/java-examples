package egger.software.aj_lambda;


public class FunctionalInterfaces {
    public static void main(String[] args) {
        times(10, ()-> System.out.println("test"));
    }

    public static void times(int times, Command cmd) {
        for (int i = 0; i < times; i++) {
            cmd.execute();
        }
    }
}
