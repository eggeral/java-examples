package egger.software.ay_io;

import java.io.StringReader;
import java.util.Scanner;

public class ScannerUsage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new StringReader("text\n1,2,3"));
        System.out.println(scanner.nextLine());
        scanner.useDelimiter(",");
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());

    }

}
