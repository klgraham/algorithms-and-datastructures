package org.klgraham.algorithms.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Simple, recursive lexicographic permutation generation.
 * @param <T> type of items to be permuted.
 */
public class RecursiveLexicographicPermutation<T extends Comparable<T>> {

    private T[] sequence;

    public RecursiveLexicographicPermutation(T[] sequence) {
        this.sequence = sequence;
    }

    public static void main(String[] args) {
        RecursiveLexicographicPermutation<Integer> intPerm = new RecursiveLexicographicPermutation<>(new Integer[]{1, 0, 2, 3, 5, 6, 7});
        System.out.println("Sequence: " + intPerm.getSequence());

        System.out.println("LexicographicPermutation: ");

        intPerm.getAllPermutations().forEach(System.out::println);

        RecursiveLexicographicPermutation<String> stringPermutations = new RecursiveLexicographicPermutation<>(new String[]{"a", "b", "c", "d"});
        System.out.println("\nSequence: " + stringPermutations.getSequence());

        System.out.println("LexicographicPermutation: ");

        stringPermutations.getAllPermutations().forEach(System.out::println);

        String s1 = "apple";
        System.out.println("All permutations of '" + s1 + "'");
        RecursiveLexicographicPermutation<Character> applePermutations = new RecursiveLexicographicPermutation<>(stringToCharacters(s1));
        System.out.println("\nSequence: " + applePermutations.getSequence());

        System.out.println("Lexicographic Permutations: ");

        applePermutations.getAllPermutations().forEach(System.out::println);
    }

    public List<T> getSequence() {
        return Arrays.asList(sequence);
    }

	public List<List<T>> getAllPermutations()
    {
        List<List<T>> perms = new ArrayList<>();
        if (sequence.length == 0)
        {
            return perms;
        }
        else
        {
            perms.add(Collections.singletonList(sequence[0]));
            return recurseAndInsert(tail(getSequence()), perms);
        }
    }

    private List<List<T>> recurseAndInsert(final List<T> list, final List<List<T>> perms)
    {
        List<List<T>> newPerms = new ArrayList<>();

        if (list.isEmpty())
        {
            return perms;
        }
        else
        {
            T head = list.get(0);
            for (List<T> perm : perms)
            {
                for (int i = 0; i <= perm.size(); i++)
                {
                    List<T> p = new ArrayList<>(perm);
                    p.add(i, head);
                    newPerms.add(p);
                }
            }
            return recurseAndInsert(tail(list), newPerms);
        }
    }

    private static Character[] stringToCharacters(final String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = new Character(s.charAt(i));
        }
        return chars;
    }

    private <K> List<K> tail(List<K> list)
    {
        return list.subList(1, list.size());
    }
}
