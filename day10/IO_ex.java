package day10;

import java.io.*;

public class IO_ex {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("./sai.txt");
        fw.write("Hello Java IO");
        fw.close();
    }
}