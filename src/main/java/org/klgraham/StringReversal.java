package org.klgraham;

/**
 * Created by klogram on 8/5/16.
 */
public class StringReversal {

    public static String reverseStringIterative(final String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static String reverseStringRecursive(final String s) {
        int charCount = s.length();
        return accumulateChars(s, charCount, new StringBuilder());
    }

    private static String accumulateChars(final String s, int remainingChars, final StringBuilder accumulator) {
        if (remainingChars == 0) return accumulator.toString();

        accumulator.append(s.charAt(remainingChars - 1));
        return accumulateChars(s, remainingChars - 1, accumulator);
    }

    public static String reverseWords(final String s) {
        String[] words = s.split(" ");
        return accumulateWords(words, words.length - 1, new StringBuilder(words[words.length - 1]));
    }

    private static String accumulateWords(String[] words, int remainingWords, final StringBuilder accumulator) {
        if (remainingWords == 0) return accumulator.toString();

        accumulator.append(" ").append(words[remainingWords - 1]);
        return accumulateWords(words, remainingWords - 1, accumulator);
    }

    public static void main(String[] args) {
        String s1 = "This is a test. This is only a test.";

        System.out.println("String: " + s1);
        System.out.println("Reversed string (iterative): " + reverseStringIterative(s1));
        System.out.println("Reversed string (recursive): " + reverseStringRecursive(s1));
        System.out.println("Reversed words (recursive): " + reverseWords(s1));

    }
}
