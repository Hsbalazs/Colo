import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileModifier {
    public static void main(String[] args) {
        //File folder = new File("c:/Users/hubhs/Desktop/New/");
        File folder = new File("//fshutat01/operations_development/Users/HUGDANY/OC1504_FTV_11_exp/");

        File[] listOfFiles = folder.listFiles();

        Scanner scan = new Scanner(System.in);
        System.out.println("Írd be a lecserélni kívánt szöveget: ");
        String oldText = scan.nextLine();
        System.out.println("Írd be az új szöveget: ");
        String newText = scan.nextLine();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Path filePath = Paths.get(file.getPath());
                    List<String> lines = Files.readAllLines(filePath);
                    List<String> newLines = new ArrayList<>();

                    for (String line : lines) {
                        String newLine = line.replaceAll(oldText,newText);
                        newLines.add(newLine);
                    }
                    Files.write(filePath,newLines,StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException i){
                    System.out.println("Unable to read the file: " + file);
                }
            }
        }
    }
}