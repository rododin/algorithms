package org.rododin.algorithms.leetcode.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit Test(s) for <code>{@link PalindromeNumber}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PalindromeNumberTest
{
	@Test
	public void test()
	{
		Assertions.assertFalse(PalindromeNumber.isPalindrome(        -1));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(         0));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(         1));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(        10));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(        11));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(        20));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(        22));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(       100));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(       111));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(       121));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(       122));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(       909));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(      1000));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(      7997));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(     10101));
		Assertions.assertTrue (PalindromeNumber.isPalindrome( 123454321));
		Assertions.assertTrue (PalindromeNumber.isPalindrome(1234554321));
	}
}
