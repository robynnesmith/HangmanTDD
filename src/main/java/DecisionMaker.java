import java.io.PrintStream;

public class DecisionMaker {


    private PrintReporter printReporter;
    private PrintStream printStream;

    public DecisionMaker(PrintReporter printReporter, PrintStream printStream) {
        this.printReporter = printReporter;
        this.printStream = printStream;
    }

    boolean guessCorrect(char guess, GameState gameState) {
        boolean found = false;
        for (int i=0; i < gameState.getWordAsList().size(); i++){
            if (gameState.getWordAsList().get(i).equals(String.valueOf(guess))) {
                WordUtils.buildWordAsGuessed(WordUtils.listOfUnderscores, i, String.valueOf(guess)); //TODO find index of matching letter
                found = true;
            }
        }
        return found;
    }

    void rightOrWrong(char guess, GameState gameState) {
        if (guessCorrect(guess, gameState)) {
            gameState.incrementCorrectGuesses();
            printStream.println("Your guess of: " + guess + " was correct");
            printReporter.printWordAsGuessed(WordUtils.wordAsGuessed);
        } else {
            gameState.incrementWrongGuesses();
            printReporter.printGallows(gameState);
            printStream.println("You have made " + gameState.getWrongGuesses() + " incorrect guesses");
        }
    }

    public boolean isWordComplete(GameState gameState) {
        if (gameState.wordAsList.equals(WordUtils.wordAsGuessed)) {
            return true;
        }
        return false;
    }
}
