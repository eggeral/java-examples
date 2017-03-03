package egger.software.ay_io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Sockets {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorService = new ExecutorCompletionService<>(threadPool);

        ServerSocket serverSocket = new ServerSocket(9004);

        Future<String> result = executorService.submit(() -> {
            Socket client = serverSocket.accept();
            System.out.println("connected");
            LineNumberReader reader  = new LineNumberReader(new InputStreamReader(client.getInputStream()));
            client.close();
            return reader.readLine();
        });

        Socket socket = new Socket("localhost", 9004);
        socket.getOutputStream().write("Hello server\n".getBytes());
        socket.close();

        System.out.println(result.get());
        threadPool.shutdownNow();

    }
}
