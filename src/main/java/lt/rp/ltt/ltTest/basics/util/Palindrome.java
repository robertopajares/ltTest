package lt.rp.ltt.ltTest.basics.util;

/**
 * is palindrome methods
 * 
 * @author rpajares 
 */

public class Palindrome {

    /**
     * @param input
     * @return
     */
    public static boolean isPalindromeMethodOne(String input) {
        boolean result = input != null;
        if (result) {
            input = input.toLowerCase();
            int left = 0;
            int right = input.length() - 1;
            while (left < right) {
                if (input.charAt(left++) != input.charAt(right--)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
     
        
    /**
     * @param word
     * @return
     */
    public static boolean isPalindromeMethodTwo(String word) {
        StringBuilder reverse = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse.append(word.charAt(i));
        }
        return (word.equals(reverse.toString()));
    }
    
       

    /**
     * @param word
     * @return
     */
    public static boolean isPalindromeMethodThree(String word) {
        final StringBuilder reverse = new StringBuilder(word).reverse();
        return (word.equals(reverse.toString()));
    }
    
    
    
    

}