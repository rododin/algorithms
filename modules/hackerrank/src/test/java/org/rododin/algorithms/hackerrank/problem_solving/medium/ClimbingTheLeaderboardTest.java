package org.rododin.algorithms.hackerrank.problem_solving.medium;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link ClimbingTheLeaderboard}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ClimbingTheLeaderboardTest
{
	@Test
	public void testBinarySearchInDescendingArray01()
	{
		doTestBinarySearchInDescendingArray(new int [] {}, 1, i -> i == 0);
	}

	@Test
	public void testBinarySearchInDescendingArray02()
	{
		doTestBinarySearchInDescendingArray(new int [] {1}, 1, i -> i == 0 || i == 1);
	}

	@Test
	public void testBinarySearchInDescendingArray03()
	{
		doTestBinarySearchInDescendingArray(new int [] {1, 1}, 1, i -> i >= 0 && i <= 2);
	}

	@Test
	public void testBinarySearchInDescendingArray04()
	{
		doTestBinarySearchInDescendingArray(new int [] {3, 2, 1}, 1, i -> i >= 2 && i <= 3);
	}

	@Test
	public void testBinarySearchInDescendingArray05()
	{
		doTestBinarySearchInDescendingArray(new int [] {3, 2, 1, 1}, 1, i -> i >= 2 && i <= 4);
	}

	@Test
	public void testBinarySearchInDescendingArray06()
	{
		doTestBinarySearchInDescendingArray(new int [] {3, 2, 1, 1, 1}, 1, i -> i >= 2 && i <= 5);
	}

	@Test
	public void testBinarySearchInDescendingArray07()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 1, i -> i >= 7 && i <= 10);
	}

	@Test
	public void testBinarySearchInDescendingArray08()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 5, i -> i >= 5 && i <= 7);
	}

	@Test
	public void testBinarySearchInDescendingArray09()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 6, i -> i == 5);
	}

	@Test
	public void testBinarySearchInDescendingArray10()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 9, i -> i >= 0 && i <= 1);
	}

	@Test
	public void testBinarySearchInDescendingArray11()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 12, i -> i == 0);
	}

	@Test
	public void testBinarySearchInDescendingArray12()
	{
		doTestBinarySearchInDescendingArray(new int [] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 0, i -> i == 10);
	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testFindPlaces01()
	{
		doTestFindPlaces(new int[] {}, new int[] {});
	}

	@Test
	public void testFindPlaces02()
	{
		doTestFindPlaces(new int[] {1}, new int[] {1});
	}

	@Test
	public void testFindPlaces03()
	{
		doTestFindPlaces(new int[] {1, 1}, new int[] {1, 1});
	}

	@Test
	public void testFindPlaces04()
	{
		doTestFindPlaces(new int[] {3, 2, 1}, new int[] {1, 2, 3});
	}

	@Test
	public void testFindPlaces05()
	{
		doTestFindPlaces(new int[] {3, 2, 1, 1}, new int[] {1, 2, 3, 3});
	}

	@Test
	public void testFindPlaces06()
	{
		doTestFindPlaces(new int[] {3, 2, 1, 1, 1}, new int[] {1, 2, 3, 3, 3});
	}

	@Test
	public void testFindPlaces07()
	{
		doTestFindPlaces(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, new int[] {1, 2, 2, 3, 3, 4, 4, 5, 5, 5});
	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testFindPlace01()
	{
		doTestFindPlace(new int[] {}, 1, 1);
	}

	@Test
	public void testFindPlace02()
	{
		doTestFindPlace(new int[] {1}, 1, 1);
	}

	@Test
	public void testFindPlace03()
	{
		doTestFindPlace(new int[] {1, 1}, 1, 1);
	}

	@Test
	public void testFindPlace04()
	{
		doTestFindPlace(new int[] {3, 2, 1}, 1, 3);
	}

	@Test
	public void testFindPlace05()
	{
		doTestFindPlace(new int[] {3, 2, 1, 1}, 1, 3);
	}

	@Test
	public void testFindPlace06()
	{
		doTestFindPlace(new int[] {3, 2, 1, 1, 1}, 1, 3);
	}

	@Test
	public void testFindPlace07()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 1, 5);
	}

	@Test
	public void testFindPlace08()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 5, 4);
	}

	@Test
	public void testFindPlace09()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 6, 4);
	}

	@Test
	public void testFindPlace10()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 9, 1);
	}

	@Test
	public void testFindPlace11()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 12, 1);
	}

	@Test
	public void testFindPlace12()
	{
		doTestFindPlace(new int[] {9, 8, 8, 7, 7, 5, 5, 1, 1, 1}, 0, 6);
	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testClimbingTheLeaderboard01()
	{
		doTestClimbingTheLeaderboard(new int[] {100, 90, 90, 80}, new int[] {70, 80, 105}, new int[] {4, 3, 1});
	}

	@Test
	public void testClimbingTheLeaderboard02()
	{
		doTestClimbingTheLeaderboard(new int[] {100, 100, 50, 40, 40, 20, 10}, new int[] {5, 25, 50, 120}, new int[] {6, 4, 2, 1});
	}

	@Test
	public void testClimbingTheLeaderboard03()
	{
		doTestClimbingTheLeaderboard(new int[] {100, 90, 90, 80, 75, 60}, new int[] {50, 65, 77, 90, 102}, new int[] {6, 5, 4, 2, 1});
	}

	@Test
	public void testClimbingTheLeaderboard04()
	{
		doTestClimbingTheLeaderboard
			( new int[] {997, 988, 981, 966, 957, 937, 933, 930, 929, 928, 927, 926, 922, 920, 916, 915, 903, 896, 887, 874, 872, 866, 863, 863, 860, 859, 858, 857, 857, 847, 847, 842, 830, 819, 815, 809, 803, 797, 796, 794, 794, 789, 785, 783, 778, 772, 765, 765, 764, 757, 755, 751, 744, 740, 737, 733, 730, 730, 724, 716, 710, 709, 691, 690, 684, 677, 676, 653, 652, 650, 625, 620, 619, 602, 587, 587, 585, 583, 571, 568, 568, 556, 552, 546, 541, 540, 538, 531, 530, 529, 527, 506, 504, 501, 498, 493, 493, 492, 489, 482, 475, 468, 457, 452, 445, 442, 441, 438, 435, 435, 433, 430, 429, 427, 422, 422, 414, 408, 404, 400, 396, 394, 387, 384, 380, 379, 374, 371, 369, 369, 369, 368, 366, 365, 363, 354, 351, 341, 337, 336, 328, 325, 318, 316, 314, 307, 306, 302, 287, 282, 281, 277, 276, 271, 246, 238, 236, 230, 229, 229, 228, 227, 220, 212, 199, 194, 179, 173, 171, 168, 150, 144, 136, 125, 125, 124, 122, 118, 98, 98, 95, 92, 88, 85, 70, 68, 61, 60, 59, 44, 43, 35, 32, 30, 28, 23, 20, 13, 12, 12}
			, new int[] {83, 129, 140, 184, 198, 300, 312, 325, 341, 344, 349, 356, 370, 405, 423, 444, 465, 471, 491, 500, 506, 508, 539, 543, 569, 591, 607, 612, 614, 623, 645, 670, 689, 726, 744, 747, 764, 773, 777, 787, 805, 811, 819, 829, 841, 905, 918, 918, 955, 997}
			, new int[] {169, 160, 159, 153, 152, 136, 133, 129, 125, 125, 125, 123, 118, 108, 105, 97, 94, 93, 90, 87, 84, 84, 79, 77, 73, 69, 68, 68, 68, 66, 65, 62, 59, 53, 48, 48, 44, 42, 42, 39, 34, 33, 31, 31, 30, 17, 15, 15, 6, 1}
			);
	}

// ---------------------------------------------------------------------------------------------------------------------

	private static List<Integer> arrayToList(int[] array)
	{
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	private static void doTestBinarySearchInDescendingArray(int[] array, int value, Predicate<Integer> assertionPredicate)
	{
		final int i = ClimbingTheLeaderboard.binarySearchInDescendingArray(array, value);
		System.out.println("binarySearchInDescendingArray: value=" + value + ", array=" + arrayToList(array) + " -> " + i);
		Assert.assertTrue(assertionPredicate.test(i));
	}

	private static void doTestFindPlaces(int[] scores, int[] expectedPlaces)
	{
		final int[] places = ClimbingTheLeaderboard.findPlaces(scores);
		System.out.println("findPlaces: scores=" + arrayToList(scores) + " -> " + arrayToList(places));
		Assert.assertArrayEquals(expectedPlaces, places);
	}

	private static void doTestFindPlace(int[] scores, int aliceScore, int expectedPlace)
	{
		final int place = ClimbingTheLeaderboard.findPlace(scores, ClimbingTheLeaderboard.findPlaces(scores), aliceScore);
		System.out.println("findPlace: aliceScore=" + aliceScore + ", scores=" + arrayToList(scores) + " -> " + place);
		Assert.assertEquals(expectedPlace, place);
	}

	private static void doTestClimbingTheLeaderboard(int[] scores, int[] aliceScores, int[] expectedPlaces)
	{
		final int[] places = ClimbingTheLeaderboard.climbingLeaderboard(scores, aliceScores);
		System.out.println("climbingTheLeaderboard: scores=" + arrayToList(scores) + ", aliceScores=" + arrayToList(aliceScores) + " -> " + arrayToList(places));
		Assert.assertArrayEquals(expectedPlaces, places);
	}
}
