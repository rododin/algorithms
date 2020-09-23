package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link CavityMap}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CavityMapTest
{
	@Test
	public void testCornerCases()
	{
		Assert.assertArrayEquals(new String[] {}, CavityMap.cavityMap(new String[] {}));
		Assert.assertArrayEquals(new String[] {""}, CavityMap.cavityMap(new String[] {""}));
		Assert.assertArrayEquals(new String[] {"1"}, CavityMap.cavityMap(new String[] {"1"}));
		Assert.assertArrayEquals(new String[] {"12", "23"}, CavityMap.cavityMap(new String[] {"12", "23"}));
	}

	@Test
	public void testHRCases()
	{
		Assert.assertArrayEquals(new String[] {"989", "1X1", "111"}, CavityMap.cavityMap(new String[] {"989", "191", "111"}));
		Assert.assertArrayEquals(new String[] {"1112", "1X12", "18X2", "1234"}, CavityMap.cavityMap(new String[] {"1112", "1912", "1892", "1234"}));
	}

	@Test
	public void testCustomCases()
	{
		Assert.assertArrayEquals(new String[] {"11111", "1X1X1", "11X11", "1X1X1", "11111"}, CavityMap.cavityMap(new String[] {"11111", "19191", "11911", "19191", "11111"}));
		Assert.assertArrayEquals(new String[] {"91919", "1X1X1", "91X19", "1X1X1", "91919"}, CavityMap.cavityMap(new String[] {"91919", "19191", "91919", "19191", "91919"}));
	}
}
