import java.io.PrintStream;
import java.util.Scanner;

public class HangmanGame {

    private final PrintStream printStream;
    Scanner scanner;
    private final PrintReporter printReporter;
    private final DecisionMaker decisionMaker;
    private GameState gameState;


    public HangmanGame(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
        printReporter = new PrintReporter(printStream);
        decisionMaker = new DecisionMaker(printReporter, printStream);
        gameState = new GameState(9, 0, 0, "hello");
        printStream.println("stop");
    }

    public void play() {
        printStream.println("Let's play hangman");

        printReporter.printUnderscores(gameState.getWordAsList());

        while (gameState.getWrongGuesses() < gameState.getTotalWrongGuessesAllowed()) {
            String guess = getGuess();
            decisionMaker.letterOrWord(guess, gameState);
            decisionMaker.checkLetterOrWord(guess, gameState);
            if (decisionMaker.wordGuessCorrect(guess, gameState)){
                printStream.println("Congratulations, you won!");
                break;
            } else if (gameState.getWrongGuesses() == gameState.getTotalWrongGuessesAllowed()) {
                printStream.println("I'm sorry, but you lost");
                printStream.println("My word was: " + gameState.word);
                break;
            }
        }

    }

    String getGuess() {
        printStream.println("What is your guess?");
        String guess = scanner.nextLine();
        while (decisionMaker.checkRepeatedGuess(guess)) {
            printStream.println("You have already guessed " + guess);
            printStream.println("Please enter a new guess");
            guess = scanner.nextLine();
        }
        return guess;
    }




}
