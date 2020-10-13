package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[]) {
        int port = 3333;
        try{
            //Server starten
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server startet ... ");

            //Auf Client warten
            Socket socket = server.accept();
            System.out.println("Waiting for Client ... ");

            //Input lesen
            InputStream is = socket.getInputStream();
            byte[] test=new byte[1];
            is.read(test);

            //Zurück schicken
            OutputStream os = socket.getOutputStream();
            os.write(":)".getBytes());
        }catch (Exception e){
            System.out.println("sdjfkl");
        }
    }
}
