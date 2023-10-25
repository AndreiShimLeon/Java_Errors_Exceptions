package Seminar3.Task1;
import java.io.*;
import java.nio.file.Path;



public class Program {
    private static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        //BufferedReader in = null;
        //BufferedWriter out = null;

        try (BufferedReader in = new BufferedReader(new FileReader(pathRead.toFile()));
             BufferedWriter out = new BufferedWriter(new FileWriter(pathWrite.toFile()))) {
            out.write(in.readLine());
        }
    }
    public static void main(String[] args) throws IOException {
        rwLine(Path.of("pom.xml"), Path.of("test"));
    }
}