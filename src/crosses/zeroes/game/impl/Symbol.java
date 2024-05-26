package crosses.zeroes.game.impl;

public enum Symbol {
    CROSS('X'), ZERO('0'), GAP('_');

    private final char value;

    Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
