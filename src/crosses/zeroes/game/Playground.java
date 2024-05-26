package crosses.zeroes.game;

import crosses.zeroes.game.impl.Symbol;

public interface Playground {
    boolean setItemInGap(int row, int column, Symbol symbol);

    boolean rowItemsSame(int row);

    boolean columnItemsSame(int col);

    boolean diagonalItemsSame();

    boolean antiDiagonalItemsSame();

    void display();
}
