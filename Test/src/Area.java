import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Area {
    public int areaCurrentLevel = 1;
    public static List<int[][]> tiles;

    public Area() {
        tiles = new ArrayList<>();
        generateTiles();
    }

    public static void generateTiles() {
        int[][] firstTiles =
                {
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 1, 1, 1, 0, 0, 0, 1, 0}};

        tiles.add(firstTiles);

        int[][] secondTiles =
                {
                        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                        {0, 0, 1, 1, 1, 0, 0, 0, 1, 0}};

        tiles.add(secondTiles);
    }

    public static void generateNextRandomTiles() {
        int[][] nextTiles = new int[10][10];

        int number = (int)Math.floor(Math.random() * 100 + 1);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (number <= 30) {
                    nextTiles[i][j] = 0;
                } else {
                    nextTiles[i][j] = 1;
                }
            }
        }
        nextTiles[0][0] = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (nextTiles[i][j] == 0 && (nextTiles[i + 1][j] == 0 || nextTiles[i][j + 1] == 0)) {
                } else {
                    switch ((int) Math.floor(Math.random() + 0.5)) {
                        case 0 -> nextTiles[i + 1][j] = 0;
                        case 1 -> nextTiles[i][j + 1] = 0;
                    }
                }
            }
        }
/*
        for (int i = 9; i > 0; i--) {
            for (int j = 0; j < 9; j++) {
                if (nextTiles[i][j] == 0 && (nextTiles[i - 1][j] == 0 || nextTiles[i][j + 1] == 0)) {
                } else {
                    switch ((int) Math.floor(Math.random() + 0.5)) {
                        case 0 -> nextTiles[i - 1][j] = 0;
                        case 1 -> nextTiles[i][j + 1] = 0;
                    }
                }
            }
        }
*/
        tiles.add(nextTiles);
    }
    public static void main(String[] args) {
        Area area = new Area();
        //generateTiles();
        generateNextRandomTiles();
        System.out.println(tiles.size());
        List<Integer> list = new ArrayList();
        for (int i = 0; i < tiles.get(2).length; i++) {
            for (int j = 0; j < tiles.get(2).length; j++) {
                list.add(tiles.get(2)[i][j]);
            }
            System.out.println(list);
            list.clear();
        }
    }
}