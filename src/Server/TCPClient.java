package Server;

import com.jetbrains.FileManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TCPClient {
    private int port;
    private String name;
    private Socket socket;

    public static void main(String[] args) throws IOException {
        TCPClient tcpClient= new TCPClient("localhost",3333);
        tcpClient.connection();
        tcpClient.sendFile("test.txt");
        //tcpClient.sendSensorData(1232123132, (float) 12.21123213,"Cooler sensor");
        //tcpClient.receiveSensorData();
    }
    TCPClient(String name, int port){
        this.name=name;
        this.port=port;
    }
    private void connection() throws IOException {
        this.socket= new Socket(this.name,this.port);
    }
    private void  sendFile(String filename) throws IOException {
        OutputStream os = this.socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(filename);
        ps.println(FileManager.readFile(filename));
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
