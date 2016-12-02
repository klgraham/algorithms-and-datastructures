package org.klgraham.algorithms;

import org.klgraham.datastructures.tree.Suffix;
import org.klgraham.datastructures.tree.SuffixArray;

/**
 * An implementation of the longest common substring algorithm,
 * using suffix arrays.
 *
 *
 */
public class LongestCommonSubstring
{
	public static String search(final String s1, final String s2)
	{
		SuffixArray suffixArray1 = new SuffixArray(s1);
		SuffixArray suffixArray2 = new SuffixArray(s2);

		String lcs = "";
		int j = 0;
		int k = 0;

		while (j < s1.length() && k < s2.length())
		{
			Suffix suffix1 = suffixArray1.getSuffix(j);
			Suffix suffix2 = suffixArray2.getSuffix(k);
			String lcp = findLongestCommonPrefix(suffix1, suffix2);

			if (lcp.length() > lcs.length()) // we've found a longer substring
			{
				lcs = lcp;
			}

			if (suffix1.isBefore(suffix2))
			{
				j++;
			}
			else
			{
				k++;
			}
		}

		return lcs;
	}

	/**
	 * Returns longest common prefix of the input {@link Suffix}es.
	 *
	 * @param s1 a Suffix
	 * @param s2 another Suffix
	 * @return
	 */
	private static String findLongestCommonPrefix(final Suffix s1, final Suffix s2)
	{
		int minLength = Math.min(s1.length(), s2.length());

		for (int i = 0; i < minLength; i++)
		{
			/*
			Compare the next character and if they're different then the longest
			common prefix is the substring of s1 between 0 and this point in the
			loop.
			 */
			if (s1.charAt(i) != s2.charAt(i))
			{
				return s1.substring(i);
			}
		}

		/*
		Since everything has matched up to this point, the longest common prefix
		is the overlap of s1 and s2, up to the position specified by minLength
		 */
		return s1.substring(minLength);
	}


}
