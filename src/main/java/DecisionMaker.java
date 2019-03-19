import com.sun.xml.internal.bind.v2.TODO;

import java.io.PrintStream;

public class DecisionMaker {


    private PrintReporter printReporter;
    private PrintStream printStream;

    public DecisionMaker(PrintReporter printReporter, PrintStream printStream) {
        this.printReporter = printReporter;
        this.printStream = printStream;
    }

    boolean guessCorrect(char guess, GameState gameState) {
        for (String letter : gameState.getWordAsList()){
            int index = letter.indexOf(letter);
            if (letter.equals(String.valueOf(guess))) {
                WordUtils.buildWordAsGuessed(WordUtils.wordAsGuessed, index, String.valueOf(guess)); //TODO find index of matching letter
                return true;
            }
        }
        return false;
    }

    void rightOrWrong(char guess, GameState gameState) {
        if (guessCorrect(guess, gameState)) {
            gameState.incrementCorrectGuesses();
            printStream.println("Your guess of: " + guess + " was correct");
        } else {
            gameState.incrementWrongGuesses();
            printReporter.printGallows(gameState);
            printStream.println("You have made " + gameState.getWrongGuesses() + " incorrect guesses");
        }
    }

}
