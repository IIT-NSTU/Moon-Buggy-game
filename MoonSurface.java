import java.util.Arrays;

class MoonSurface {
    int gridSize;
    char[][] grid;

    MoonSurface(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            Arrays.fill(grid[i], ' ');
        }
    }

    void display(int playerPositionX, int playerPositionY, int[] enemyPositions) {
        updateGrid(playerPositionX, playerPositionY, enemyPositions);

        System.out.println("Moon Surface:");

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                System.out.print("[" + grid[row][col] + "]");
            }
            System.out.println();
        }
    }

    void updateGrid(int playerPositionX, int playerPositionY, int[] enemyPositions) {
        for (int row = 0; row < gridSize; row++) {
            Arrays.fill(grid[row], ' ');
        }

        grid[playerPositionY][playerPositionX] = 'P';

        for (int i = 0; i < enemyPositions.length; i += 2) {
            int enemyX = enemyPositions[i];
            int enemyY = enemyPositions[i + 1];
            grid[enemyY][enemyX] = 'E';
        }
    }

    void markCollision(int x, int y) {
        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
            grid[y][x] = 'X';
        }
    }
}