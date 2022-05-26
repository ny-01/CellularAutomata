import java.util.ArrayList;

public class Grid {
    static final int GRID_WIDTH = 30;
    static final int GRID_HEIGHT = 30;
    static final char DEAD_CHARACTER = ' ';
    static final char ALIVE_CHARACTER = '□';
    boolean[][] gridState = new boolean[GRID_WIDTH][GRID_HEIGHT];

    Grid() {
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                gridState[i][j] = false;
            }
        }

        for (int i = 0; i < GRID_WIDTH + 2; i++) {
            System.out.println();
            for (int j = 0; j < GRID_HEIGHT + 2; j++) {
                if (i > 0 && j > 0 && i < (GRID_WIDTH + 1) && j < (GRID_HEIGHT + 1)) {
                    if (!gridState[i - 1][j - 1]) {
                        System.out.print(DEAD_CHARACTER);
                    }
                    else{
                        System.out.print(ALIVE_CHARACTER);
                    }
                }
                else {
                    System.out.print("~");
                }
            }
        }
    }

    Grid(ArrayList<Integer[]> startConfig) {
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                gridState[i][j] = false;
            }
        }

        if (startConfig != null && startConfig.size() != 0) {
            for (Integer[] coordinate : startConfig) {
                gridState[coordinate[0]][coordinate[1]] = true;
            }
        }

        for (int i = 0; i < GRID_WIDTH + 2; i++) {
            System.out.println();
            for (int j = 0; j < GRID_HEIGHT + 2; j++) {
                if (i > 0 && j > 0 && i < (GRID_WIDTH + 1) && j < (GRID_HEIGHT + 1)) {
                    if (!gridState[i - 1][j - 1]) {
                        System.out.print(DEAD_CHARACTER);
                    }
                    else{
                        System.out.print(ALIVE_CHARACTER);
                    }
                }
                else {
                    System.out.print("~");
                }
            }
        }
    }

    public Grid updateGrid() {
        ArrayList<Integer[]> config = new ArrayList<>();
        for (int i = 1; i < (GRID_WIDTH - 1); i++) {
            for (int j = 1; j < (GRID_HEIGHT - 1); j++) {
                // Apply the rules of the game
                int aliveCount = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (gridState[i+x][j+y] && !((x == 0) && (y == 0))) {
                            aliveCount++;
                        }
                    }
                }
                if ((aliveCount == 2 && (gridState[i][j])) || (aliveCount == 3)) {
                    Integer[] array = {i, j};
                    config.add(array);
                }
            }
        }
        Grid newGrid = new Grid(config);
        return newGrid.updateGrid();
    }



    public static void main(String[] args) {
        ArrayList<Integer[]> start = new ArrayList<>();
        Integer[] array = {15, 15};
        Integer[] array1 = {16, 16};
        Integer[] array2 = {17, 15};
        Integer[] array3 = {17, 16};
        Integer[] array4 = {16, 17};
        start.add(array);
        start.add(array1);
        start.add(array2);
        start.add(array3);
        start.add(array4);
        Grid grid = new Grid(start);
        grid.updateGrid();
    }
}
