package com.yc.algorithms;

public class Recursion {

    /**
     * Removes vowels from the given string
     * <p>
     * example: removeVowels("recurse")
     * should return: "rcrs"
     *
     * @param str
     * @return The given string without vowels
     */
    public static String removeVowels(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char c = str.charAt(0);
        String rest = removeVowels(str.substring(1));
//        System.out.println(rest);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return rest;
        } else {
            return c + rest;
        }
    }

}
