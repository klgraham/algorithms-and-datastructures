package org.klgraham.permutations;

import org.klgraham.BasicCombinatorics;

import java.util.*;

/**
 * Lexicographic permutation generation. Implements algorithm L from
 * Donald Knuth's Fascicle 2B of TAOCP, Generating all permutations.
 * @param <T> type of items to be permuted.
 */
public class LexicographicPermutation<T extends Comparable<T>> extends Permutation {

    private T[] sequence;
    private final int n;
    public final int count;

    private int[] a;

    public LexicographicPermutation(T[] sequence) {
        this.sequence = sequence;
        Arrays.sort(this.sequence);
        n = sequence.length;
        a = new int[n];

        for (int j = 0; j < n; j++) {
            a[j] = j;
        }

        count = BasicCombinatorics.recursiveFactorial(this.n);
    }

    public static void main(String[] args) {
        LexicographicPermutation<Integer> intPerm = new LexicographicPermutation<>(new Integer[]{1, 0, 2, 3});
        System.out.println("Starting sequence: " + intPerm.getSequence());

        System.out.println("Number of permutations: " + intPerm.count);
        System.out.println("LexicographicPermutation: ");

        for (int i = 1; i < intPerm.count; i++) {
            System.out.println(intPerm.next());
        }

        LexicographicPermutation<String> stringPermutations = new LexicographicPermutation<>(new String[]{"a", "b", "c", "d"});
        System.out.println("\nStarting sequence: " + stringPermutations.getSequence());

        System.out.println("Number of permutations: " + stringPermutations.count);
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

        int j = getIndexToUpdate();
        update(j);
        reverseFrom(j+1);

        for (int p = 0; p < n; p++) {
            permutation.add(sequence[a[p]]);
        }

        return permutation;
    }

    private int getIndexToUpdate() {
        int j = n - 1;

        while (j > 0 && a[j-1] >= a[j]) {
            j--;
        }
        return j;
    }

    private void update(int j) {
        int l = n;

        while (a[j-1] >= a[l-1]) {
            l--;
        }
        swap(j-1, l-1);
    }

    private void reverseFrom(int j) {
        int k = j;
        int l = n;

        while (k < l) {
            swap(k-1, l-1);
            k++;
            l--;
        }
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
