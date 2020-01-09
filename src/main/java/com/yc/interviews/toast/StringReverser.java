package com.yc.interviews.toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Toast Interview Qustions
 *
 * 1) Write a method which reverses a string of characters. e.g. "Hello World!" -> "!dlroW olleH"
 *
 * 2) Write a method which reverses the words in the string. Punctuation and white space stays in place
 * e.g "Yalcin, hello World!" -> "World, hello Yalcin!"
 *
 */
public class StringReverser {

    /**
     * Reverses the string so that characters are in reverse order
     *
     * @param str the given string
     * @return string with reversed characters
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        } else if (str.equals("")) {
            return "";
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    /**
     * Reverses the words in the given string and keeping the punctuations in the same place
     *
     * @param str
     * @return
     */
    public static String reverseWords(String str) {
        if (str == null) {
            return null;
        } else if (str.equals("")) {
            return "";
        }

        String punctuations = ".,:;!";
        String[] words = str.split(" ");
        Map<Integer, String> wordPositionToPunctuation = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String lastChar = words[i].substring(words[i].length() - 1);
            if (punctuations.contains(lastChar)) {
                wordPositionToPunctuation.put(i, lastChar);
            } else {
                wordPositionToPunctuation.put(i, null);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1, j = 0; i >= 0 && j <= words.length; i--, j++) {
            String wordNoPunct = words[i].replaceAll("\\p{Punct}", "");
            sb.append(wordNoPunct);
            if (wordPositionToPunctuation.get(j) != null) {
                sb.append(wordPositionToPunctuation.get(j));
            }
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}