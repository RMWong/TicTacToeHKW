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



    public Board() {
        board = new ArrayList();
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
        return  (getLocationStatus(0) == getLocationStatus(1) && getLocationStatus(0) == getLocationStatus(2)) || //horizontal
                (getLocationStatus(3) == getLocationStatus(4) && getLocationStatus(3) == getLocationStatus(5)) ||
                (getLocationStatus(6) == getLocationStatus(7) && getLocationStatus(6) == getLocationStatus(8)) ||

                (getLocationStatus(0) == getLocationStatus(3) && getLocationStatus(0) == getLocationStatus(6)) || //vertical
                (getLocationStatus(1) == getLocationStatus(4) && getLocationStatus(1) == getLocationStatus(7)) ||
                (getLocationStatus(2) == getLocationStatus(5) && getLocationStatus(2) == getLocationStatus(8)) ||

                (getLocationStatus(0) == getLocationStatus(4) && getLocationStatus(0) == getLocationStatus(8)) || //diagonal
                (getLocationStatus(2) == getLocationStatus(4) && getLocationStatus(2) == getLocationStatus(6));
        }


    public int getLocationStatus(int location) {
        return board.get(location);
    }



}
