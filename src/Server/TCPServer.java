package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[]) throws IOException, InterruptedException {
        int port = 3333;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        is.read();
        os.write(":)".getBytes());
        Thread.sleep(50000);
    }
}
