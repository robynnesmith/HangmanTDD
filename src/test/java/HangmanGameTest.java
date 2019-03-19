import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class HangmanGameTest {


    private final Scanner scanner = new Scanner("");
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(byteArrayOutputStream);
    private final HangmanGame hangmanGame = new HangmanGame(scanner, printStream);
    private final PrintReporter printReporter = new PrintReporter(printStream);
    private DecisionMaker decisionMaker = new DecisionMaker(printReporter, printStream);
    private final GameState gameState = new GameState(6, 0, 1, "hello");

    @Test
    void play() {
    }

    @Test
    void printGallows() {
        printReporter.printGallows(gameState);
        assertEquals(GallowSegments.valueOf("SEGMENT_1").output, 1);
    }

//    Not really a necessary test - testing a method call rather than an observable outcome
//    @Test
//    void incorrectGuess() {
//        HangmanGame hangmanGame = mock(HangmanGame.class);
//
//        doReturn("r").when(hangmanGame).getGuess();
//        doCallRealMethod().when(hangmanGame).play();
//
//        hangmanGame.play();
//        verify(hangmanGame).markWrongGuess();
//    }

    @Test
    void checkIfGuessCorrect() {
        char guess = 'h';
        assertTrue(decisionMaker.guessCorrect(guess, gameState));
    }

    @Test
    void checkIfNoGuess() {

        assertEquals(hangmanGame.getGuess(), '\n');
    }

    @Test
    void composeListOfUnderscores() {
//        assertEquals(hangmanGame.charArray.length, hangmanGame.createListOfUnderscores().size());
    }

    @Test
    void printInitialWord() {
//        hangmanGame.printBlankTemplate();
        assertTrue(byteArrayOutputStream.toString().contains("[_ _ _ _ _]"));

    }
}