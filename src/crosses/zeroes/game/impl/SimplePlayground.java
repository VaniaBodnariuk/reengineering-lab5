package crosses.zeroes.game.impl;

import crosses.zeroes.game.Playground;

import java.util.Arrays;

public class SimplePlayground implements Playground {
    private static char[][] board;

    public SimplePlayground() {
        board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, Symbol.GAP.getValue());
        }
    }

    @Override
    public boolean setItemInGap(int row, int column, Symbol symbol) {
        if (indexesOutOfBound(row, column) || board[row][column] != Symbol.GAP.getValue()) {
            return false;
        }
        board[row][column] = symbol.getValue();
        return true;
    }

    private static boolean indexesOutOfBound(int row, int col) {
        return row < 0 || row >= board.length
                || col < 0 || col >= board[row].length;
    }

    @Override
    public boolean rowItemsSame(int row) {
        return board[row][0] == board[row][1] && board[row][0] == board[row][2];
    }

    @Override
    public boolean columnItemsSame(int col) {
        return board[0][col] == board[1][col] && board[0][col] == board[2][col];
    }

    @Override
    public boolean diagonalItemsSame() {
        return board[0][0] == board[1][1] && board[0][0] == board[2][2];
    }

    @Override
    public boolean antiDiagonalItemsSame() {
        return board[0][2] == board[1][1] && board[0][2] == board[2][0];
    }

    @Override
    public void display() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
    }
}
