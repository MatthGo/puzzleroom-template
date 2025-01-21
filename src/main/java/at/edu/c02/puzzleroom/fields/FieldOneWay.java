package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

public class FieldOneWay extends BaseField {

	private final Direction allowedDirection;

	public FieldOneWay(GameBoard gameBoard, char name, int row, int col, Direction allowedDirection) {
		super(gameBoard, name, row, col);
		this.allowedDirection = allowedDirection;
	}

	@Override
	public boolean leaveField(Direction direction) {
		// only move if have the right direction

		return direction == allowedDirection;
	}

	@Override
	public void initialize() {}

	@Override
	public boolean enterField(Direction direction) {
		gameBoard.getPlayer().walkStep();
		setPlayerPositionToField();
		return true;}
}
