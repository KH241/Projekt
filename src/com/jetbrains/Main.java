package com.jetbrains;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        String sometext="dshafjkhflksahdf";
        FileManager.writeFile("test.txt",sometext);
        String test= FileManager.readFile("test.txt");
        System.out.println(test);
    }
}
