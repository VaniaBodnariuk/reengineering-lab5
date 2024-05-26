package crosses.zeroes.game.impl;

import crosses.zeroes.game.Player;

import java.util.Objects;
import java.util.Scanner;

public class UserPlayer implements Player {
    private final Symbol symbol;
    private final Scanner scanner;

    public UserPlayer(Symbol symbol, Scanner scanner) {
        checkSymbolIsNotGap(symbol);
        this.symbol = symbol;
        this.scanner = scanner;
    }

    private void checkSymbolIsNotGap(Symbol symbol) {
        if (Symbol.GAP.equals(symbol)) {
            throw new IllegalArgumentException("Symbol can not be a gap");
        }
    }

    public Decision makeDecision() {
        return new Decision(scanner.nextInt() - 1, scanner.nextInt() - 1);
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlayer that = (UserPlayer) o;
        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "UserPlayer{" +
                "symbol=" + symbol +
                '}';
    }
}
