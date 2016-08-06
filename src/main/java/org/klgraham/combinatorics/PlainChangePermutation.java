package org.klgraham.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutation generation. Implements algorithm P (plain changes) from
 * Donald Knuth's Fascicle 2B of TAOCP, Generating all combinatorics.
 * @param <T> type of items to be permuted.
 */
public class PlainChangePermutation<T extends Comparable<T>> extends Permutation {

    private T[] sequence;
    private final int n;
    public final int count;

    private int[] a;
    private int[] o;
    private int[] c; // auxillary array

    public PlainChangePermutation(T[] sequence) {
        this.sequence = sequence;
        Arrays.sort(this.sequence);
        n = sequence.length;
        a = new int[n];
        o = new int[n];
        c = new int[n];

        for (int j = 0; j < n; j++) {
            a[j] = j;
            o[j] = 1;
        }

        count = BasicCombinatorics.factorial(this.n).intValue();
    }

    public static void main(String[] args) {
        PlainChangePermutation<Integer> intPerm = new PlainChangePermutation<>(new Integer[]{1, 0, 2, 3});
        System.out.println("Starting sequence: " + intPerm.getSequence());

        System.out.println("Number of combinatorics: " + intPerm.count);
        System.out.println("LexicographicPermutation: ");

        for (int i = 1; i < intPerm.count; i++) {
            System.out.println(intPerm.next());
        }

        PlainChangePermutation<String> stringPermutations = new PlainChangePermutation<>(new String[]{"a", "b", "c", "d"});
        System.out.println("\nStarting sequence: " + stringPermutations.getSequence());

        System.out.println("Number of combinatorics: " + stringPermutations.count);
        System.out.println("LexicographicPermutation: ");

        for (int i = 1; i < stringPermutations.count; i++) {
            System.out.println(stringPermutations.next());
        }
    }

    public List<T> getSequence() {
        return Arrays.asList(sequence);
    }

    public List<T> next() {
        List<T> permutation = new ArrayList<T>();

        int j = n;
        int s = 0;
        int q;

        while (j > 1) {
            q = c[j-1] + o[j-1]; // P4

            if (q < 0) {
                // P7
                o[j - 1] *= -1;
                j--;
                continue; // back to P4
            } else if (q == j) {
                // P6
                if (j == 1) break;
                s++;
                o[j - 1] *= -1;
                j--;
                continue; // back to P4
            } else {
                //P5
                swap(j-1 - c[j-1] + s, j-1 - q + s);
                c[j-1] = q;
                break;
            }
        }

        for (int p = 0; p < n; p++) {
            permutation.add(sequence[a[p]]);
        }
        return permutation;

    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
