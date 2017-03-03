package egger.software.ac_statements;

enum Color {red, green, unknown}

public class Statements {
    public static void main(String[] args) {

        String[] strings = {"a", "b", "a"};

        System.out.println("- if");
        if (strings.length == 0) {
            System.out.println("arg please");
            System.exit(1);
        }

        System.out.println("- if else");
        if (strings[0].equals("a"))
            System.out.println("a");
        else
            System.out.println("not a");

        System.out.println("- for");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + " - " + strings[i]);
        }

        System.out.println("- for each");
        for (String str : strings) {
            System.out.println(str);
        }

        System.out.println("- while");
        int count = 3;
        while (count > 0) {
            System.out.println(count--);
        }

        System.out.println("- do while");
        do {
            System.out.println(count++);
        } while (count < 3);

        System.out.println("- break");
        for (String str : strings) {
            if (str.equals("b"))
                break;
            System.out.println(str);
        }

        System.out.println("- continue");
        for (String str : strings) {
            if (str.equals("b"))
                continue;
            System.out.println(str);
        }

        System.out.println("- switch with primitive types");
        int number = 1;
        switch (number) {
            case 0:
                System.out.println("None");
                return;
            case 1:
                System.out.println("One");
                break;
            case 2:
            case 3:
                System.out.println("Many");
                break;
            default:
                System.out.println("Too many");
        }

        System.out.println("- switch with strings");
        String colorStr = "red";
        switch (colorStr) {
            case "red":
                System.out.println("red");
                break;
            case "green":
                System.out.println("green");
                break;
            default:
                System.out.println("unknown");
        }

        System.out.println("- switch with enum");
        Color color = Color.green;
        switch (color) {
            case red:
                System.out.println("red");
                break;
            case green:
                System.out.println("green");
                break;
            default:
                System.out.println("unknown");
        }

        System.out.println("- type casting");
        System.out.println("75 casted to char is K: " + (char) 75);
        System.out.println("987654321 casted to short is 26801: " + (short) 987654321);
        System.out.println("127 casted to byte is 127: " + (byte) 127);
        System.out.println("128 casted to byte is -128: " + (byte) 128);
        System.out.println("256 casted to byte is 0: " + (byte) 256);

        Number num = new Float(10.0);
        //num.isNaN();  // num has no .isNaN()
        //Integer test = (Integer) num; // class cast exception at runtime
        System.out.println(((Float) num).isNaN());

        System.out.println("- auto boxing");
        int test1 = 1;
        int test2 = new Integer(2);
        Integer test3 = 3;

        System.out.println("- var args");
        printNumbers("hello1", 1,2,3,4);
        printNumbers("hello2", new int[] {1,2,3,4});


    }

    public static void printNumbers(String prefix, int... numbers) {
        for (int number : numbers) {
            System.out.println(prefix + " - " + number);
        }
    }

}
