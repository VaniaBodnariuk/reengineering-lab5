package crosses.zeroes;

import crosses.zeroes.game.impl.Game;
import crosses.zeroes.game.impl.PeerPlayerManager;
import crosses.zeroes.game.impl.SimplePlayground;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new Game(new PeerPlayerManager(scanner), new SimplePlayground())
                    .play();
        }
    }
}
