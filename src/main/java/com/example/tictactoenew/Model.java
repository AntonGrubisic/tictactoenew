package com.example.tictactoenew;

public class Model {
    private final char[][] board;
    private char currentPlayer;
    private int playerScore;
    private int computerScore;

    public Model() {
        board = new char[3][3];
        resetBoard();
        currentPlayer = 'X'; // Människans symbol
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (board[row][col] == '-') {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public char checkWinner() {
        // Horisontellt, vertikalt och diagonalt
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        }

        // Kontrollera om det är oavgjort
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isDraw = false;
                    break;
                }
            }
        }
        if (isDraw) {
            return 'D'; // Oavgjort
        }

        return '-'; // Ingen vinnare än
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void updateScore(char winner) {
        if (winner == 'X') {
            playerScore++;
        } else if (winner == 'O') {
            computerScore++;
        }
    }
    public void resetScores() {
        playerScore = 0;
        computerScore = 0;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }


}
