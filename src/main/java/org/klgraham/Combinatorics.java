package org.klgraham;

/**
 * Description of file content.
 *
 * @author kgraham
 *         8/5/16
 */
public class Combinatorics
{
	public static int factorial(int n)
	{
		// Java 8 streams are not fast yet, so simple iteration is the way to go
		int result = 1;
		for (int i = 1; i <= n; i++)
		{
			result += i;
		}
		return result;
	}

	// Java does not have tail-call optimization, so this will not work for large n
	public static int recursiveFactorial(int n)
	{
		if (n > 0)
		{
			return n * recursiveFactorial(n - 1);
		} else
		{
			return 1;
		}
	}

	public static double binomial(int n, int m)
	{
		return factorial(n) / (factorial(m) * factorial(n-m));
	}

	public static void main(String[] args)
	{
		System.out.println("5! = " + Combinatorics.recursiveFactorial(5));
		System.out.println("1000! = " + Combinatorics.factorial(1000));
		System.out.println("10 choose 3 = " + Combinatorics.binomial(10, 3));

	}
}
