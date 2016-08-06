package org.klgraham;

import java.util.HashMap;
import java.util.Map;

/**
 * Several ways to compute fibonacci numbers
 *
 * @author kgraham
 *         8/5/16
 */
public class Fibonacci
{
	// Compute's nth Fibonacci number, with recursion (naive, not tail-recursive)
	@Deprecated
	public static int naiveRecursiveFibonacci(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;

		return naiveRecursiveFibonacci(n-1) + naiveRecursiveFibonacci(n-2);
	}

	// tail-recursive
	public static int fibonacci(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;

		return fibonacciAccumulator(n-1, 0, 1);
	}

	private static int fibonacciAccumulator(int n, int prevPrev, int prev) {
		if (n == 0) return prev + prevPrev;
		return fibonacciAccumulator(n-1, prev, prev + prevPrev);
	}

	@Deprecated
	public static int iterativeFibonacci(int n)
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

	// tail-recursive, with caching
	// not so much needed with a tail-recursive version, unless you'll be computing
	// fibonacci numbers a lot and don't want to recalculate
	@Deprecated
	public static int fibonacciWithCaching(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (cache.containsKey(n)) return cache.get(n);

		int result = fibonacci(n-1) + fibonacci(n-2);
		cache.put(n, result);
		return result;
	}

	private static double phi = 1.6180339887498948482;
	private static double oneMinusphi = -0.6180339887498948482;
	private static double sqrt5 = Math.sqrt(5.0);

	// Compute's nth Fibonacci number, with Golden Ratio (caching)
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
		int N = 40;

		System.out.println("\nTail-recursive:");
		for (int n = 0; n <= N; n++)
		{
			System.out.println("F(" + n + ") = " + fibonacci(n));
		}
//		System.out.println("\nTail-recursive, with Caching:");
//		for (int n = 0; n <= N; n++)
//		{
//			System.out.println("F(" + n + ") = " + fibonacciWithCaching(n));
//		}
//		System.out.println("\niterative:");
//		for (int n = 0; n <= N; n++)
//		{
//			System.out.println("F(" + n + ") = " + iterativeFibonacci(n));
//		}
		System.out.println("\nUsing Golden Ratio:");
		cache.clear();
		for (int n = 0; n <= N; n++)
		{
			System.out.println("F(" + n + ") = " + goldenRationFibonacciWithCaching(n));
		}
	}
}
