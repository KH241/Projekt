package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private int port;
    private ServerSocket server;
    private Socket socket;
    public static void main(String[] args) throws IOException{
        TCPServer tcpServer = new TCPServer(3333);
        tcpServer.connection();

        //tcpServer.receiveSensorData();
        //tcpServer.receiveFile();
    }

    TCPServer(int port) {
        this.port = port;
    }
    private void connection() throws IOException{
        this.server = new ServerSocket(this.port);
        this.socket = this.server.accept();
    }
    private void receiveFile() throws IOException {
        InputStream is = this.socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os=null;
        String filename="server/";
        filename+=br.readLine();
        try {
             os = new FileOutputStream(filename);
        }catch (Exception e){
            System.out.println("Problem opening File");
        }
        try{
            while (true) {
                os.write((br.readLine()+"\n").getBytes());
            }
        }catch (Exception e){
            System.out.println("Problem reading File");
        }
    }
    private void receiveSensorData() throws IOException {
        InputStream is = this.socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        try{
            long readTime = dis.readLong();
            System.out.println("Got: "+readTime);
            float readValue = dis.readFloat();
            System.out.println("Got: "+readValue);
            String readName = dis.readUTF();
            System.out.println("Got: "+readName);
            //sendSensorData(readTime,readValue,readName);
        }catch (Exception e){
            System.out.println("Problem receiving data");
        }
    }
    private void sendSensorData(long time, float value, String name) throws IOException {
        OutputStream os=this.socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        try{
            dos.writeLong(time);
            System.out.println("Sent: "+time);
            dos.writeFloat(value);
            System.out.println("Sent: "+value);
            dos.writeUTF(name);
            System.out.println("Sent: "+name);
        }catch (Exception e){
            System.out.println("Couldnt send data");
        }
    }
}
