package org.klgraham.combinatorics;

import java.math.BigInteger;

/**
 * Factorial and Binomial
 *
 * @author kgraham
 *         8/5/16
 */
public class BasicCombinatorics {

	@Deprecated
	public static int iterativeFactorial(int n) {
		// Java 8 streams are not fast yet, so simple iteration is the way to go
		int result = 1;
		for (int i = 1; i <= n; i++)
		{
			result += i;
		}
		return result;
	}

	// Java does not have tail-call optimization, so this will not work for large n
	@Deprecated
	public static int naiveRecursiveFactorial(int n) {
		if (n > 0)
		{
			return n * naiveRecursiveFactorial(n - 1);
		} else
		{
			return 1;
		}
	}

	// tail-recursive, uses BigInteger to handle n above 21
	public static BigInteger factorial(int n) {
		if (n == 0) return BigInteger.valueOf(1);
		return recursiveAccumulator(n-1, BigInteger.valueOf(1));
	}

	private static BigInteger recursiveAccumulator(int n, BigInteger acc) {
		if (n == 0) return acc;
		return recursiveAccumulator(n-1, acc.multiply(BigInteger.valueOf(n)));
	}

	public static BigInteger binomial(int n, int m)
	{
		return factorial(n).divide((factorial(m).multiply(factorial(n-m))));
	}

	public static void main(String[] args)
	{
		System.out.println("100! = " + BasicCombinatorics.factorial(100));
		System.out.println("10 choose 3 = " + BasicCombinatorics.binomial(10, 3));

	}
}
