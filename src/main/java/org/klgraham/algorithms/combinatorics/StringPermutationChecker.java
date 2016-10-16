package org.klgraham.algorithms.combinatorics;

import java.util.Arrays;

/**
 * Created by klogram on 10/15/16.
 */
public class StringPermutationChecker {

    boolean IsPermutationOf(String leftString, String rightString) {
        String s1 = leftString;
        String s2 = rightString;

        byte[] c1 = s1.getBytes();
        byte[] c2 = s2.getBytes();
        if (c1.length != c2.length) return false;
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) if (c1[i] != c2[i]) return false;
        return true;
    }


}

