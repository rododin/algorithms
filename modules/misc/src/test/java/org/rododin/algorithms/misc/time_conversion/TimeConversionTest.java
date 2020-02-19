/*
 * TimeConversionTest.java
 */

package org.rododin.algorithms.misc.time_conversion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link TimeConversion}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TimeConversionTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals("19:05:45", TimeConversion.timeConversion("07:05:45PM"));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("00:00:00", TimeConversion.timeConversion("12:00:00AM"));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals("12:00:00", TimeConversion.timeConversion("12:00:00PM"));
	}

	@Test
	public void testOld01()
	{
		Assert.assertEquals("19:05:45", TimeConversion.timeConversionOld("07:05:45PM"));
	}

	@Test
	public void testOld02()
	{
		Assert.assertEquals("00:00:00", TimeConversion.timeConversionOld("12:00:00AM"));
	}

	@Test
	public void testOld03()
	{
		Assert.assertEquals("12:00:00", TimeConversion.timeConversionOld("12:00:00PM"));
	}
}
