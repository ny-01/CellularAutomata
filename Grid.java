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
                if (i > 0 && j > 0 && i < 31 && j < 31) {
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

    // set start config
    public void setGridState(boolean[][] gridState) {
        this.gridState = gridState;
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
    }
}
