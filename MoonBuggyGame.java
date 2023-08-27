import java.util.*;

class MoonBuggyGame {
    Scanner scanner = new Scanner(System.in);

    boolean gameOver;
    int distance;
    int energy;
    int gridSize = 10;
    Vehicle[] players = new Vehicle[2];
    List<Enemy> enemies = new ArrayList<>();
    MoonSurface moonSurface;

    void playGame() {
        System.out.println("Welcome to Moon Buggy Multiplayer");
        System.out.println("Choose a game mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        int gameMode = scanner.nextInt();

        if (gameMode == 1) {
            initializePlayers(2);
             } else if (gameMode == 2) {
            initializePlayers(1);
            players[1] = new ComputerPlayer();
            } else {
            System.out.println("Invalid game mode selection. Exiting the game.");
            return;
           }

        energy = 50; 

        initializeEnemies();

        moonSurface = new MoonSurface(gridSize);

        while (!gameOver) {
            for (Vehicle player : players) {
                playTurn(player);
                if (gameOver) {
                    break;
                }
            }
        }

        System.out.println("Game Over. Thanks for playing!");
    }

    void initializePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players[i] = new Vehicle(playerName);
        }
    }

    void playTurn(Vehicle player) {
        displayGameState(player);
        moonSurface.display(player.getPositionX(), player.getPositionY(), getEnemyPositions());

        System.out.print(player.getName() + ", enter 'F' to move forward, 'B' to move backward, 'U' to move up, 'D' to move down, 'E' to make enemies escape, 'Q' to quit: ");
        String input = scanner.next();
        switch (input.toUpperCase()) {
            case "F":
                movePlayer(player, 1, 0);
                break;
            case "B":
                movePlayer(player, -1, 0);
                break;
            case "U":
                movePlayer(player, 0, -1);
                break;
            case "D":
                movePlayer(player, 0, 1);
                break;
            case "E":
                escapeEnemies();
                break;
            case "Q":
                gameOver = true;
                break;
            default:
                System.out.println("Invalid input.");
        }
                energy--;

        updateGame(player);
        enemyAttack(player);
        checkCollision(player);
    }

    void initializeEnemies() {
        Random random = new Random();
        int numEnemies = random.nextInt(3) + 2;

        for (int i = 0; i < numEnemies; i++) {
            int enemyPositionX = random.nextInt(gridSize);
            int enemyPositionY = random.nextInt(gridSize);
            enemies.add(new Enemy(enemyPositionX, enemyPositionY));
        }
    }

    int[] getEnemyPositions() {
        int[] enemyPositions = new int[enemies.size() * 2];
        for (int i = 0; i < enemies.size(); i++) {
            enemyPositions[i * 2] = enemies.get(i).getPositionX();
            enemyPositions[i * 2 + 1] = enemies.get(i).getPositionY();
        }
        return enemyPositions;
    }

    void movePlayer(Vehicle player, int directionX, int directionY) {
        int newPositionX = player.getPositionX() + directionX;
        int newPositionY = player.getPositionY() + directionY;
        if (newPositionX >= 0 && newPositionX < gridSize && newPositionY >= 0 && newPositionY < gridSize) {
            player.setPosition(newPositionX, newPositionY);
            distance++;
        } else {
            System.out.println("Can't move there.");
        }
    }

    void updateGame(Vehicle player) {
        if (distance >= gridSize) {
            if (energy > 0) {
                System.out.println("Congratulations! " + player.getName() + " wins!");
            } else {
                System.out.println(player.getName() + " has reached the goal, but they are out of energy.");
            }
            gameOver = true;
        }
        if (energy <= 0) {
            System.out.println(player.getName() + " is out of energy.");
            gameOver = true;
        }
    }

    void escapeEnemies() {
        for (Enemy enemy : enemies) {
            enemy.escape();
        }
        System.out.println("Enemies have escaped!");
    }

    void enemyAttack(Vehicle player) {
        for (Enemy enemy : enemies) {
            enemy.attack(player);
        }
    }

    void checkCollision(Vehicle player) {
        for (Enemy enemy : enemies) {
            if (enemy.getPositionX() == player.getPositionX() && enemy.getPositionY() == player.getPositionY()) {
                System.out.println("Collision! " + enemy.getName() + " attacked " + player.getName() + "!");
                energy -= 10;
                moonSurface.markCollision(player.getPositionX(), player.getPositionY());
            }
        }
    }

    void displayGameState(Vehicle player) {
        System.out.println("Distance: " + distance);
        System.out.println("Energy: " + energy);
        System.out.println(player.getName() + " position: (" + player.getPositionX() + ", " + player.getPositionY() + ")");
    }

    void displayWinners() {
        for (Vehicle player : players) {
            if (player.getPositionX() >= gridSize) {
                if (energy > 0) {
                    System.out.println("Congratulations! " + player.getName() + " wins!");
                } else {
                    System.out.println(player.getName() + " has reached the goal, but they are out of energy.");
                }
            }
        }
    } 
    
}