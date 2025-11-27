package org.rododin.algorithms.hackerrank.java.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.hackerrank.com/challenges/java-lambda-expressions/problem">
 *   HackerRank > Prepare > Java > Advanced > Java Lambda Expressions
 * </a> Problem Solution.
 * <p>
 * NOTE: We name the main class as {@code JavaLambdaExpressions}, meanwhile at
 *       <a href="https://www.hackerrank.com/challenges/java-lambda-expressions/problem">HackerRank</a>
 *       it's named {@code Solution} as usually. Everything else is named the same.
 *       I haven't reformated it according to my project formatting rules, I've implemented the only
 *       requested methods at the class {@code MyMath}: {@code isOdd()}, {@code isPrime()} and {@code isPalindrome()}.
 *       Please also note, I've taken the {@code isPalindrome()} algorithm from previously implemented
 *       {@code PalindromeNumber.isPalindromeV2(int x)} from the {@code leetcode} module.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaLambdaExpressions
{
	public static void main(String[] args) throws IOException
	{
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0)
		{
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1)
			{
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			}
			else if (ch == 2)
			{
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			}
			else if (ch == 3)
			{
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}

interface PerformOperation {
	boolean check(int a);
}
class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	// Write your code here
	public PerformOperation isOdd()
	{
		return a -> a % 2 == 1;
	}

	public PerformOperation isPrime()
	{
		return a -> a > 1 && java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(a)).noneMatch(n -> (a % n == 0));
	}

	public PerformOperation isPalindrome()
	{
		return a ->
		{
			if (a < 0)
				return false;

			int decimalPlaceNumber = 1;
			int xx = a;
			int dr = 1;
			while ((xx /= 10) > 0)
			{
				decimalPlaceNumber++;
				dr *= 10;
			}

			for (int i = 0, dl = 1; i < decimalPlaceNumber / 2; i++, dl *= 10, dr /= 10)
			{
				final int left  = (a / dl) % 10;
				final int right = (a / dr) % 10;
				if (left != right)
					return false;
			}
			return true;
		};
	}
}
