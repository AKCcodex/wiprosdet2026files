package day10;
import java.io.*;

public class FileStats {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        int lines = 0, words = 0, characters = 0;
        String line;
        while ((line = br.readLine()) != null) {
            lines++;

            characters += line.length();

            String[] wordArray = line.trim().split("\\s+");
            if (!line.trim().isEmpty()) {
                words += wordArray.length;
            }
        }
        br.close();
        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Characters: " + characters);
    }
}