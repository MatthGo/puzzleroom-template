package at.edu.c02.puzzleroom.fields;
import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

public class FieldIce extends BaseField {

	public FieldIce(GameBoard gameBoard, char name, int row, int col) {
		super(gameBoard, name, row, col);
	}

	@Override
	public boolean enterField(Direction direction) {
		System.out.println("You stepped on an ice field!");
		// sliding for columbine
		return slideInDirection(direction);
	}

	private boolean slideInDirection(Direction direction) {
		// Calculate the next position based on the direction.
		int newRow = row, newCol = col;
		BaseField nextField;
		//loop while next field is a FieldIce
		do {
			switch (direction) {
				case Direction.Up -> newRow -= 1;
				case Direction.Down -> newRow += 1;
				case Direction.Right -> newCol += 1;
				case Direction.Left -> newCol -= 1;
			}
			nextField = (BaseField) gameBoard.getField(newRow, newCol);
		} while (nextField instanceof FieldIce);

		// check if you can enter the next field.
		if (nextField != null && nextField.enterField(direction)) {
			gameBoard.getPlayer().setPosition(newRow, newCol);
			return true;
		} else {
			System.out.println("You can't slide further!");
			return false;
		}
	}

	@Override
	public void initialize() {
	}

	@Override
	public boolean leaveField(Direction direction) {
		return true;
	}
}
