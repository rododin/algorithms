package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link TheHurdleRace}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TheHurdleRaceTest
{
	@Test
	public void testCornerCases()
	{
		Assert.assertEquals(0, TheHurdleRace.hurdleRace(0, new int[] {}));
		Assert.assertEquals(0, TheHurdleRace.hurdleRace(5, new int[] {}));
		Assert.assertEquals(Integer.MAX_VALUE, TheHurdleRace.hurdleRace(0, new int[] {0, 1, 2, 3, Integer.MAX_VALUE}));
		Assert.assertEquals(Integer.MAX_VALUE - 10, TheHurdleRace.hurdleRace(10, new int[] {0, 1, 2, 3, Integer.MAX_VALUE}));
		Assert.assertEquals(0, TheHurdleRace.hurdleRace(Integer.MAX_VALUE, new int[] {0, 1, 2, 3, Integer.MAX_VALUE}));
	}

	@Test
	public void testHRCasesAndVariations()
	{
		Assert.assertEquals(3, TheHurdleRace.hurdleRace(0, new int[] {1, 2, 3, 3, 2}));
		Assert.assertEquals(2, TheHurdleRace.hurdleRace(1, new int[] {1, 2, 3, 3, 2}));
		Assert.assertEquals(2, TheHurdleRace.hurdleRace(4, new int[] {1, 6, 3, 5, 2}));
		Assert.assertEquals(0, TheHurdleRace.hurdleRace(7, new int[] {2, 5, 4, 5, 2}));
	}
}
