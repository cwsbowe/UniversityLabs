import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.PalindromeChecker;

public class KPalindrome implements PalindromeChecker {
    public boolean isKPalindrome(String word, int k) {
        Boolean palindrome = false;
        int numRemoved = 0;
        palindrome = isKPalindrome(word, k, numRemoved);
        return palindrome;
    }
    public boolean isKPalindrome(String word, int k, int numRemoved) {
        Boolean palindrome = false;
        if (word.length() < 2) {
            palindrome = true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            word = word.substring(1, word.length()-1);
            palindrome = isKPalindrome(word, k, numRemoved);
        } else if (k > 0) {
            palindrome = isKPalindrome(word.substring(1), k - 1);
            if (!palindrome) {
                palindrome = isKPalindrome(word.substring(0, word.length() - 1), k - 1);
            }
        }
        return palindrome;
    }
}
