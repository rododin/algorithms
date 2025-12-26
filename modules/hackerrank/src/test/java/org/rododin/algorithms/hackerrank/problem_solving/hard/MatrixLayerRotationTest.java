package org.rododin.algorithms.hackerrank.problem_solving.hard;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link MatrixLayerRotation}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MatrixLayerRotationTest
	extends AbstractTest
{
	@Test
	public void testVerySimple1()
	{
		doTest(
			stringsToStringByLine(
				"""
				2 2 3
				1 1
				1 1
				"""
			),
			() -> MatrixLayerRotation.main(null),
			stringsToStringByLine(
				"""
				1 1
				1 1
				"""
			)
		);
	}

	@Test
	public void testVerySimple2()
	{
		doTest(
			stringsToStringByLine(
				"""
				2 2 3
				1 0
				0 1
				"""
			),
			() -> MatrixLayerRotation.main(null),
			stringsToStringByLine(
				"""
				0 1
				1 0
				"""
			)
		);
	}

	@Test
	public void testSimple()
	{
		doTest(
			stringsToStringByLine(
				"""
				4 4 2
				1 2 3 4
				5 6 7 8
				9 10 11 12
				13 14 15 16
				"""
			),
			() -> MatrixLayerRotation.main(null),
			stringsToStringByLine(
				"""
				3 4 8 12
				2 11 10 16
				1 7 6 15
				5 9 13 14
				"""
			)
		);
	}

	@Test
	public void testMedium()
	{
		doTest(
			stringsToStringByLine(
				"""
				7 9 5
				11 12 13 14 15 16 17 18 19
				21 22 23 24 25 26 27 28 29
				31 32 33 34 35 36 37 38 39
				41 42 43 44 45 46 47 48 49
				51 52 53 54 55 56 57 58 59
				61 62 63 64 65 66 67 68 69
				71 72 73 74 75 76 77 78 79
				"""
			),
			() -> MatrixLayerRotation.main(null),
			stringsToStringByLine(
				"""
				16 17 18 19 29 39 49 59 69
				15 27 28 38 48 58 68 67 79
				14 26 47 57 56 55 54 66 78
				13 25 37 44 45 46 53 65 77
				12 24 36 35 34 33 43 64 76
				11 23 22 32 42 52 62 63 75
				21 31 41 51 61 71 72 73 74
				"""
			)
		);
	}

	@Test
	public void testRotateArray_0_0()
	{
		final int[] arr = new int[] { };
		Result.rotateArray(arr, 0);
		Assert.assertArrayEquals(new int[] { }, arr);
	}

	@Test
	public void testRotateArray_0_1()
	{
		final int[] arr = new int[] { };
		Result.rotateArray(arr, 1);
		Assert.assertArrayEquals(new int[] { }, arr);
	}

	@Test
	public void testRotateArray_1_0()
	{
		final int[] arr = new int[] { 1 };
		Result.rotateArray(arr, 0);
		Assert.assertArrayEquals(new int[] { 1 }, arr);
	}

	@Test
	public void testRotateArray_1_1()
	{
		final int[] arr = new int[] { 1 };
		Result.rotateArray(arr, 1);
		Assert.assertArrayEquals(new int[] { 1 }, arr);
	}

	@Test
	public void testRotateArray_1_1000()
	{
		final int[] arr = new int[] { 1 };
		Result.rotateArray(arr, 1000);
		Assert.assertArrayEquals(new int[] { 1 }, arr);
	}

	@Test
	public void testRotateArray_2_1()
	{
		final int[] arr = new int[] { 1, 2 };
		Result.rotateArray(arr, 1);
		Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
	}

	@Test
	public void testRotateArray_2_2()
	{
		final int[] arr = new int[] { 1, 2 };
		Result.rotateArray(arr, 2);
		Assert.assertArrayEquals(new int[] { 1, 2 }, arr);
	}

	@Test
	public void testRotateArray_2_1999()
	{
		final int[] arr = new int[] { 1, 2 };
		Result.rotateArray(arr, 1999);
		Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
	}

	@Test
	public void testRotateArray_3_2()
	{
		final int[] arr = new int[] { 1, 2, 3 };
		Result.rotateArray(arr, 2);
		Assert.assertArrayEquals(new int[] { 2, 3, 1 }, arr);
	}

	@Test
	public void testRotateArray_9_0()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 0);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}

	@Test
	public void testRotateArray_9_1()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 1);
		Assert.assertArrayEquals(new int[] { 9, 1, 2, 3, 4, 5, 6, 7, 8 }, arr);
	}

	@Test
	public void testRotateArray_9_2()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 2);
		Assert.assertArrayEquals(new int[] { 8, 9, 1, 2, 3, 4, 5, 6, 7 }, arr);
	}

	@Test
	public void testRotateArray_9_3()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 3);
		Assert.assertArrayEquals(new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 }, arr);
	}

	@Test
	public void testRotateArray_9_8()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 8);
		Assert.assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, arr);
	}

	@Test
	public void testRotateArray_9_9()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 9);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}

	@Test
	public void testRotateArray_9_79999()
	{
		final int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 79999);
		Assert.assertArrayEquals(new int[] { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, arr);
	}

	@Test
	public void testRotateArray_10_0()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 0);
		Assert.assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}

	@Test
	public void testRotateArray_10_1()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 1);
		Assert.assertArrayEquals(new int[] { 9, 0, 1, 2, 3, 4, 5, 6, 7, 8 }, arr);
	}

	@Test
	public void testRotateArray_10_2()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 2);
		Assert.assertArrayEquals(new int[] { 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 }, arr);
	}

	@Test
	public void testRotateArray_10_5()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 5);
		Assert.assertArrayEquals(new int[] { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 }, arr);
	}

	@Test
	public void testRotateArray_10_9()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 9);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, arr);
	}

	@Test
	public void testRotateArray_10_10()
	{
		final int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Result.rotateArray(arr, 10);
		Assert.assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}
}

