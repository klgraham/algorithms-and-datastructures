package org.klgraham.datastructures.tree;

import java.util.Arrays;

/**
 * A sorted array of all suffixes of a string.
 * Used in the longest common substring calculation.
 *
 * For information about suffix arrays, see <a href="https://en.wikipedia.org/wiki/Suffix_array">Wikipedia's Suffix Array page</a> or
 * <a href="http://algs4.cs.princeton.edu/63suffix">Section 6.3</a> of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 */
public class SuffixArray
{
	private Suffix[] suffixes;

	public SuffixArray(String text)
	{
		int n = text.length();
		this.suffixes = new Suffix[n];

		for (int i = 0; i < n; i++)
		{
			suffixes[i] = new Suffix(text, i);
		}
		Arrays.sort(suffixes);
	}

	/**
	 * Number of suffixes, which is also the length of the parent string
	 * @return
	 */
	public int length()
	{
		return suffixes.length;
	}

	/**
	 * Returns the <em>i</em>th smallest suffix
	 * @param i index to retrieve
	 * @return the <em>i</em>th smallest suffix
	 */
	public Suffix getSuffix(int i)
	{
		return suffixes[i];
	}
}

