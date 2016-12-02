package org.klgraham.datastructures.tree;

/**
 * A suffix of a string is a substring from some position all the way to the end.
 */
public class Suffix implements Comparable<Suffix>
{
	// text of the parent string
	private final String text;

	// index at which suffix starts
	private final int index;

	public Suffix(final String text, final int index)
	{
		this.text = text;
		this.index = index;
	}

	// Suffix length
	public int length()
	{
		// the string has length n and the suffix starts at index
		return text.length() - index;
	}

	public char charAt(int i)
	{
		// must shift right by where the suffix starts
		return text.charAt(i + index);
	}

	public int getIndex()
	{
		return index;
	}

	@Override
	public int compareTo(final Suffix other)
	{
		// are they the same object?
		if (this == other) {
			return 0;
		}

		/*
		Can compare the suffixes with String's compareTo if
		text.substring(index) is called, but that allocates a new String
		object. Using charAt is constant time and allocates no memory.

		This will be used on transcriptions of up to 30s of audio, so the
		efficiency could be important.
		 */
		int thisLength = this.length();
		int otherLength = other.length();
		int lengthOfShorterSuffix = Math.min(thisLength, otherLength);

		int k = 0;
		while (k < lengthOfShorterSuffix)
		{
			char thisChar = this.charAt(k);
			char otherChar = other.charAt(k);

			if (thisChar != otherChar)
			{
				return thisChar - otherChar;
			}
			k++;
		}

		return thisLength - otherLength;
	}

	/**
	 * Returns true when this Suffix comes before the other Suffix in lexicographic
	 * order.
	 * @param other Suffix
	 * @return true when this Suffix comes before the other Suffix in lexicographic,
	 *         false otherwise
	 */
	public boolean isBefore(final Suffix other)
	{
		return this.compareTo(other) < 0;
	}

	/**
	 * Returns the substring of this suffix, from 0 to <em>i</em>
	 * @param i index where the substring ends
	 * @return the substring of this suffix, from 0 to <em>i</em>
	 */
	public String substring(int i)
	{
		return text.substring(index, index + i);
	}

	@Override
	public String toString()
	{
		return text.substring(index);
	}
}