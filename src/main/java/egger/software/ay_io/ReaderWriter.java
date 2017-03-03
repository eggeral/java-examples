package egger.software.ay_io;

import java.io.*;

public class ReaderWriter {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("test.txt");
        writer.write("test");
        writer.close();

        LineNumberReader reader = new LineNumberReader(new FileReader("test.txt"));
        System.out.print(reader.readLine());
        reader.close();
    }
}
