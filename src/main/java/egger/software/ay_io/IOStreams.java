package egger.software.ay_io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class IOStreams {
    public static void main(String[] args) throws IOException {
        OutputStream os = new GZIPOutputStream(new FileOutputStream("test.zip"));
        os.write("test".getBytes());
        os.close();

        InputStream is = new GZIPInputStream(new FileInputStream("test.zip"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int read;
        while((read = is.read(buffer)) >= 0) {
            baos.write(buffer, 0, read);
        }
        System.out.write(baos.toByteArray());
        is.close();
        baos.close();
    }
}
