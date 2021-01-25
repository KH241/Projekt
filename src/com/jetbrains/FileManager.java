package com.jetbrains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class FileManager {

    //Filereader aus Prog_1/ Patientlist9
    public static String readFile(String filename){
        String output = "";
        File file = new File(filename);
        FileReader filereader = null;
        try {
            filereader = new FileReader(file);
        } catch (Exception e) {
            System.out.println("Datei nicht gefunden");
            System.exit(1);
        }

        BufferedReader reader = new BufferedReader(filereader);

        try {
            while (reader.ready()) {
                output += reader.readLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Lesen der Datei");
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Fehler beim Schließen der Datei");
        }
        return output;
    }

    public static void writeFile(String filename, String inhalt){
        OutputStream os = null;
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
