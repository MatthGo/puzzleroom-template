package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

public class FieldIce extends BaseField {

	public FieldIce(GameBoard gameBoard, char name, int row, int col) {
		super(gameBoard, name, row, col);
	}

	@Override
	public boolean enterField(Direction direction) {

		gameBoard.getPlayer().walkStep();

		System.out.println("You stepped on an ice field!");

		// sliding for columbine
		return slideInDirection(direction);
	}

	private boolean slideInDirection(Direction direction) {
		// Calculate the next position based on the direction.
		int newRow = row, newCol = col;
		BaseField nextField = this;
		//loop while next field is a FieldIce
		do {
			switch (direction) {
				case Direction.Up -> newRow -= 1;
				case Direction.Down -> newRow += 1;
				case Direction.Right -> newCol += 1;
				case Direction.Left -> newCol -= 1;
			}

			if (gameBoard.getField(newRow, newCol) instanceof FieldWall)
				break;

			nextField = (BaseField) gameBoard.getField(newRow, newCol);

		} while (nextField instanceof FieldIce);

		gameBoard.getPlayer().setPosition(nextField.row, nextField.col);
		return true;
	}

	@Override
	public void initialize() {
	}

	@Override
	public boolean leaveField(Direction direction) {
		return true;
	}
}
