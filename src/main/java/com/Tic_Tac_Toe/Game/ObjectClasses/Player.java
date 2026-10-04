package com.Tic_Tac_Toe.Game.ObjectClasses;

public class Player {

    public char getUnit() {
        return unit;
    }

    private char unit;

    public Player() {
        this.unit = 'X';
    }

    public Player(char unit) {
        this.unit = unit;
    }
}
