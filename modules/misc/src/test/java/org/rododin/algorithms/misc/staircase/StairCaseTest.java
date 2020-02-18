/*
 * StairCaseTest.java
 */

package org.rododin.algorithms.misc.staircase;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.misc.staircase.StairCase;

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
