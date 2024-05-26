package crosses.zeroes.game.impl;

import crosses.zeroes.game.Constants;
import crosses.zeroes.game.Player;
import crosses.zeroes.game.PlayerManager;
import crosses.zeroes.game.Playground;

public class Game {
	private final Playground playground;
	private final PlayerManager playerManager;

	public Game(PlayerManager playerManager, Playground playground) {
		this.playerManager = playerManager;
		this.playground = playground;
	}

	public void play() {
		System.out.println(Constants.WELCOME_TO_GAME);
		playground.display();
		while (true) {
			Player currentPlayer = playerManager.getCurrentPlayer();
			System.out.printf(Constants.MAKE_DECISION, currentPlayer);
			Decision decision = currentPlayer.makeDecision();

			boolean isValidDecision = playground.setItemInGap(decision.row(), decision.column(), currentPlayer.getSymbol());
			if (isValidDecision && this.isOver(decision)) {
				break;
			}

			if (!isValidDecision) {
				System.out.println(Constants.INVALID_DECISION);
			} else {
				playground.display();
				playerManager.changePlayer();
			}
		}
		System.out.printf(Constants.PLAYER_WINS, playerManager.getCurrentPlayer());
	}

	private boolean isOver(Decision decision) {
		int lastRow = decision.row();
		int lastColumn = decision.column();
		return playground.rowItemsSame(lastRow) || playground.columnItemsSame(lastColumn)
				|| playground.diagonalItemsSame() || playground.antiDiagonalItemsSame();
	}
}
