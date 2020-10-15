package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private int port;

    public static void main(String[] args) throws IOException, InterruptedException {

        TCPServer tcpServer = new TCPServer(3333);

        tcpServer.dostuff();

    }

    TCPServer(int port) {

        this.port = port;

    }

    private void dostuff() throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(this.port);
        System.out.println("Server startet");

        Socket socket = server.accept();
        System.out.println("Waiting for Client");

        socket.getInputStream().read();
        System.out.println("Lese Dinge");

        OutputStream os = socket.getOutputStream();
        os.write(":) xD".getBytes());
        os.close();
        System.out.println("Sending out good vibes");

        System.out.println("Mittagsschlaf");
        Thread.sleep(5000);

        System.out.println("Wieder wach");
    }

}
