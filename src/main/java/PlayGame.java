import java.io.PrintStream;
import java.util.Scanner;

public class PlayGame {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PrintStream printStream = System.out;
        HangmanGame hangmanGame = new HangmanGame(scanner, printStream);
        hangmanGame.play();
    }
}
