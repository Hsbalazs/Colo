import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        //File folder = new File("c:/Users/hubhs/Desktop/New/");
        File folder = new File("//fshutat01/operations_development/Users/HUGDANY/OC1504_PT_FTV_11/");

        File[] listOfFiles = folder.listFiles();

        Scanner scan = new Scanner(System.in);
        //System.out.println("Írd be a keresendő szöveget: ");
        //String text = scan.nextLine();
        String text1 = "fileName=\"WebBrowser.ocx\" fileVersion=\"";
        String text2 = "fileName=\"ME_Chart.ocx\" fileVersion=\"";
        int count = 0;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Path filePath = Paths.get(file.getPath());
                    List<String> lines = Files.readAllLines(filePath);

                    for (String line : lines) {
                        if (line.contains(text1) || line.contains(text2)) {
                            int startIndex = line.indexOf("filename=");
                            //if (line.substring(startIndex,startIndex + 39).equals("fileVersion=\"8.20.10.43\"")) {
                            //    System.out.println(line.substring(startIndex,startIndex + 24) + "        OK, nem kell módosítani.");
                            //} else {
                                System.out.println(line.substring(startIndex,startIndex + 39) + " " + file);
                            //}
                            count++;
                        }
                    }
                } catch (IOException i){
                    System.out.println("Unable to read the file: " + file);
                }
            }
        }
        System.out.println(count);
    }
}