package org.klgraham;

import java.util.*;

/**
 * Lexicographic permutation generation. Implements algorithm L from
 * Donald Knuth's Fascicle 2B of TAOCP, Generating all permutations.
 * @param <T> type of items to be permuted.
 */
public class Permutations<T extends Comparable<T>> {

    private T[] sequence;
    private final int n;
    public final int numPermutations;

    private int[] a;

    public Permutations(T[] sequence) {
        this.sequence = sequence;
        Arrays.sort(this.sequence);
        n = sequence.length;
        a = new int[n];

        for (int j = 0; j < n; j++) {
            a[j] = j;
        }

        numPermutations = BasicCombinatorics.recursiveFactorial(this.n);
    }

    public static void main(String[] args) {
        Permutations<Integer> intPerm = new Permutations<>(new Integer[]{1, 0, 2, 3});
        System.out.println("Starting sequence: " + intPerm.getSequence());

        System.out.println("Number of permutations: " + intPerm.numPermutations);
        System.out.println("Permutations: ");

        for (int i = 1; i < intPerm.numPermutations; i++) {
            System.out.println(intPerm.next());
        }

        Permutations<String> stringPermutations = new Permutations<>(new String[]{"a", "b", "c", "d"});
        System.out.println("\nStarting sequence: " + stringPermutations.getSequence());

        System.out.println("Number of permutations: " + stringPermutations.numPermutations);
        System.out.println("Permutations: ");

        for (int i = 1; i < stringPermutations.numPermutations; i++) {
            System.out.println(stringPermutations.next());
        }
    }

    public List<T> getSequence() {
        return Arrays.asList(sequence);
    }

    public List<T> next() {
        List<T> permutation = new ArrayList<T>();

        int j = findIndexToUpdate();
        updateAt(j);
        reverseBetween(j, n);

        for (int p = 0; p < n; p++) {
            permutation.add(sequence[a[p]]);
        }



        return permutation;
    }

    private int findIndexToUpdate() {
        int j = n - 1;

        while (j > 0 && a[j-1] >= a[j]) {
            j--;
        }
        return j;
    }

    private void updateAt(int j) {
        int l = n;

        while (a[j-1] >= a[l-1]) {
            l--;
        }
        swap(j-1, l-1);
    }

    private void reverseBetween(int j, int n) {
        int k = j+1;
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
