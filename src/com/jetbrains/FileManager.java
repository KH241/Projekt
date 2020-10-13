package com.jetbrains;

import java.io.*;

public class FileManager {
    public static String readFile(String filename){
        InputStream is=null;
        try {
            is=new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open File");
            System.out.println(e);
            System.exit(0);
        }
        byte[] readBuffer = new byte[100];
        try{
            is.read(readBuffer);
        }catch (IOException e){
            System.out.println("Couldn't read data");
            System.exit(0);
        }
        String readString = new String(readBuffer);
        return readString;
    }
    public static void writeFile(String filename, String inhalt){
        OutputStream os=null;
        try{
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open file");
            System.exit(0);
        }
        byte[] textAsByte = inhalt.getBytes();
        try {
            os.write(textAsByte);
        } catch (IOException e) {
            System.out.println("Couldn't write data");
            System.exit(0);
        }
    }
}
