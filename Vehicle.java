
class Vehicle {
    String name;
    int posX;
    int posY;
    boolean is_eliminated;
    public boolean is_enemy;

    Vehicle(String name) {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
        this.is_eliminated = false;
        this.is_enemy = is_enemy;
    }

    String getName() {
        return name;
    }

    int get_posX() {
        return posX;
    }

    int get_posY() {
        return posY;
    }

    void set_pos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    boolean is_eliminated() {
        return is_eliminated;
    }


    public void eliminate() {
        is_eliminated = true;
    }

    public int getEnergy() {
        return 0;
    }

}



