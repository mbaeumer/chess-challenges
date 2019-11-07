package se.mbaeumer.chesschallenges;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        /*
        if (x < 0 || y < 0 || x > 7 || y > 7){
            throw new IllegalArgumentException();
        }
        */
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
