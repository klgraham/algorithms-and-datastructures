package org.klgraham;

import java.util.HashMap;
import java.util.Map;

/**
 * Description of file content.
 *
 * @author kgraham
 *         8/5/16
 */
public class Fibonacci
{
	// Compute's nth Fibonacci number, with recursion (simple and slow)
	public static int recursiveFibonacci(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;

		return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}

	public static int fibonacci(int n)
	{
		int fn_2 = 0;
		int fn_1 = 1;

		if (n == 0) return fn_2;
		if (n == 1) return fn_1;

		int result = 0;
		for (int i = 2; i <= n; i++)
		{
			result = fn_1 + fn_2;
			fn_2 = fn_1;
			fn_1 = result;
		}
		return result;
	}

	private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	// Compute's nth Fibonacci number, with recursion (caching, faster)
	public static int recursiveFibonacciWithCaching(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (cache.containsKey(n)) return cache.get(n);

		int result = recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
		cache.put(n, result);
		return result;
	}

	private static double phi = 1.6180339887498948482;
	private static double oneMinusphi = -0.6180339887498948482;
	private static double sqrt5 = Math.sqrt(5.0);

	// Compute's nth Fibonacci number, with Golden Ratio (caching, fastest)
	public static int goldenRationFibonacciWithCaching(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (cache.containsKey(n)) return cache.get(n);

		double result = (Math.pow(phi, n) - Math.pow(oneMinusphi, n)) / sqrt5;
		cache.put(n, (int)result);
		return (int)result;
	}

	public static void main(String[] args)
	{
		int N = 46;

//		System.out.println("\nRecursive:");
//		for (int n = 0; n <= N; n++)
//		{
//			System.out.println("F(" + n + ") = " + recursiveFibonacci(n));
//		}
		System.out.println("\nRecursive, with Caching:");
		for (int n = 0; n <= N; n++)
		{
			System.out.println("F(" + n + ") = " + recursiveFibonacciWithCaching(n));
		}
		System.out.println("\niterative:");
		for (int n = 0; n <= N; n++)
		{
			System.out.println("F(" + n + ") = " + fibonacci(n));
		}
		System.out.println("\nGolden Ratio:");
		cache.clear();
		for (int n = 0; n <= N; n++)
		{
			System.out.println("F(" + n + ") = " + goldenRationFibonacciWithCaching(n));
		}
	}
}
