package crosses.zeroes.game.impl;

import crosses.zeroes.game.PlayerManager;

import java.util.Scanner;

public class PeerPlayerManager implements PlayerManager {

    private UserPlayer currentPlayer;
    private UserPlayer nextPlayer;

    public PeerPlayerManager(Scanner scanner) {
        currentPlayer = new UserPlayer(Symbol.CROSS, scanner);
        nextPlayer = new UserPlayer(Symbol.ZERO, scanner);
    }

    public void changePlayer() {
        UserPlayer temp = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = temp;
    }

    public UserPlayer getCurrentPlayer() {
        return currentPlayer;
    }
}
