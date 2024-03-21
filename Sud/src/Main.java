import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static List<Integer> getNumbersUsingIntStreamRange(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int row = 9, column = row;
        int[][] sud = new int[row][column];
        generateNumber(sud, row,column);
        printSud(sud);
    }

    public static void printSud(int[][]sud) {
        for (int i = 0; i < sud.length; i++) {
            for (int j = 0; j < sud.length; j++) {
                System.out.print(sud[i][j]);
            }
        }
    }
    public static void generateNumber(int[][] sud, int row, int column) {
        Random rn = new Random();
        int number;
        for (int i = 0; i < sud.length; i++) {
            List<Integer> possibleList = getNumbersUsingIntStreamRange(1,sud.length + 1);
            //System.out.println(possibleList);
            for (int j = 0; j < sud.length; j++) {
                do{number = possibleList.get(rn.nextInt(possibleList.size()));}
                while (isInRow(sud,i,number) || isInColumn(sud,j,number));

                sud[i][j] = number;
                System.out.print(number + " ");
                possibleList.remove(possibleList.indexOf(number));
                //System.out.println(possibleList);
            }
        }
    }
    public static boolean isInRow(int[][]sud, int row, int number){
        List<Integer> rowList = new ArrayList<>();
        for (int i = 0; i < sud.length; i++) {
            rowList.add(sud[row][i]);
        }
        if (rowList.contains(number)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isInColumn(int[][]sud, int column, int number){
        List<Integer> columnList = new ArrayList<>();
        for (int i = 0; i < sud.length; i++) {
            columnList.add(sud[i][column]);
        }
        if (columnList.contains(number)) {
            return true;
        } else {
            return false;
        }
    }
}