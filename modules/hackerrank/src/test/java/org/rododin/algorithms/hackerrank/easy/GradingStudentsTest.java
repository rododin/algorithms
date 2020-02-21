package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link GradingStudents}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GradingStudentsTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals              (Arrays.asList(75, 67, 40, 33),
		  GradingStudents.gradingStudents(Arrays.asList(73, 67, 38, 33)));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals              (Arrays.asList(4, 7, 9, 28, 40, 45, 60, 85, 87, 92, 100, 100),
		  GradingStudents.gradingStudents(Arrays.asList(4, 7, 9, 28, 38, 44, 58, 83, 87, 92,  99, 100)));
	}
}
