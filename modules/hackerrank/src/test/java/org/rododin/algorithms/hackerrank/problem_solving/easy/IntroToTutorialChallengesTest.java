package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link IntroToTutorialChallenges}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class IntroToTutorialChallengesTest
{
	@Test
	public void testCornerCases()
	{
		Assert.assertEquals(-1, IntroToTutorialChallenges.introTutorial(0, new int[] {}));
	}

	@Test
	public void testHRCases()
	{
		Assert.assertEquals(2, IntroToTutorialChallenges.introTutorial(3, new int[] {1, 2, 3}));
		Assert.assertEquals(1, IntroToTutorialChallenges.introTutorial(4, new int[] {1, 4, 5, 7, 9, 12}));
	}

	@Test
	public void testWorldCases()
	{
		Assert.assertEquals(4, IntroToTutorialChallenges.introTutorial(45, new int[] {1, 12, 23, 34, 45, 56, 67, 78, 89, 90}));
		Assert.assertEquals(5, IntroToTutorialChallenges.introTutorial(100, new int[] {-1000, -100, -10, 0, 10, 100, 1000, 10000}));
	}

	@Test
	public void testBigInputDataSet()
	{
		final int N = 10_000_000;
		final int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i * 3;
		final int search = 3 * (N / 2) + 3;
		Assert.assertEquals((N / 2) + 1, IntroToTutorialChallenges.introTutorial(search, arr));
	}
}
