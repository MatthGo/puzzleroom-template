//package at.edu.c02.puzzleroom;
//
//import at.edu.c02.puzzleroom.commands.CommandLoad;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//
//public class FastMoveCommandTest {import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//        @Test
//        public void testFastMoveSuccessful() throws Exception {
//            GameBoard gameBoard = new GameBoardImpl();
//            new CommandLoad(new String[]{"src/test/resources/startField.maze"}).execute(gameBoard);
//            Player player = gameBoard.getPlayer();
//
//            // Initial player position should be (2, 1)
//            assertEquals(2, player.getRow());
//            assertEquals(1, player.getCol());
//
//            // Execute fastmove command: up, down, left, right
//            CommandFastMove fastMove = new CommandFastMove(new String[]{"u", "d", "l", "r"});
//            fastMove.execute(gameBoard);
//
//            // After executing fastmove, player should be back to the initial position
//            assertEquals(2, player.getRow());
//            assertEquals(1, player.getCol());
//
//            // Ensure step count increased correctly (4 steps total)
//            assertEquals(4, player.getStepCount());
//
//            // Ensure game is not finished
//            assertFalse(gameBoard.isFinished());
//        }
//
//        @Test
//        public void testFastMoveInvalidMove() throws Exception {
//            GameBoard gameBoard = new GameBoardImpl();
//            new CommandLoad(new String[]{"src/test/resources/startField.maze"}).execute(gameBoard);
//            Player player = gameBoard.getPlayer();
//
//            // Initial player position should be (2, 1)
//            assertEquals(2, player.getRow());
//            assertEquals(1, player.getCol());
//
//            // Execute fastmove command with an invalid move (e.g., left into a wall)
//            CommandFastMove fastMove = new CommandFastMove(new String[]{"l", "d"});
//
//            // Expect a PuzzleRoomInvalidMoveException to be thrown
//            Exception exception = assertThrows(PuzzleRoomInvalidMoveException.class, () -> {
//                fastMove.execute(gameBoard);
//            });
//
//            // Ensure player's position has not changed
//            assertEquals(2, player.getRow());
//            assertEquals(1, player.getCol());
//
//            // Ensure step count remains 0
//            assertEquals(0, player.getStepCount());
//        }
//    }
//}
