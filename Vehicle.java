class Vehicle {
    String name;
    int positionX;
    int positionY;

    Vehicle(String name) {
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
    }

    String getName() {
        return name;
    }

    int getPositionX() {
        return positionX;
    }

    int getPositionY() {
        return positionY;
    }

    void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}