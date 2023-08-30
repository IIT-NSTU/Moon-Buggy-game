import java.util.Arrays;

class Moon_surface {
    int grid_size;
    char[][] grid;

    Moon_surface(int grid_size) {
        this.grid_size = grid_size;
        this.grid = new char[grid_size][grid_size];
        for (int i = 0; i < grid_size; i++) {
            Arrays.fill(grid[i], ' ');
        }
    }

    void display(int player_posX, int player_posY, int[] enemy_pos) {
        updateGrid(player_posX, player_posY, enemy_pos);

        System.out.println("Moon Surface:");

        for (int row = 0; row < grid_size; row++) {
            for (int col = 0; col < grid_size; col++) {
                System.out.print("[" + grid[row][col] + "]");
            }
            System.out.println();
        }
    }

    void updateGrid(int player_posX, int player_posY, int[] enemy_pos) {
        for (int row = 0; row < grid_size; row++) {
            Arrays.fill(grid[row], ' ');
        }

        grid[player_posY][player_posX] = 'P';

        for (int i = 0; i < enemy_pos.length; i += 2) {
            int enemyX = enemy_pos[i];
            int enemyY = enemy_pos[i + 1];

            if (enemyX != -1 && enemyY != -1) {
                grid[enemyY][enemyX] = 'E';
            }
        }
    }


    void mark_collis(int x, int y) {
        if (x >= 0 && x < grid_size && y >= 0 && y < grid_size) {
            grid[y][x] = 'X';
        }
    }
}
