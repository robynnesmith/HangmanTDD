import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DecisionMaker {


    private PrintReporter printReporter;
    private PrintStream printStream;
    private String letterOrWord = "";
    private List<String> previousGuesses;

    public DecisionMaker(PrintReporter printReporter, PrintStream printStream) {
        this.printReporter = printReporter;
        this.printStream = printStream;
        previousGuesses  = new ArrayList<String>();
    }

    String letterOrWord(String guess, GameState gameState) {
        char charGuess = 0;
        boolean guessAcceptable = false;
        while (!guessAcceptable) {
            if (guess.toCharArray().length == 1) {
                charGuess = guess.charAt(0);
                letterOrWord = "letter";
                guessAcceptable = true;
            } else if (guess.toCharArray().length > 1){
                letterOrWord = "word";
                guessAcceptable = true;
            } else {
                printStream.println("Please enter a letter then press enter");
            }
        }

        if (guess.toCharArray().length == 1){
            return Character.toString(charGuess);
        } else if (guess.toCharArray().length > 1){
            return guess;
        }
        return "";
    }

    void checkLetterOrWord(String guess, GameState gameState) {
        if (letterOrWord.equals("letter")){
            letterRightOrWrong(guess, gameState);
        } else {
            wordRightOrWrong(guess, gameState);
        }
    }

    void letterRightOrWrong(String guess, GameState gameState) {
        if (letterGuessCorrect(guess, gameState)) {
            gameState.incrementCorrectGuesses();
            printStream.println("Your guess of: " + guess + " was correct");
            printReporter.printWordAsGuessed(WordUtils.wordAsGuessed);
        } else {
            gameState.incrementWrongGuesses();
            printReporter.printGallows(gameState);
            printStream.println("You have made " + gameState.getWrongGuesses() + " incorrect guesses");
        }
    }

    void wordRightOrWrong(String guess, GameState gameState) {
        if (wordGuessCorrect(guess, gameState)) {
            gameState.incrementCorrectGuesses();
            printStream.println("Your guess of: " + guess + " was correct");
        } else {
            gameState.incrementWrongGuesses();
            printReporter.printGallows(gameState);
            printStream.println("You have made " + gameState.getWrongGuesses() + " incorrect guesses");
        }
    }

    boolean letterGuessCorrect(String guess, GameState gameState) {
        boolean found = false;
        for (int i=0; i < gameState.getWordAsList().size(); i++){
            if (gameState.getWordAsList().get(i).equals(guess)) {
                WordUtils.buildWordAsGuessed(WordUtils.listOfUnderscores, i, guess); //TODO find index of matching letter
                found = true;
            }
        }
        return found;
    }

    public boolean wordGuessCorrect(String guess, GameState gameState) {
        if (gameState.wordAsList.equals(WordUtils.wordAsGuessed)) {
            return true;
        } else if (guess.equals(gameState.word)) {
            return true;
        }
        return false;
    }

    public boolean checkRepeatedGuess(String guess) {
        if (previousGuesses.contains(guess)){
            return true;
        }
        previousGuesses.add(guess);
        return false;
    }
}
