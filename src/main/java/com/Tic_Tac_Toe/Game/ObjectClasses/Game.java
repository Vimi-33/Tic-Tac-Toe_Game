package com.Tic_Tac_Toe.Game.ObjectClasses;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Game {
    private Board gameBoard;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean gameOver;
    private Player winner;

    public Game() {
        this.gameBoard = new Board();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.currentPlayer = playerX;
        this.gameOver = false;
        this.winner = null;
    }

    public void makeMove(int x , int y ){
        boolean moveSuccessful = gameBoard.setCell(x, y, currentPlayer);

        if (gameOver) {
            return;
        }

        if (moveSuccessful) {
            if (gameBoard.checkWin(currentPlayer)) {
                this.winner = currentPlayer;
                this.gameOver = true;
            } else if (gameBoard.isFull()) {
                this.gameOver = true;
                this.winner = null;
            } else {
                if (currentPlayer == playerX) {
                    currentPlayer = playerO;
                } else {
                    currentPlayer = playerX;
                }
            }
        }


    }

    public void reset() {
        this.gameBoard.resetBoard();
        this.currentPlayer = playerO;
        this.gameOver = false;
        this.winner = null;
    }

    public void displayBoard() {
        this.gameBoard.displayBoard();
    }

    public Board getBoard() {
        return gameBoard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getWinner() {
        return winner;
    }

}
