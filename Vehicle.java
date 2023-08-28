class Vehicle {
    String name;
    int posX;
    int posY;

    Vehicle(String name) {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
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
}
