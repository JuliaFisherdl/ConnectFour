package com.company;

public class Space {
    private char space;
    private int taken;

    public Space() {
        space = '_';
        taken = 0;
    }

    public char getSpace() {
        return space;
    }

    public int getTaken() {
        return taken;
    }

    public void setMove(int play) {
        taken = play;
        if (play == 1)
            space = 'X';
        else
            space = 'O';

    }

}
