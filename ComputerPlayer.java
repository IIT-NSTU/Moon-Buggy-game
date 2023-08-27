import java.util.Random;

class ComputerPlayer extends Vehicle {
    ComputerPlayer() {
        super("Computer");
    }

    @Override
    int getPositionX() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return super.getPositionX() + move;
    }

    @Override
    int getPositionY() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return super.getPositionY() + move;
    }
}

