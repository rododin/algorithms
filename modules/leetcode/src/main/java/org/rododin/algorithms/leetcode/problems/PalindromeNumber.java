package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/description/">
 *   LeetCode > Problems > Palindrome Number <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PalindromeNumber
{
	public static boolean isPalindrome(int x)
	{
		return isPalindromeV2(x);
	}

	/**
	 * A slow (brutal) solution based on conversion the number {@code x} to decimal {@link String} representation with
	 * further char-by-char comparison. The computation complexity of the number checking loop is only  {@code O(n/2)},
	 * however the conversion to string still adds at least {@code O(n)}, as well as it creates a temporary {@link String}
	 * instance causing a memory allocation at the heap, as well as it also causes more load on GC further. Thus,
	 * the summary computation complexity is estimated as {@code O(n + n/2)}, where {@code n} is the number of decimal
	 * places of the given number {@code x}, so, maximally {@code n} is only {@code 10} for an {@code int} number.
	 */
	public static boolean isPalindromeV1(int x)
	{
		if (x < 0)
			return false;
		final String s = Integer.toString(x);
		for (int i = 0; i < s.length() / 2; i++)
		{
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	/**
	 * A more optimal solution avoiding any conversion of the {@code x} number to {@link String}, however
	 * it uses a minor loop to calculate the number of decimal places of the {@code x} number. For {@code int}
	 * it rounds only {@code 10} iterations at max. Even if we'll develop the same for {@code long} numbers it will be
	 * only {@code 19}, and thus, such solution should be fine.
	 * So, the summary complexity here is also {@code O(n + n /2)}, however this algorithm doesn't create any temporary
	 * {@link String} instances, or other buffer arrays, or so.
	 * According to LeetCode analysis it gets executed few times faster compared with {@link #isPalindromeV1(int)}.
	 */
	public static boolean isPalindromeV2(int x)
	{
		if (x < 0)
			return false;

		int decimalPlaceNumber = 1;
		int xx = x;
		int dr = 1;
		while ((xx /= 10) > 0)
		{
			decimalPlaceNumber++;
			dr *= 10;
		}

		for (int i = 0, dl = 1; i < decimalPlaceNumber / 2; i++, dl *= 10, dr /= 10)
		{
			final int left  = (x / dl) % 10;
			final int right = (x / dr) % 10;
			if (left != right)
				return false;
		}
		return true;
	}

	/**
	 * The 3rd version of the algorithm. Same as {@link #isPalindromeV2(int)} it doesn't create and buffer {@link String}
	 * or other buffer array instances. but additionally it also avoids the first loop for computing the number of
	 * decimal places of the given number {@code x}. Instead, it utilizes the {@link Math#log10(double)} function to
	 * compute the number of decimal places, as well as it also utilizes the {@link Math#pow(double, double)} function
	 * to compute maximal right-side divider given non-zero value on dividing {@code x} by the divider.
	 * Thus, the formal computation complexity of this algorithm is only {@code O(n /2)} which is about 3 times less
	 * compared with {@link #isPalindromeV1(int)} and {@link #isPalindromeV2(int)}, however it utilizes 2 float-point
	 * operations, which is generally not the best way to go on operating with integer numbers. So, according to LeetCode
	 * analysis it doesn't give any real computation speed-up compared with {@link #isPalindromeV2(int)}.
	 */
	public static boolean isPalindromeV3(int x)
	{
		if (x < 0)
			return false;
		final long log10 = (long)Math.log10(x);

		for (long i = 0, dl = 1, dr = (long)Math.pow(10, log10); i < (log10 + 1) / 2; i++, dl *= 10, dr /= 10)
		{
			final long left  = (x / dl) % 10;
			final long right = (x / dr) % 10;
			if (left != right)
				return false;
		}
		return true;
	}
}
