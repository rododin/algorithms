package org.rododin.algorithms.hackerrank;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.hackerrank.easy.AppleAndOrange;

/**
 * Just an app stub for quick testing.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class HackerRank
	implements Constants
{
	public static void main(String[] args)
	{
		AppleAndOrange.printCountApplesAndOranges(7, 10, 4, 12, new int[] {2, 3, -4}, new int[] {3, -2, -4});
		System.out.println();
		AppleAndOrange.printCountApplesAndOranges(7, 11, 5, 15, new int[] {-2, 2, 1}, new int[] {5, -6});
		System.out.println();
		AppleAndOrange.printCountApplesAndOranges(2, 3, 1, 5, new int[] {-2}, new int[] {-1});
		System.out.println();
		AppleAndOrange.printCountApplesAndOranges(5, 10, 0, 15
		                                         , new int[] {1, 2, 3, 5, 8, 10, 20, 25}
		                                         , new int[] {3, 4, 5, -2, -7, -9, -11, -15});
	}
}
