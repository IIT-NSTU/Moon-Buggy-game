class Enemy {
    int posX;
    int posY;

    Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    int get_posX() {
        return posX;
    }

    int get_posY() {
        return posY;
    }

    void escape() {
        posX = -1;
        posY = -1;
    }

    void attack(Vehicle player) {
        int playerX = player.get_posX();
        int playerY = player.get_posY();

        if (Math.abs(playerX - posX) <= 1 && Math.abs(playerY - posY) <= 1) {
            System.out.println("Collision! " + getName() + " attacked " + player.getName() + "!");
        }
    }

    String getName() {
        return "Enemy";
    }
}
