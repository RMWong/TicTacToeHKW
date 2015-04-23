package com.ryan.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2/18/2015.
 */
public class Board {

    private static int BOARD_SIZE = 9;
    private ArrayList<Integer> board;
    private static int EMPTY = 0;
    private static int PLAYER_1 = 1;
    private static int PLAYER_2 = 2;
    private boolean winState = false;
    private int currentPlayer;

    protected int turnCounter;

    public Board() {
        board = new ArrayList<>();
        turnCounter = 1;
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(EMPTY);
        }
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.set(i, EMPTY);
        }
    }

    public void setMove(int player, int location) {
        board.set(location, player);
    }

    public boolean checkTie() {
        return (!board.contains(EMPTY) && !checkWin());
    }

    //8 permutations
    public boolean checkWin() {

        return
                //Player 1 Win states
                (getLocationStatus(0) == getLocationStatus(1) && getLocationStatus(0) == getLocationStatus(2) && getLocationStatus(0) == 1) || //horizontal
                (getLocationStatus(3) == getLocationStatus(4) && getLocationStatus(3) == getLocationStatus(5) && getLocationStatus(3) == 1) ||
                (getLocationStatus(6) == getLocationStatus(7) && getLocationStatus(6) == getLocationStatus(8) && getLocationStatus(6) == 1)  ||

                (getLocationStatus(0) == getLocationStatus(3) && getLocationStatus(0) == getLocationStatus(6) && getLocationStatus(0) == 1) || //vertical
                (getLocationStatus(1) == getLocationStatus(4) && getLocationStatus(1) == getLocationStatus(7) && getLocationStatus(1) == 1) ||
                (getLocationStatus(2) == getLocationStatus(5) && getLocationStatus(2) == getLocationStatus(8) && getLocationStatus(2) == 1) ||

                (getLocationStatus(0) == getLocationStatus(4) && getLocationStatus(0) == getLocationStatus(8) && getLocationStatus(4) == 1) || //diagonal
                (getLocationStatus(2) == getLocationStatus(4) && getLocationStatus(2) == getLocationStatus(6) && getLocationStatus(2) == 1) ||

                //Player 2 Win states
                (getLocationStatus(0) == getLocationStatus(1) && getLocationStatus(0) == getLocationStatus(2) && getLocationStatus(0) == 2) || //horizontal
                (getLocationStatus(3) == getLocationStatus(4) && getLocationStatus(3) == getLocationStatus(5) && getLocationStatus(3) == 2) ||
                (getLocationStatus(6) == getLocationStatus(7) && getLocationStatus(6) == getLocationStatus(8) && getLocationStatus(6) == 2)  ||

                (getLocationStatus(0) == getLocationStatus(3) && getLocationStatus(0) == getLocationStatus(6) && getLocationStatus(0) == 2) || //vertical
                (getLocationStatus(1) == getLocationStatus(4) && getLocationStatus(1) == getLocationStatus(7) && getLocationStatus(1) == 2) ||
                (getLocationStatus(2) == getLocationStatus(5) && getLocationStatus(2) == getLocationStatus(8) && getLocationStatus(2) == 2) ||

                (getLocationStatus(0) == getLocationStatus(4) && getLocationStatus(0) == getLocationStatus(8) && getLocationStatus(4) == 2) || //diagonal
                (getLocationStatus(2) == getLocationStatus(4) && getLocationStatus(2) == getLocationStatus(6) && getLocationStatus(2) == 2);

        }

    public int getPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer() {
        if (this.currentPlayer == 1)
            currentPlayer = 2;
        else
            currentPlayer = 1;
    }

    public int getLocationStatus(int location) {
        return board.get(location);
    }
}
