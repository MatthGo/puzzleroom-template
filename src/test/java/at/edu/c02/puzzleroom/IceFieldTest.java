package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandLoad;
import org.junit.Test;

import static org.junit.Assert.*;

public class IceFieldTest {

    @Test
    public void IceFieldOver() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        // Finish is reached when moving once to the right
        new CommandLoad(new String[]{"src/test/resources/simple_ice.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Player should start at 0 steps
        assertEquals(0, player.getStepCount());

        // Moving right should be possible, since there is a path field
        boolean success = player.moveRight();
        assertTrue(success);

        // Player should now be at 1 step
        assertEquals(1, player.getStepCount());

        //Player is now positioned 3 fields to the right
        assertEquals(1, player.getRow());
        assertEquals(4, player.getCol());
    }

    @Test
    public void wallFieldReached() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        // Wall is reached when moving one time to the right
        new CommandLoad(new String[]{"src/test/resources/advanced_ice.maze"}).execute(gameBoard);
        Player player = gameBoard.getPlayer();

        // Player should start at 0 steps
        assertEquals(0, player.getStepCount());

        // Moving left should not be possible, since there is a wall field
        boolean successLeft = player.moveLeft();
        assertFalse(successLeft);

        // Moving up should not be possible, since there is a wall field
        boolean successUp = player.moveUp();
        assertFalse(successUp);

        // Moving right should be possible, once
        boolean success = player.moveRight();
        assertTrue(success);

        // Player should reach a wall field and move should not be possible
        boolean successRight = player.moveRight();
        assertFalse(successRight);

        // Player should be at 1 step
        assertEquals(1, player.getStepCount());

        //Player is now positioned 4 fields to the right
        assertEquals(1, player.getRow());
        assertEquals(5, player.getCol());
    }
}
