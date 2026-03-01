package org.rododin.algorithms.leetcode.problems;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link FindAllAnagrams}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FindAllAnagramsTest
{
	@Test
	public void test0()
	{
		Assert.assertEquals(List.of(0), FindAllAnagrams.findAnagrams("", ""));
	}

	@Test
	public void test1()
	{
		Assert.assertEquals(List.of(0, 6), FindAllAnagrams.findAnagrams("cbaebabacd", "abc"));
		//Assert.assertTrue(Set.of(0, 6).containsAll(FindAllAnagrams.findAnagrams("cbaebabacd", "abc")));
	}
}
