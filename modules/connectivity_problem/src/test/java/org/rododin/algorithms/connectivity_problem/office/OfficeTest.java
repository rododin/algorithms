package org.rododin.algorithms.connectivity_problem.office;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Tests for <code>{@link Office}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class OfficeTest
{
	private static final int[][] OFFICE_AREA_0 =
		{
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
		};
	private static final int OFFICE_RESULT_0 = 0;

	private static final int[][] OFFICE_AREA_1 =
		{
			{1, 1, 0, 0, 0},
			{1, 1, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 1, 1},
		};
	private static final int OFFICE_RESULT_1 = 3;

	private static final int[][] OFFICE_AREA_2 =
		{
			{1, 1, 1, 1, 1},
			{1, 1, 0, 0, 1},
			{1, 0, 0, 0, 0},
			{1, 1, 0, 1, 0},
		};
	private static final int OFFICE_RESULT_2 = 2;

	private static final int[][] OFFICE_AREA_3 =
		{
			{1, 1, 1, 1, 1},
			{1, 1, 0, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 1, 1, 1, 1},
		};
	private static final int OFFICE_RESULT_3 = 1;

	private static final int[][] OFFICE_AREA_4 =
		{
			{1, 1, 1, 1, 1},
			{1, 0, 0, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 0, 0, 1},
			{1, 1, 1, 1, 1},
		};
	private static final int OFFICE_RESULT_4 = 2;

	private static final int[][] OFFICE_AREA_5 =
		{
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
		};
	private static final int OFFICE_RESULT_5 = 1;

	private static final int[][] OFFICE_AREA_6 =
		{
			{1, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 1, 1, 0, 0, 1, 0},
			{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			{1, 1, 0, 1, 0, 0, 1, 0, 1, 1},
			{0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
			{0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
			{1, 1, 0, 1, 0, 0, 1, 0, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
			{0, 1, 0, 1, 1, 1, 0, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 0, 0, 0, 1},
		};
	private static final int OFFICE_RESULT_6 = 21;

	private static final int[][] OFFICE_AREA_7 =
		{
			{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
		};
	private static final int OFFICE_RESULT_7 = 1;

	private static final int[][] OFFICE_AREA_8 =
		{
			{1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 1},
			{1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
		};
	private static final int OFFICE_RESULT_8 = 6;

	private static final int[][] OFFICE_AREA_9 =
		{
		};
	private static final int OFFICE_RESULT_9 = 0;

	@Test
	public void testCountOfficesQuickImplementation()
	{
		Assert.assertEquals(OFFICE_RESULT_0, Office.countOfficesQuickImplementation(OFFICE_AREA_0));
		Assert.assertEquals(OFFICE_RESULT_1, Office.countOfficesQuickImplementation(OFFICE_AREA_1));
		Assert.assertEquals(OFFICE_RESULT_2, Office.countOfficesQuickImplementation(OFFICE_AREA_2));
		Assert.assertEquals(OFFICE_RESULT_3, Office.countOfficesQuickImplementation(OFFICE_AREA_3));
		Assert.assertEquals(OFFICE_RESULT_4, Office.countOfficesQuickImplementation(OFFICE_AREA_4));
		Assert.assertEquals(OFFICE_RESULT_5, Office.countOfficesQuickImplementation(OFFICE_AREA_5));
		Assert.assertEquals(OFFICE_RESULT_6, Office.countOfficesQuickImplementation(OFFICE_AREA_6));
		Assert.assertEquals(OFFICE_RESULT_7, Office.countOfficesQuickImplementation(OFFICE_AREA_7));
		Assert.assertEquals(OFFICE_RESULT_8, Office.countOfficesQuickImplementation(OFFICE_AREA_8));
		Assert.assertEquals(OFFICE_RESULT_9, Office.countOfficesQuickImplementation(OFFICE_AREA_9));
	}
}
