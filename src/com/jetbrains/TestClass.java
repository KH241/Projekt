package com.jetbrains;

public class TestClass {
    public static boolean testFileManager(){
        String sometext="dshafjlksahdf";
        FileManager.writeFile("test.txt",sometext);
        String test = FileManager.readFile("test.txt");
        return test.contains(sometext);
    }
}
