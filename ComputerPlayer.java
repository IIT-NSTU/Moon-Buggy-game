import java.util.Random;

class ComputerPlayer extends Vehicle {
    ComputerPlayer() {
        super("Computer");
    }

   
    int get_posX() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return super.get_posX() + move;
    }

   
    int get_posY() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return super.get_posY() + move;
    }
}

