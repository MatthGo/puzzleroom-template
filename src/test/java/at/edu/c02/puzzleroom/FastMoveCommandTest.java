package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandFastmove;
import at.edu.c02.puzzleroom.commands.CommandLoad;
import at.edu.c02.puzzleroom.commands.CommandMove;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidArgumentsException;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidMoveException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FastMoveCommandTest {
    @Test
    public void testFastMoveSuccessful() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/test/resources/startField.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Initial player position should be (2, 1)
        assertEquals(2, player.getRow());
        assertEquals(1, player.getCol());

        // Execute fastmove command: up, down, left, right
        CommandFastmove fastMove = new CommandFastmove(new String[]{"u", "d", "r", "l"});
        fastMove.execute(gameBoard);

        // After executing fastmove, player should be back to the initial position
        assertEquals(2, player.getRow());
        assertEquals(1, player.getCol());

        // Ensure step count increased correctly (4 steps total)
        assertEquals(4, player.getStepCount());

        // Ensure game is not finished
        assertFalse(gameBoard.isFinished());
    }

    @Test
    public void testFastMoveInvalidMove() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/test/resources/startField.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Initial player position should be (2, 1)
        assertEquals(2, player.getRow());
        assertEquals(1, player.getCol());

        // Execute fastmove command with an invalid move (e.g., left into a wall)
        CommandFastmove fastMove = new CommandFastmove(new String[]{"l", "d"});

        // Expect a PuzzleRoomInvalidMoveException to be thrown
        Exception exception = assertThrows(PuzzleRoomInvalidMoveException.class, () -> {
            fastMove.execute(gameBoard);
        });

        // Ensure player's position has not changed
        assertEquals(2, player.getRow());
        assertEquals(1, player.getCol());

        // Ensure step count remains 0
        assertEquals(0, player.getStepCount());
    }
}
