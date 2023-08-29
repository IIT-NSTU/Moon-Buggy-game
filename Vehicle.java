class Vehicle {
    String name;
    int posX;
    int posY;
    boolean isEliminated;

    Vehicle(String name) {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
        this.isEliminated = false; // Initialize to false
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

    boolean isEliminated() {
        return isEliminated;
    }

    void eliminate() {
        isEliminated = true;
    }
}



