package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandLoad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class FieldOneWayTest {

	@Test
	public void testFieldOneWayPositive() throws Exception {
		GameBoard gameBoard = new GameBoardImpl();
		// Load a maze with FieldOneWay for positive tests
		new CommandLoad(new String[]{"src/test/resources/simple_fieldOneWay.maze"}).execute(gameBoard);
		Player player = gameBoard.getPlayer();

		// Initial state validation
		assertEquals("Player should start at 0 steps", 0, player.getStepCount());


		// Moving right on a '^' field
		boolean success = player.moveRight();
		assertTrue("Player should be able to move right on a '^' field", success);
		int stepCount = player.getStepCount();
		assertEquals("Player should now be at 1 step", 1, stepCount);


		// Moving up on a '>' field
		success = player.moveUp();
		assertTrue("Player should be able to move up on a '>' field", success);
		assertEquals("Player should now be at 2 steps", 2, player.getStepCount());

	}

	@Test
	public void testFieldOneWayNegative() throws Exception {
		GameBoard gameBoard = new GameBoardImpl();
		// Load a maze with FieldOneWay for negative tests
		new CommandLoad(new String[]{"src/test/resources/simple_fieldOneWay.maze"}).execute(gameBoard);
		Player player = gameBoard.getPlayer();

		// Initial state validation
		assertEquals("Player should start at 0 steps", 0, player.getStepCount());

		// Attempting to move left on a ' ' field
		boolean failure = player.moveLeft();
		assertFalse("Player should not be able to move left on a '#' field", failure);
		assertEquals("Player should now be at 0 step", 0, player.getStepCount());


		// Move right on a ' ' field
		player.moveRight();

		// Attempting to move left on a '^' field
		boolean success = player.moveLeft();
		assertFalse("Player should be able to move left on a '^' field", success);
		assertEquals("Player should still be at 1 steps", 1, player.getStepCount());

		// Move up on a '^' field
		player.moveUp();

		// Attempting to move up on a '>' field
		success = player.moveUp();
		assertFalse("Player should NOT be able to move up on a '>' field", success);
		assertEquals("Player should still be at 0 steps", 2, player.getStepCount());

		// Attempting to move left on a '>' field
		success = player.moveLeft();
		assertFalse("Player should NOT be able to move left on a '>' field", success);
		assertEquals("Player should still be at 0 steps", 2, player.getStepCount());

		// Attempting to move down on a '>' field
		success = player.moveDown();
		assertFalse("Player should NOT be able to move down on a '>' field", success);
		assertEquals("Player should still be at 0 steps", 2, player.getStepCount());

	}
}
