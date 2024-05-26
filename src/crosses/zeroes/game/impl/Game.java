package crosses.zeroes.game.impl;

import crosses.zeroes.game.Player;
import crosses.zeroes.game.PlayerManager;
import crosses.zeroes.game.Playground;

public class Game {
	private static final String WELCOME_TO_GAME = "Welcome to Game!";
	private static final String MAKE_DECISION = "Player %s, make your decision (row and column, 1-3):";
	private static final String INVALID_DECISION = "Decision is not valid, please try again";
	private static final String PLAYER_WINS = "Player %s wins!";

	private final Playground playground;
	private final PlayerManager playerManager;

	public Game(PlayerManager playerManager, Playground playground) {
		this.playerManager = playerManager;
		this.playground = playground;
	}

	public void play() {
		System.out.println(WELCOME_TO_GAME);
		playground.display();
		while (true) {
			Player currentPlayer = playerManager.getCurrentPlayer();
			System.out.printf(MAKE_DECISION, currentPlayer);
			Decision decision = currentPlayer.makeDecision();

			boolean isValidDecision = playground.setItemInGap(decision.row(), decision.column(), currentPlayer.getSymbol());
			if (isValidDecision && this.isOver(decision)) {
				break;
			}

			if (!isValidDecision) {
				System.out.println(INVALID_DECISION);
			} else {
				playerManager.changePlayer();
				playground.display();
			}
		}
		System.out.printf(PLAYER_WINS, playerManager.getCurrentPlayer());
	}

	private boolean isOver(Decision decision) {
		int lastRow = decision.row();
		int lastColumn = decision.column();
		return playground.rowItemsSame(lastRow)
				|| playground.columnItemsSame(lastColumn)
				|| playground.diagonalItemsSame()
				|| playground.antiDiagonalItemsSame();
	}
}
