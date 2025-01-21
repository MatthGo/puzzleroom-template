package at.edu.c02.puzzleroom.commands;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.*;

/**
 * This command allows the player to move up/down/left/right in multiple steps
 * Example usage: `fastmove u d l r'
 */
public class CommandFastmove implements Command {
	private final String[] _directions;

	public CommandFastmove(String[] arguments) {
		_directions = arguments;
	}

	public void execute(GameBoard gameBoard) throws PuzzleRoomException {


		for (String s : _directions) {
			String[] direction = {s};
			CommandMove cmd = new CommandMove(direction);
			cmd.execute(gameBoard);
		}
	}
}
