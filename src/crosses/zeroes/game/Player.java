package crosses.zeroes.game;

import crosses.zeroes.game.impl.Decision;
import crosses.zeroes.game.impl.Symbol;

public interface Player {
    Decision makeDecision();

    Symbol getSymbol();
}
