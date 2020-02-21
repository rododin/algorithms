/*
 * DayOfTheProgrammerTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link DayOfTheProgrammer}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class DayOfTheProgrammerTest
{
	@Test
	public void test1700()
	{
		Assert.assertEquals("12.09.1700", DayOfTheProgrammer.dayOfProgrammer(1700));
	}

	@Test
	public void test1800()
	{
		Assert.assertEquals("12.09.1800", DayOfTheProgrammer.dayOfProgrammer(1800));
	}

	@Test
	public void test1900()
	{
		Assert.assertEquals("12.09.1900", DayOfTheProgrammer.dayOfProgrammer(1900));
	}

	@Test
	public void test1917()
	{
		Assert.assertEquals("13.09.1917", DayOfTheProgrammer.dayOfProgrammer(1917));
	}

	@Test
	public void test1918()
	{
		Assert.assertEquals("26.09.1918", DayOfTheProgrammer.dayOfProgrammer(1918));
	}

	@Test
	public void test1919()
	{
		Assert.assertEquals("13.09.1919", DayOfTheProgrammer.dayOfProgrammer(1919));
	}

	@Test
	public void test1984()
	{
		Assert.assertEquals("12.09.1984", DayOfTheProgrammer.dayOfProgrammer(1984));
	}

	@Test
	public void test2000()
	{
		Assert.assertEquals("12.09.2000", DayOfTheProgrammer.dayOfProgrammer(2000));
	}

	@Test
	public void test2100()
	{
		Assert.assertEquals("13.09.2100", DayOfTheProgrammer.dayOfProgrammer(2100));
	}

	@Test
	public void test2200()
	{
		Assert.assertEquals("13.09.2200", DayOfTheProgrammer.dayOfProgrammer(2200));
	}

	@Test
	public void test2400()
	{
		Assert.assertEquals("12.09.2400", DayOfTheProgrammer.dayOfProgrammer(2400));
	}

	@Test
	public void test2700()
	{
		Assert.assertEquals("13.09.2700", DayOfTheProgrammer.dayOfProgrammer(2700));
	}
}
