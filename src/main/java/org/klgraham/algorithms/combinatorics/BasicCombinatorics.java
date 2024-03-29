package org.klgraham.algorithms.combinatorics;

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
		return fact(n, BigInteger.ONE);
	}

	private static BigInteger fact(int n, BigInteger result) {
		if (n == 0) return result;
		return fact(n-1, result.multiply(BigInteger.valueOf(n)));
	}

	public static BigInteger binomial(int n, int m)
	{
		return factorial(n).divide((factorial(m).multiply(factorial(n-m))));
	}

	public static void main(String[] args)
	{
		System.out.println("0! = " + BasicCombinatorics.factorial(0));
		System.out.println("1! = " + BasicCombinatorics.factorial(1));
		System.out.println("2! = " + BasicCombinatorics.factorial(2));
		System.out.println("3! = " + BasicCombinatorics.factorial(3));
		System.out.println("4! = " + BasicCombinatorics.factorial(4));
		System.out.println("5! = " + BasicCombinatorics.factorial(5));
//		System.out.println("10 choose 3 = " + BasicCombinatorics.binomial(10, 3));

	}
}
