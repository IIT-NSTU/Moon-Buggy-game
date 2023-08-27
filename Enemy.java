class Enemy {
    int positionX;
    int positionY;

    Enemy(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    int getPositionX() {
        return positionX;
    }

    int getPositionY() {
        return positionY;
    }

    void escape() {
        positionX = -1;
        positionY = -1;
    }

    void attack(Vehicle player) {
        int playerX = player.getPositionX();
        int playerY = player.getPositionY();

        if (Math.abs(playerX - positionX) <= 1 && Math.abs(playerY - positionY) <= 1) {
            System.out.println("Collision! " + getName() + " attacked " + player.getName() + "!");
        }
    }

    String getName() {
        return "Enemy";
    }
}