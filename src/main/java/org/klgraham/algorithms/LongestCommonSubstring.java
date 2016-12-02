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
	/**
	 * Computes the longest common substring of the specified strings and the
	 * starting indices of the LCP in each input string
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static LcsInfo search(final String s1, final String s2)
	{
		SuffixArray suffixArray1 = new SuffixArray(s1);
		SuffixArray suffixArray2 = new SuffixArray(s2);

		String lcs = "";
		int j = 0;
		int k = 0;
		Suffix suffix1;
		Suffix suffix2;
		int leftStart = 0;
		int rightStart = 0;

		while (j < s1.length() && k < s2.length())
		{
			suffix1 = suffixArray1.getSuffix(j);
			suffix2 = suffixArray2.getSuffix(k);
			LcpInfo lcpInfo = findLongestCommonPrefix(suffix1, suffix2);

			if (lcpInfo.lcp.length() > lcs.length()) // we've found a longer substring
			{
				lcs = lcpInfo.lcp;
				leftStart = suffix1.getIndex();
				rightStart = suffix2.getIndex();
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

		return new LcsInfo(lcs, leftStart, rightStart);
	}

	/**
	 * Returns longest common prefix of the input {@link Suffix}es.
	 *
	 * @param s1 a Suffix
	 * @param s2 another Suffix
	 * @return
	 */
	private static LcpInfo findLongestCommonPrefix(final Suffix s1, final Suffix s2)
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
				return new LcpInfo(s1.substring(i), i);
			}
		}

		/*
		Since everything has matched up to this point, the longest common prefix
		is the overlap of s1 and s2, up to the position specified by minLength
		 */
		return new LcpInfo(s1.substring(minLength), minLength);
	}

	/*
	Holds the longest common substring (LCS), index of the LHS string at which
	the LCP starts, and the index of the RHS string at which the LCP starts.

	These two integers will be needed later when the neighboring text needs to be
	merged.
	 */
	public static class LcsInfo
	{
		public final String lcs;
		public final int leftStart;
		public final int rightStart;

		public LcsInfo(final String lcs, final int leftStart, final int rightStart)
		{
			this.lcs = lcs;
			this.leftStart = leftStart;
			this.rightStart = rightStart;
		}
	}

	/*
	Holds the longest common prefix (LCP) and the index of the RHS string at which
	the LCP starts.
	 */
	private static class LcpInfo
	{
		public final String lcp;
		public final int rightStart;

		public LcpInfo(final String lcp, final int rightStart)
		{
			this.lcp = lcp;
			this.rightStart = rightStart;
		}
	}
}