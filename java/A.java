import java.nio.file.*;

public class A {

    private static final String testFilePath = "/mnt/c/linux/wsmt-5programs/test.txt";

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String line32 = Files.readAllLines(Paths.get(testFilePath)).get(1);
        System.out.println(line32);

    }
}