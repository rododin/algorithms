package org.rododin.algorithms.hackerrank.java.easy;

import java.util.BitSet;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-bitset/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java BitSet
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaBitSet
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final String[] nm = scanner.nextLine().split(" ");
		final int n = Integer.parseInt(nm[0]);
		final int m = Integer.parseInt(nm[1]);
		final BitSet set1 = new BitSet(n);
		final BitSet set2 = new BitSet(n);
		for (int i = 0; i < m; i++)
		{
			final String[] opDetails = scanner.nextLine().split(" ");
			final String op = opDetails[0];
			final int left = Integer.parseInt(opDetails[1]);
			final int right = Integer.parseInt(opDetails[2]);
			final BitSet setLeft = left == 1 ? set1 : set2;
			final BitSet setRight = right == 1 ? set1 : set2;
			switch (op)
			{
				case "AND":
					setLeft.and(setRight);
					break;
				case "OR":
					setLeft.or(setRight);
					break;
				case "XOR":
					setLeft.xor(setRight);
					break;
				case "FLIP":
					setLeft.flip(right);
					break;
				case "SET":
					setLeft.set(right);
					break;
			}
			System.out.printf("%d %d\n", set1.cardinality(), set2.cardinality());
		}
		scanner.close();
	}
}
