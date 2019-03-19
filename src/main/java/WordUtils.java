import java.util.ArrayList;
import java.util.List;

public class WordUtils {

    static List<String> listOfUnderscores;
    static List<String> wordAsGuessed;

    public WordUtils() {
        listOfUnderscores = new ArrayList<String>();
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
                wordAsGuessed.add(index, letter);
        return wordAsGuessed;
    }

}
