import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.maximeroussy.invitrode.WordGenerator;

public class WordUtils {

    static List<String> listOfUnderscores = new ArrayList<String>();
    static List<String> wordAsGuessed;

    public WordUtils() {

    }

    public static String generateRandomWord() {
        Random random = new Random();
        int lengthOfWord = random.nextInt(8);
        WordGenerator generator = new WordGenerator();
        return generator.newWord(lengthOfWord).toLowerCase();
    }


    static List<String> getWordAsList(String word) {
        List<String> returnList = new ArrayList<String>();
        for(char c : word.toCharArray()) {
            returnList.add(String.valueOf(c));
        }
        return returnList;
    }

    static List<String> createListOfUnderscores(List<String> letters) {
        for (String letter : letters){
            listOfUnderscores.add("_");
        }
        return listOfUnderscores;
    }

    static List<String> buildWordAsGuessed(List<String> list, int index, String letter){
        wordAsGuessed = list;
                wordAsGuessed.set(index, letter);
        return wordAsGuessed;
    }

}
