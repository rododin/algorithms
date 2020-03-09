package org.rododin.algorithms.hackerrank.java.easy;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-negative-subarray/problem">
 *   Practice > Java > Data Structures > Java Subarray
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSubArray
{
	public static int[] scanArray()
	{
		final Scanner scan = new Scanner(System.in);
		final int arraySize = Integer.parseInt(scan.nextLine());
		final String arrayStr = scan.nextLine();
		return parseArray(arrayStr, arraySize);
	}

	public static int[] parseArray(String arrayStr, int maxArraySize)
	{
		final String[] strs = arrayStr.split(" ");
		final int size = Math.min(strs.length, maxArraySize);
		final int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = Integer.parseInt(strs[i]);
		return array;
	}

	public static int countNegativeSubArrays(int[] array)
	{
		int numOfNegativeArrays = 0;
		for (int i = 0; i < array.length; i++)
		{
			int subArSum = 0;
			for (int j = i; j < array.length; j++)
			{
				subArSum += array[j];
				if (subArSum < 0)
					numOfNegativeArrays++;
			}
		}
		return numOfNegativeArrays;
	}

	public static int printNegativeSubArraysCount(int[] array)
	{
		System.out.println(array.length);
		for (int n : array)
			System.out.print(n + " ");
		final int rv = countNegativeSubArrays(array);
		System.out.println("\n" + rv);
		return rv;
	}
}
