import com.maximeroussy.invitrode.WordGenerator;

import java.util.List;
import java.util.Random;

public class GameState {
    int totalWrongGuessesAllowed;
    int correctGuesses;
    int wrongGuesses;
    String word;
    List<String> wordAsList;


    public GameState(int totalWrongGuessesAllowed, int correctGuesses, int wrongGuesses, String word){
        this.totalWrongGuessesAllowed = totalWrongGuessesAllowed;
        this.correctGuesses = correctGuesses;
        this.wrongGuesses = wrongGuesses;
        this.word = word;
        wordAsList = WordUtils.getWordAsList(word);
    }

    public GameState(){
        new GameState(6, 0, 0, "hello");
    }


    public int getTotalWrongGuessesAllowed() {
        return totalWrongGuessesAllowed;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public String getWord() {
        return word;
    }

    public List<String> getWordAsList() {
        return wordAsList;
    }

    public void incrementCorrectGuesses() {
        correctGuesses += 1;
    }

    public void incrementWrongGuesses() {
        wrongGuesses += 1;
    }
}
