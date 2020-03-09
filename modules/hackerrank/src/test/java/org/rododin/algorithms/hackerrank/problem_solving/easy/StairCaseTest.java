/*
 * StairCaseTest.java
 */

package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link StairCase}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StairCaseTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals("", StairCase.stairCase(0));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("#\n", StairCase.stairCase(1));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals( "       #\n"
		                   + "      ##\n"
		                   + "     ###\n"
		                   + "    ####\n"
		                   + "   #####\n"
		                   + "  ######\n"
		                   + " #######\n"
		                   + "########\n"
		                   , StairCase.stairCase(8));
	}
}
