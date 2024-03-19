import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Location {
    public int number = (int)Math.floor(Math.random() * 9 + 1);
    public int[][] location = new int[9][9];
    public int[][] generateLocation() {
        int number = (int)Math.floor(Math.random() * 9 + 1);
        //List<Integer> lines = new ArrayList<>();
        ArrayList<ArrayList<Integer>> area = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                number = (int)Math.floor(Math.random() * 9 + 1);
                while (area.get(0).contains(number)) {
                    number = (int)Math.floor(Math.random() * 9 + 1);
                }
                area.get(i).add(number);
                System.out.println(area.get(i));

            //}
        }
        this.location[0] = area.get(0);
        return location;
    }
    public static void main(String[] args) {
        Location loc = new Location();
        loc.generateLocation();
        for (int i = 0; i < loc.location.length; i++) {

            for (int j = 0; j < loc.location[i].length; j++) {

                int number = loc.location[i][j];
                System.out.print(number);
            }
            System.out.println("\n");
        }
    }
}