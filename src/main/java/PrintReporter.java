import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class PrintReporter {
    private PrintStream printStream;

    public PrintReporter(PrintStream printStream) {
        this.printStream = printStream;
    }

    void printUnderscores(List<String> wordAsList) {
        printStream.println("My word: " + Arrays.toString(WordUtils.createListOfUnderscores(wordAsList).toArray()).replaceAll("," , "")); //change to print number of places based on chosen word length
    }

    void printGallows(GameState gameState) {
        printStream.println(GallowSegments.valueOf("SEGMENT_" + gameState.getWrongGuesses()).output);
    }

    void printWordAsGuessed (List<String> wordAsGuessed){
        printStream.println("My word: " + Arrays.toString(wordAsGuessed.toArray()).replaceAll("," , "")); //change to print number of places based on chosen word length

    }
}
