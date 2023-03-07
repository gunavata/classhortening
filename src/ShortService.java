import java.util.*;

/**
 * @author Tan Oliver
 */
public class ShortService {
    // Assumption is made that fullName always passes a valid package.class (Meaning at least
    // a single package and class), both are required args and length is not a negative number!
    String shortenClassName(String fullName, int length) {
        List<String> wordList = Arrays.asList(fullName.split("\\."));

        // Start from the class name and work backwards
        Collections.reverse(wordList);

        StringBuilder result = new StringBuilder(wordList.get(0));
        int currentLength = wordList.get(0).length();

        // Loop through the list (Skipping the first instance)
        // Find if currentLength is currently shorter than specified acceptable
        // If yes, append word with period
        // If no, append first character of word with period
        for (int i = 1; i < wordList.size(); i++) {
            String word = wordList.get(i);
            currentLength = currentLength + word.length();
            if (currentLength <= length) {
                result.insert(0, word + ".");
            } else {
                result.insert(0, word.charAt(0) + ".");
            }
        }

        return result.toString();
    }
}
