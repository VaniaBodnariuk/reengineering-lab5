package crosses.zeroes.game.impl;

public enum Symbol {
    CROSS('X'), ZERO('0'), GAP('_');

    public char getValue() {
        return value;
    }

    private final char value;

    Symbol(char value) {
        this.value = value;
    }
}
