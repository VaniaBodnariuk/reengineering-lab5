package crosses.zeroes.game.impl;

import crosses.zeroes.game.Player;

import java.util.Scanner;

public class UserPlayer implements Player {

    private final Symbol symbol;

    private final Scanner scanner;

    public UserPlayer(Symbol symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public Decision makeDecision() {
        return new Decision(scanner.nextInt() - 1, scanner.nextInt() - 1);
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }
}
