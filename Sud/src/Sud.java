import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sud {
    public static List<Integer> getNumbersUsingIntStreamRange(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int row = 9, column = row;
        int[][] sud = new int[row][column];
        do{Arrays.stream(sud).forEach(x-> Arrays.fill(x, 0));
            }
        while (fillRowsWithNumbers(sud) > 300);
        printSud(sud);
    }
    public static void printSud(int[][]sud) {
        for (int i = 0; i < sud.length; i++) {
            for (int j = 0; j < sud.length; j++) {
                System.out.print(sud[i][j]);
            }
        }
    }
    public static int fillRowsWithNumbers(int[][] sud) {
        int count = 0;
        for (int i = 0; i < sud.length; i++) {
            int counti = 0;
            do{generateLineOfNumbers(sud, i);
            count++;
            counti++;
                if (count > 300) {
                    System.out.println("Overloaded");
                    break;}}
            while (!validateLineOfNumbers(sud,i));
            System.out.println("Sor: " + i + " - generálások száma: " + counti);
        }
        System.out.println("Összes generálás: " + count);
        return count;
    }
    public static Boolean validateLineOfNumbers(int[][]sud, int row) {
        for (int i = 0; i < sud.length; i++) {
            int number = sud[row][i];
            if(isInBox(sud,row,i,number) > 1 || isInColumn(sud,i,number) > 1) {
                return false;
            }
        }
        return true;
    }
    public static void generateLineOfNumbers(int[][] sud, int row) {
        Random rn = new Random();
        int count = 0;
        int number;
        List<Integer> possibleList = getNumbersUsingIntStreamRange(1,sud.length + 1);
        for (int i = 0; i < sud.length; i++) {
            do{number = possibleList.get(rn.nextInt(possibleList.size()));
                count++;
                if (count > 30) {
                    break;
                }}
            while (isColumnContains(sud,i,number) || isBoxContains(sud,row,i,number));
            sud[row][i] = number;
            possibleList.remove((Integer) number);
        }
    }
    public static Boolean isColumnContains(int[][]sud, int column, int number){
        List<Integer> columnList = new ArrayList<>();
        for (int i = 0; i < sud.length; i++) {
            columnList.add(sud[i][column]);
        }
        return columnList.contains(number);
    }
    public static Boolean isBoxContains(int[][]sud, int row, int column, int number) {
        return generateCurrentBoxList(sud, row, column).contains(number);
    }
    public static long isInColumn(int[][]sud, int column, int number){
        List<Integer> columnList = new ArrayList<>();
        for (int i = 0; i < sud.length; i++) {
            columnList.add(sud[i][column]);
        }
        return columnList.stream().filter(x->x == number).count();
    }
    public static long isInBox(int[][]sud, int row, int column, int number) {
        return generateCurrentBoxList(sud, row, column).stream().filter(x->x == number).count();
    }
    public static int[][][] boxes() {
        return new int[][][]{
                {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}},
                {{0,3},{0,4},{0,5},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5}},
                {{0,6},{0,7},{0,8},{1,6},{1,7},{1,8},{2,6},{2,7},{2,8}},
                {{3,0},{3,1},{3,2},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2}},
                {{3,3},{3,4},{3,5},{4,3},{4,4},{4,5},{5,3},{5,4},{5,5}},
                {{3,6},{3,7},{3,8},{4,6},{4,7},{4,8},{5,6},{5,7},{5,8}},
                {{6,0},{6,1},{6,2},{7,0},{7,1},{7,2},{8,0},{8,1},{8,2}},
                {{6,3},{6,4},{6,5},{7,3},{7,4},{7,5},{8,3},{8,4},{8,5}},
                {{6,6},{6,7},{6,8},{7,6},{7,7},{7,8},{8,6},{8,7},{8,8}}
        };
    }
    public static int boxSelector(int row, int column) {
        String currentPosition = row + "-" + column;
        int currentBox = 0;
        for (int i = 0; i < boxes().length; i++) {
            for (int j = 0; j < boxes()[i].length; j++) {
                String box = boxes()[i][j][0] + "-" + boxes()[i][j][1];
                if (currentPosition.equals(box)) {
                    currentBox = i;
                    break;
                }
            }
        }
        return currentBox;
    }
    public static List<Integer> generateCurrentBoxList(int[][] sud, int row, int column) {
        List<Integer> currentBoxList = new ArrayList<>();
        int[][] template = boxes()[boxSelector(row,column)];
        for (int[] ints : template) {
            currentBoxList.add(sud[ints[0]][ints[1]]);
        }
        return currentBoxList;
    }
}