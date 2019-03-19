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
        gameState = new GameState(6, 0, 0, "hello");
        printStream.println("stop");
    }

    public void play() {
        printStream.println("Let's play hangman");

        printReporter.printUnderscores(gameState.getWordAsList());

        while (gameState.getWrongGuesses() < gameState.getTotalWrongGuessesAllowed()) {
            decisionMaker.rightOrWrong(getGuess(), gameState);
            if (decisionMaker.isWordComplete(gameState)){
                printStream.println("Congratulations, you won!");
                break;
            } else if (gameState.getWrongGuesses() == gameState.getTotalWrongGuessesAllowed()) {
                printStream.println("You lost");
                break;
            }
        }

    }

    char getGuess() {
        printStream.println("What is your guess?");
        char charGuess = 0;
        while (charGuess == 0) {
            String guess = scanner.nextLine();
            if (!guess.equals("")) {
                charGuess = guess.charAt(0);
            } else {
                System.out.println("Please enter a letter then press enter");
            }
        }
        return charGuess;
    }




}
