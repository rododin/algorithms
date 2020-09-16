package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link AngryProfessor}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AngryProfessorTest
{
	@Test
	public void test0()
	{
		Assert.assertEquals("NO",  AngryProfessor.isClassCancelled(0, new int[] {  }));
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(1, new int[] {-1}));
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(1, new int[] { 0}));
		Assert.assertEquals("YES", AngryProfessor.isClassCancelled(1, new int[] { 1}));
	}

	@Test
	public void test1()
	{
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(4, new int[] {-1, -1, 0, 0, 1, 1}));
		Assert.assertEquals("YES", AngryProfessor.isClassCancelled(5, new int[] {-1, -1, 0, 0, 1, 1}));
	}

	@Test
	public void test2()
	{
		Assert.assertEquals("YES", AngryProfessor.isClassCancelled(3, new int[] {-1, -3, 4, 2}));
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(2, new int[] { 0, -1, 2, 1}));
	}

	@Test
	public void test3()
	{
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(4, new int[] {-1, -1, -1, -1}));
		Assert.assertEquals("YES", AngryProfessor.isClassCancelled(5, new int[] {-1, -1, -1, -1}));
	}

	@Test
	public void test4()
	{
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(0, new int[] {-1, -1, -1, -1}));
		Assert.assertEquals("NO" , AngryProfessor.isClassCancelled(0, new int[] { 1,  1,  1,  1}));
	}
}
