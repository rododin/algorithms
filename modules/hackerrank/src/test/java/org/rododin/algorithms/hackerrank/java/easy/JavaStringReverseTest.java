package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaStringReverse}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStringReverseTest
{
	@Test
	public void test01()
	{
		Assert.assertTrue(JavaStringReverse.printIsPalindrome("madam"));
	}

	@Test
	public void test02()
	{
		Assert.assertFalse(JavaStringReverse.printIsPalindrome("madame"));
	}

	@Test
	public void test03()
	{
		Assert.assertTrue(JavaStringReverse.printIsPalindrome("++11-22-33-22-11++"));
	}

	@Test
	public void test04()
	{
		Assert.assertTrue(JavaStringReverse.printIsPalindrome(""));
	}
}
