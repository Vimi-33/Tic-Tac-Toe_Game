package com.Tic_Tac_Toe.Game.ObjectClasses;

public class Board {

    private Player[][] board;

    public Player[][] getBoard() {
        return board;
    }

    public Board() {
        this.board = new Player[3][3];
    }

    public boolean setCell(int x, int y, Player player){
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return false;
        }
        if(board[x][y] == null) {
            board[x][y] = player;
            return true;
        }
        return false;
    }

    public boolean checkWin(Player player){
        char letter = player.getUnit();

        // Check Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].getUnit() == letter &&
                    board[i][1] != null && board[i][1].getUnit() == letter &&
                    board[i][2] != null && board[i][2].getUnit() == letter) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != null && board[0][j].getUnit() == letter &&
                    board[1][j] != null && board[1][j].getUnit() == letter &&
                    board[2][j] != null && board[2][j].getUnit() == letter) {
                return true;
            }
        }

        // Check Diagonals
        if (board[0][0] != null && board[0][0].getUnit() == letter &&
                board[1][1] != null && board[1][1].getUnit() == letter &&
                board[2][2] != null && board[2][2].getUnit() == letter) {
            return true;
        }

        if (board[0][2] != null && board[0][2].getUnit() == letter &&
                board[1][1] != null && board[1][1].getUnit() == letter &&
                board[2][0] != null && board[2][0].getUnit() == letter) {
            return true;
        }

        return false;
    }
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        this.board = new Player[3][3];
    }


    public void displayBoard(){
        for (int i = 0 ; i< board.length;i++){
            for (int j = 0 ; j< board.length;j++){

                if(this.board[i][j]==null){
                    System.out.print("- ");
                }else {
                    System.out.print(board[i][j].getUnit()+" ");
                }
            }
            System.out.println();
        }
    }


}
