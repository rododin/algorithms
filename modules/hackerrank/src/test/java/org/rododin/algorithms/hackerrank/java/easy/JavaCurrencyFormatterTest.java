/*
 * JavaCurrencyFormatterTest.java
 */

package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaCurrencyFormatter}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaCurrencyFormatterTest
{
	@Test
	public void test01()
	{
		Assert.assertArrayEquals(new String[] {"$12,324.13", "Rs.12,324.13", "￥12,324.13", "12 324,13 €"}, JavaCurrencyFormatter.printFormatDefaultCurrencies(12324.134));
	}
}
