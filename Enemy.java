class Enemy extends Vehicle {
    Enemy(int posX, int posY) {
        super("Enemy");
        this.posX = posX;
        this.posY = posY;
    }

    int get_posX() {
        return posX;
    }



    void escape() {
        posX = -1;
        posY = -1;
    }

    String getName() {
        return "Enemy";
    }

    boolean attack(Vehicle player) {
        int playerX = player.get_posX();
        int playerY = player.get_posY();

        if (Math.abs(playerX - posX) <= 1 && Math.abs(playerY - posY) <= 1) {
            System.out.println("Collision! " + getName() + " attacked " + player.getName() + "!");
            player.eliminate(); // Apply the attack effect on the player
            return true;
        }
        return false;
    }


}
