package crosses.zeroes.game.impl;

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
		System.out.println("Welcome to Game!");
		playground.display();
		while (true) {
			Player currentPlayer = playerManager.getCurrentPlayer();
			System.out.println("Player " + currentPlayer + ", make your decision (row and column, 1-3):");
			Decision decision = currentPlayer.makeDecision();

			boolean isValidDecision = playground.setItemInGap(decision.row(), decision.column(), currentPlayer.getSymbol());
			if (isValidDecision && this.isOver(decision)) {
				break;
			}

			if (!isValidDecision) {
				System.out.println("Decision is not valid, please try again");
			} else {
				playerManager.changePlayer();
				playground.display();
			}
		}
		System.out.println("Player " + playerManager.getCurrentPlayer() + " wins!");
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
